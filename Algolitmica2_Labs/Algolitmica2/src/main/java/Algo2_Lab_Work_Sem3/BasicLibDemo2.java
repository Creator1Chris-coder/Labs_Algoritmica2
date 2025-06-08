package Algo2_Lab_Work_Sem3;

import java.util.Scanner;

public class BasicLibDemo2 {

    public static final double PI = Math.PI;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Calcular área y circunferencia de un círculo");
            System.out.println("2. Trabajar con cadenas");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1 -> procesarCirculo(scanner);
                case 2 -> procesarCadena(scanner);
                case 3 -> {
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    public static void procesarCirculo(Scanner scanner) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = scanner.nextDouble();

        double area = PI * radio * radio;
        double circunferencia = 2 * PI * radio;

        System.out.printf("El área del círculo con radio (%.3f) es %.3f (%.3f * %.3f * %.3f).\n",
                radio, area, PI, radio, radio);

        System.out.println("Resumen de datos:");
        System.out.printf("%10s: %8.3f\n", "radio", radio);
        System.out.printf("%10s: %8.3f\n", "área", area);
        System.out.printf("%10s: %8.3f\n", "circunf.", circunferencia);
    }

    public static void procesarCadena(Scanner scanner) {
        System.out.print("Ingrese una cadena de texto: ");
        String texto = scanner.nextLine();

        System.out.print("Ingrese la subcadena que desea reemplazar: ");
        String subcadena = scanner.nextLine();

        System.out.print("Ingrese la nueva subcadena: ");
        String nueva = scanner.nextLine();

        String resultado = texto.replace(subcadena, nueva);
        String resultadoPrimera = texto.replaceFirst(subcadena, nueva);

        System.out.println("Reemplazo total     : " + resultado);
        System.out.println("Solo primera ocurr. : " + resultadoPrimera);
    }
}
