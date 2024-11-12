package com.gym.pal.service.impl;

import com.gym.pal.dto.*;
import com.gym.pal.model.*;
import com.gym.pal.repository.IEjercicioRepository;
import com.gym.pal.repository.ISocioRepository;
import com.gym.pal.service.SocioService;
import com.gym.pal.service.autenticacion.IAutenticacion;
import com.gym.pal.service.notificacion.INotificador;
import com.gym.pal.service.objetivo.BajarDePeso;
import com.gym.pal.service.objetivo.MantenerFigura;
import com.gym.pal.service.objetivo.Objetivo;
import com.gym.pal.service.objetivo.TonificarCuerpo;
import com.gym.pal.service.observer.IObserver;
import com.gym.pal.service.observer.ObservadorNotificacion;
import com.gym.pal.service.observer.ObservadorTrofeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class SocioServiceImpl implements SocioService {
    @Autowired
    private ISocioRepository repository;

    @Autowired
    private IEjercicioRepository ejercicioRepository;

    @Autowired
    private IAutenticacion autenticacionService;

    @Autowired
    private INotificador notificadorSerivice;

    private List<IObserver> listObservers = new ArrayList<>();

    private final Function<CreateSocioDto, Socio> mapToSocio = new SocioRequestToSocio();
    private final Function<Socio, SocioDto> mapToSocioDto = new SocioToSocioDto();

    private final Function<MedicionDto, Medicion> mapToMedicion = new MedicionDtoToMedicion();

    @Override
    public SocioDto crear(CreateSocioDto request) {
        Optional<Socio> socioBd = repository
                .findByEmailAndPass(request.getEmail(), request.getPass());

        if (socioBd.isPresent()) {
            throw new RuntimeException("socio ya registrado");
        }

        Socio socio = mapToSocio.apply(request);

        if (!autenticacionService.registrar(request.getEmail(), request.getPass())) {
            throw new RuntimeException("no se pudo registrar");
        }

        repository.crear(socio);

        return mapToSocioDto.apply(socio);
    }

    @Override
    public SocioDto login(LoginSocioDto request) {
        Socio socio = repository
                .findByEmailAndPass(request.getEmail(), request.getPass())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        if (!autenticacionService.login(request.getEmail(), request.getPass())) {
            throw new RuntimeException("Socio no registrar");
        }

        return mapToSocioDto.apply(socio);
    }

    @Override
    public String registroPeso(String socioId, MedicionDto dto) {
        boolean estaCumplido;
        Medicion nuevaMedicion = mapToMedicion.apply(dto);
        repository.actualizarMediciones(socioId, nuevaMedicion);
        var socioOptional = repository.findById(socioId);
        Socio socio = socioOptional.get();
        if (socio.getObjetivo() != null) {
            Objetivo objetivo = socio.getObjetivo();
            switch (objetivo.getType()) {
                case "bajarDePeso":
                    estaCumplido = ((BajarDePeso) objetivo).cumpleObjetivo(socio);
                    break;
                case "tonificarCuerpo":
                    estaCumplido = ((TonificarCuerpo) objetivo).cumpleObjetivo(socio);
                    break;
                case "mantenerFigura":
                    estaCumplido = ((MantenerFigura) objetivo).cumpleObjetivo(socio);
                    break;
                default:
                    throw new RuntimeException("objetivo invalido");
            }
        } else {

            throw new RuntimeException("El socio no tiene un objetivo asignado.");
        }

        if (Boolean.TRUE.equals(estaCumplido)) {
            addTrophy(socio, TipoDeTrofeoDto.DEDICACION);
        }
        if (Boolean.TRUE.equals(socio.getMediciones().stream().count() > 3)) {
            addTrophy(socio, TipoDeTrofeoDto.CREIDO);
        }
        return "medicion registrada";
    }

    @Override
    public String registrarObjetivo(String socioId, String tipoObjetivo) {
        Objetivo iniciarObjetivo;
        List<Ejercicio> ejercicioList = new ArrayList<>();
        switch (tipoObjetivo) {
            case "bajarDePeso":
                iniciarObjetivo = new BajarDePeso();
                ejercicioList = ejercicioRepository.getEjerciciosBajarDePeso();
                ((BajarDePeso) iniciarObjetivo).crearRutina(initEntrenamiento(60, ejercicioList));
                break;
            case "tonificarCuerpo":
                iniciarObjetivo = new TonificarCuerpo();
                ejercicioList = ejercicioRepository.getEjerciciosTonificarCuerpo();
                ((TonificarCuerpo) iniciarObjetivo).crearRutina(initEntrenamiento(120, ejercicioList));
                break;
            case "mantenerFigura":
                iniciarObjetivo = new MantenerFigura();
                ejercicioList = ejercicioRepository.getEjerciciosMantenerFigura();
                ((MantenerFigura) iniciarObjetivo).crearRutina(initEntrenamiento(45, ejercicioList));
                break;
            default:
                throw new RuntimeException("objetivo invalido");
        }
        repository.setearObjetivo(socioId, iniciarObjetivo);
        return "objetivo registrado";
    }

    private List<Entrenamiento> initEntrenamiento(int horaEnMinutos, List<Ejercicio> ejercicioList) {
        List<Musculo> musculos = List.of(Musculo.PECHO, Musculo.BRAZOS, Musculo.ESPALDA);
        List<Entrenamiento> entrenamientos = new ArrayList<>();

        for (int i = 0; i < musculos.size(); i++) {
            Entrenamiento entrenamiento = Entrenamiento.builder()
                    .horas(horaEnMinutos)
                    .ejercicios(ejercicioList)
                    .dias(i + 1)
                    .musculo(musculos.get(i))
                    .build();
            entrenamientos.add(entrenamiento);
        }

        return entrenamientos;
    }


    private void addTrophy(Socio socio, TipoDeTrofeoDto trofeoDto) {
        attach(new ObservadorNotificacion());
        attach(new ObservadorTrofeo());
        listObservers.forEach(o -> o.agregarTrofeo(socio, trofeoDto));
    }

    private void attach(IObserver observer) {
        listObservers.add(observer);
    }
}
