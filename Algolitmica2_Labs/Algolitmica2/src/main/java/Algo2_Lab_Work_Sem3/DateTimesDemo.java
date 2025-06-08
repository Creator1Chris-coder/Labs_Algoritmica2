package Algo2_Lab_Work_Sem3;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DateTimesDemo {

	@SuppressWarnings("deprecation")
	void showAhora() {
		System.out.println("Este momento es:");
		System.out.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS:%1$tN%n", LocalDateTime.now());
		System.out.format("%1$tA %1$te, %1$tB, %1$tY %1$tl %1$tp %1$tM min %1$tS sec %n",LocalDateTime.now());
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE dd/MMMM/yyyy HH:mm:ss", new Locale("es", "PE"))));
	
		System.out.format("%nEste momento en otras ciudades:%n");
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("EEEE dd/MMMM/yyyy HH:mm:ss");
		LocalDateTime ahoraEnSaoPaulo = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));  //"UTC-05:00" "Australia/Sydney" "America/Sao_Paulo"
		System.out.format("Sao Paulo: %s", ahoraEnSaoPaulo.format(dtFormat));

		System.out.format("Sydney: %s", "Por hacer");
		System.out.format("Sydney: %s", "Por hacer");
		
	}
	
	void showFechasConocidas(){
		MonthDay sanPedro = MonthDay.of(Month.JUNE, 29);
		LocalDate esteSanPedro = sanPedro.atYear(Year.now().getValue());
		LocalDate este28DeJulio = Year.now().atMonth(Month.JULY).atDay(28);
		LocalDate este28DeJulio_2 = LocalDate.of(Year.now().getValue(), Month.JULY, 28);
		LocalDate esteSantaRosa = null;
		LocalDate esteInicioDePrimavera = null;
	}
	
	void showFeriados(){
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("EEEE dd/MMMM/yyyy", new Locale("es", "PE"));
		List<LocalDate> feriadosDelAnio = Arrays.asList(
				LocalDate.of(Year.now().getValue(), Month.JANUARY, 1),
				LocalDate.of(Year.now().getValue(), Month.JULY, 28),
				LocalDate.of(Year.now().getValue(), Month.DECEMBER, 25)				
				);
		
		System.out.format("%n%nLos dias feriados del año son:%n");
		for (LocalDate feriado: feriadosDelAnio) {
			System.out.format("%s%n", feriado.format(dtFormat));
		}
	}

	void showFechasDiversas(){
		Instant inicio = Instant.now();
		LocalDateTime mananaLaMismaHora = LocalDateTime.now().plusDays(1);
		LocalDateTime ayerLaMismaHora = null; 
		LocalDateTime pasadoMananaLaMismaHora = null; 
		LocalDateTime comoHoyDelSgteMes = LocalDateTime.now().plusMonths(1);
		LocalDateTime unaSemanaAnteDeSantaRosa = null;
		LocalDateTime unaHoraAnteDelInicioDeLaProximaClase = null;
		Instant termino = Instant.now();
		Duration transcurrido = Duration.between(inicio, termino);
		System.out.format("El tiempo transcurrido es de %d segundos y %d nanosegundos%n", transcurrido.getSeconds(), transcurrido.getNano());
	}
	
	public static void main(String[] args) {
		DateTimesDemo demo = new DateTimesDemo();
		demo.showAhora();
		demo.showFeriados();
	}

}