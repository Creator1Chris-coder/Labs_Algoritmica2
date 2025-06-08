package Algo2_Lab_Work_Sem5;

public class BasicLibDemo3 extends ConsolaApp {

    public static final double PI = Math.PI;

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n--- Menú Básico ---");
            System.out.println("1. Calcular círculo");
            System.out.println("2. Reemplazar cadenas");
            System.out.println("3. Salir");
            opcion = leerEntero("Seleccione opción: ", 1, 3);

            switch (opcion) {
                case 1 -> procesarCirculo();
                case 2 -> procesarCadena();
                case 3 -> System.out.println("Saliendo...");
            }
        } while (opcion != 3);
    }

    private void procesarCirculo() {
        double radio = leerDouble("Ingrese el radio: ");
        double area = PI * radio * radio;
        double circunferencia = 2 * PI * radio;

        System.out.printf("El área del círculo con radio (%.3f) es %.3f (%.3f * %.3f * %.3f).\n",
                radio, area, PI, radio, radio);
        System.out.println("Resumen de datos:");
        System.out.printf("%10s: %8.3f\n", "radio", radio);
        System.out.printf("%10s: %8.3f\n", "área", area);
        System.out.printf("%10s: %8.3f\n", "circunf.", circunferencia);
    }

    private void procesarCadena() {
        String texto = leerLinea("Ingrese una cadena: ");
        String buscar = leerLinea("Subcadena a reemplazar: ");
        String nueva = leerLinea("Nueva subcadena: ");

        System.out.println("Reemplazo total     : " + texto.replace(buscar, nueva));
        System.out.println("Solo primera ocurr. : " + texto.replaceFirst(buscar, nueva));
    }

    public static void main(String[] args) {
        new BasicLibDemo3().iniciar();
    }
}
