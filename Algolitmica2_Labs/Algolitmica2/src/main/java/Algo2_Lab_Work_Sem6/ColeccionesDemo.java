package Algo2_Lab_Work_Sem6;

import java.util.*;

public class ColeccionesDemo {
    public static void main(String[] args) {
        // ===== LISTAS =====
        List<String> lista = new ArrayList<>();
        lista.add("Uno");
        lista.add("Dos");
        lista.add("Tres");
        System.out.println("Lista (ArrayList): " + lista);

        List<String> listaEnlazada = new LinkedList<>();
        listaEnlazada.add("A");
        listaEnlazada.add("B");
        listaEnlazada.add("C");
        System.out.println("Lista (LinkedList): " + listaEnlazada);

        // ===== COLAS =====
        Queue<String> cola = new PriorityQueue<>();
        cola.offer("Zebra");
        cola.offer("Elefante");
        cola.offer("Antílope");
        System.out.println("Cola (PriorityQueue):");
        while (!cola.isEmpty()) {
            System.out.println(" - " + cola.poll());
        }

        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Primero");
        deque.addLast("Último");
        System.out.println("Deque (ArrayDeque): " + deque);

        // ===== CONJUNTOS =====
        Set<String> conjunto = new HashSet<>();
        conjunto.add("Rojo");
        conjunto.add("Verde");
        conjunto.add("Azul");
        conjunto.add("Verde"); 
        System.out.println("Set (HashSet): " + conjunto);

        Set<String> conjuntoOrdenado = new TreeSet<>();
        conjuntoOrdenado.add("Perú");
        conjuntoOrdenado.add("Argentina");
        conjuntoOrdenado.add("Chile");
        System.out.println("Set Ordenado (TreeSet): " + conjuntoOrdenado);

        Set<String> conjuntoLinked = new LinkedHashSet<>();
        conjuntoLinked.add("X");
        conjuntoLinked.add("Y");
        conjuntoLinked.add("Z");
        System.out.println("Set (LinkedHashSet - orden de inserción): " + conjuntoLinked);
    }
}
