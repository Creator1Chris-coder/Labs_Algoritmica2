package Algo2_Lab_Work_Sem2;

import java.util.Scanner;

public class BasicLibDemo {

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
            scanner.nextLine(); // limpiar buffer

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

        double area = PI * Math.pow(radio, 2);
        double circunferencia = 2 * PI * radio;

        System.out.printf("Área del círculo: %.2f\n", area);
        System.out.printf("Circunferencia del círculo: %.2f\n", circunferencia);
    }

    public static void procesarCadena(Scanner scanner) {
        System.out.print("Ingrese una cadena de texto: ");
        String texto = scanner.nextLine();

        System.out.print("Ingrese la subcadena que desea reemplazar: ");
        String subcadena = scanner.nextLine();

        System.out.print("Ingrese la nueva subcadena: ");
        String nueva = scanner.nextLine();

        // Reemplaza todas las ocurrencias
        String resultado = texto.replace(subcadena, nueva);
        System.out.println("Resultado: " + resultado);

        // Solo primera ocurrencia (para 2.5)
        String resultadoPrimera = texto.replaceFirst(subcadena, nueva);
        System.out.println("Reemplazo solo primera ocurrencia: " + resultadoPrimera);
    }
}
