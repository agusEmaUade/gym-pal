package com.gym.pal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Ejercicio {
    private String nombre;
    private int repeticiones;
    private int series;
    private int peso_asignado;
    private String exigencia_muscular;
    // private file video;
    private Nivel nivel;






    public void mostrarDetalles() {
        System.out.println("Ejercicio: " + nombre);
        System.out.println("Repeticiones: " + repeticiones);
        System.out.println("Series: " + series);
        System.out.println("Peso asignado: " + peso_asignado + " kg");
        System.out.println("Exigencia muscular: " + exigencia_muscular);
        System.out.println("Nivel: " + nivel);
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {

        Ejercicio sentadilla = new Ejercicio("Sentadilla", 12, 4, 60, "Piernas", Nivel.BAJO);

        Ejercicio pressDeBanca = new Ejercicio("Press de Banca", 10, 3, 80, "Pectorales", Nivel.ALTO);

        Ejercicio curlDeBiceps = new Ejercicio("Curl de Bíceps", 15, 4, 20, "Bíceps", Nivel.MEDIO);

        // Mostrar detalles de los ejercicios
        sentadilla.mostrarDetalles();
        pressDeBanca.mostrarDetalles();
        curlDeBiceps.mostrarDetalles();
    }
}
