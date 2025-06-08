package Algo2_Lab_Work_Sem5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsolaApp {
    protected final Scanner scanner = new Scanner(System.in);

    protected int leerEntero(String mensaje, int min, int max) {
        int valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextInt();
                scanner.nextLine(); 
                if (valor >= min && valor <= max) return valor;
                System.out.println("Valor fuera de rango.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Intente con un número.");
                scanner.nextLine(); 
            }
        }
    }

    protected double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                scanner.nextLine();
            }
        }
    }

    protected String leerLinea(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
