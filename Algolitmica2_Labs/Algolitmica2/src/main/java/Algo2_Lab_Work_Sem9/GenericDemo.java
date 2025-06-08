package Algo2_Lab_Work_Sem9;

import java.util.*;

public class GenericDemo {
	@SuppressWarnings("unused")
	private static void rawdemo() {
		List<String> lista = new ArrayList<>();
		lista.add("un string");
	}

	public static <T> boolean contiene(T[] anArray, T elem) {
		for (T e : anArray)
			if (e.equals(elem))
				return true;
		return false;
	}

	private static void demoContiene() {
		Integer[] enteros = { 2, 4, 6, 8, 10 };
		System.out.println("¿Contiene 10? " + contiene(enteros, 10));
		System.out.println("¿Contiene 5? " + contiene(enteros, 5));

		String[] cadenas = { "Java", "Python", "Rust", "Go" };
		System.out.println("¿Contiene 'Rust'? " + contiene(cadenas, "Rust"));
		System.out.println("¿Contiene 'F#'? " + contiene(cadenas, "F#"));
	}

	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
		int count = 0;
		for (T e : anArray)
			if (e.compareTo(elem) > 0)
				++count;
		return count;
	}

	private static void demoCountGreaterThan() {
		Integer[] enteros = { 2, 4, 6, 8, 10 };
		System.out.println("Elementos > 6: " + countGreaterThan(enteros, 6));

		String[] cadenas = { "Java", "Python", "Rust", "Go" };
		System.out.println("Elementos > 'Java': " + countGreaterThan(cadenas, "Java"));

		Cat[] cs = {
			new Cat("miaomi1"),
			new Cat("miaomi2"),
			new Cat("miaomi3")
		};
		System.out.println("Gatos > miaomi2: " + countGreaterThan(cs, new Cat("miaomi2")));
	}

	public static void sortDemo() {
		List<Integer> lista1 = List.of(30, 20, 10);
		List<Integer> lista2 = new ArrayList<>(lista1);
		Collections.sort(lista2);
		System.out.println("Orden natural de enteros: " + lista2);

		List<Persona> ps = new ArrayList<>();
		ps.add(new Persona("DNI", "32345678"));
		ps.add(new Persona("DNI", "22345678"));
		ps.add(new Persona("DNI", "12345678"));
		ps.add(new Persona("AAA", "92345678"));

		Collections.sort(ps, new PersonaDocComparator());
		System.out.println("Orden por Comparator: " + ps);

		List<Persona> ps2 = new ArrayList<>(ps);
		Collections.sort(ps2);
		System.out.println("Orden por Comparable: " + ps2);
	}

	public static void main(String[] args) {
		demoContiene();
		demoCountGreaterThan();
		sortDemo();
	}
}

class PersonaDocComparator implements Comparator<Persona> {
	@Override
	public int compare(Persona o1, Persona o2) {
		int result = o1.getDocTipo().compareTo(o2.getDocTipo());
		if (result == 0) {
			return o1.getDocNum().compareTo(o2.getDocNum());
		}
		return result;
	}
}
