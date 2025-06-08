package Algo2_Lab_Work_Sem2;

import java.util.Scanner;

public class MensajePorDia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dia = -1;

        while (dia < 1 || dia > 7) {
            System.out.print("Ingrese un número del 1 al 7 correspondiente al día de la semana: ");
            if (scanner.hasNextInt()) {
                dia = scanner.nextInt();
                if (dia < 1 || dia > 7) {
                    System.out.println("Día inválido. Intente de nuevo.");
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
        String[] mensajeDia = {
            "Algo2",     // 1
            "GPS",       // 2
            "MAE",       // 3
            "Programación", // 4
            "Análisis",  // 5
            "Laboratorio", // 6
            "Descanso"   // 7
        };

        if (dia >= 1 && dia <= 7) {
            System.out.printf("Mensaje para el día %d: %s\n", dia, mensajeDia[dia - 1]);
        } else {
            System.out.println("Día fuera de rango.");
        }

        switch (dia) {
            case 1 -> System.out.println("Algo2");
            case 2 -> System.out.println("GPS");
            case 3 -> System.out.println("MAE");
            case 4 -> System.out.println("Programación");
            case 5 -> System.out.println("Análisis");
            case 6 -> System.out.println("Laboratorio");
            case 7 -> System.out.println("Descanso");
            default -> System.out.println("Día inválido.");
        }
    }
}
