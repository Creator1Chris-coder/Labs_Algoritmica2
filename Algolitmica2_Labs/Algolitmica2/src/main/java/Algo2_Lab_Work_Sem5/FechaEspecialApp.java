package Algo2_Lab_Work_Sem5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class FechaEspecialApp extends ConsolaApp {

    public void iniciar() {
        String input = leerLinea("Ingrese una fecha en formato YYYY-MM-DD: ");
        try {
            LocalDate fecha = LocalDate.parse(input);
            DayOfWeek dia = fecha.getDayOfWeek();
            String nombreDia = dia.getDisplayName(TextStyle.FULL, Locale.getDefault());

            System.out.println("Día de la semana: " + nombreDia);

            if (esFeriado(fecha)) {
                System.out.println("¡Es un día feriado!");
            } else {
                System.out.println("No es feriado.");
            }
        } catch (Exception e) {
            System.out.println("Formato inválido de fecha.");
        }
    }

    private boolean esFeriado(LocalDate fecha) {
        return (fecha.getMonthValue() == 1 && fecha.getDayOfMonth() == 1) ||
               (fecha.getMonthValue() == 12 && fecha.getDayOfMonth() == 25);
    }

    public static void main(String[] args) {
        new FechaEspecialApp().iniciar();
    }
}
