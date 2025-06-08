package Algo2_Lab_Work_Sem3;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class MensajePorDia2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dia = -1;

        while (dia < 1 || dia > 7) {
            System.out.print("Ingrese un número del 1 al 7 correspondiente al día de la semana: ");
            if (scanner.hasNextInt()) {
                dia = scanner.nextInt();
                if (dia < 1 || dia > 7) {
                    System.out.println("Número fuera de rango. Intente nuevamente.");
                }
            } else {
                System.out.println("Entrada no válida. Intente con un número.");
                scanner.next(); 
            }
        }

        mostrarMensaje(dia);
        scanner.close();
    }

    public static void mostrarMensaje(int dia) {
        DayOfWeek diaSemana = DayOfWeek.of(dia % 7 == 0 ? 7 : dia);
        String nombreDia = diaSemana.getDisplayName(TextStyle.FULL, Locale.getDefault());

        String mensaje;
        switch (dia) {
            case 1 -> mensaje = "Algo2";
            case 2 -> mensaje = "GPS";
            case 3 -> mensaje = "MAE";
            case 4 -> mensaje = "Programación";
            case 5 -> mensaje = "Análisis";
            case 6 -> mensaje = "Laboratorio";
            case 7 -> mensaje = "Descanso";
            default -> mensaje = "Día inválido.";
        }

        System.out.printf("Hoy es %s: %s\n", nombreDia, mensaje);
    }
}
