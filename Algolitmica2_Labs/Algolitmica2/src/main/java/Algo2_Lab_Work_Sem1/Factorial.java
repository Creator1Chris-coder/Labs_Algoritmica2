package Algo2_Lab_Work_Sem1;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese un valor: ");
        int num = scan.nextInt();
        long fact = factorial(num);
        System.out.printf("El factorial de %d es %d.\n", num, fact);
        scan.close();
    }

    public static long factorial(int n) {
        if (n < 0) return -1; 
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
