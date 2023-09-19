package es.deusto.prog3.cap00.resueltos;

import java.util.ArrayList;
import java.util.TreeMap;

public class Diccionario {
    private TreeMap<String, ArrayList<String>> diccionario;

    public Diccionario() {
        diccionario = new TreeMap<>();
    }

    // Agregar una palabra con su definición al diccionario
    public void agregarPalabra(String palabra, String definicion) {
        diccionario.computeIfAbsent(palabra, k -> new ArrayList<>()).add(definicion);
    }

    // Obtener las definiciones de una palabra
    public ArrayList<String> obtenerDefiniciones(String palabra) {
        return diccionario.getOrDefault(palabra, new ArrayList<>());
    }

    // Eliminar una palabra del diccionario
    public void eliminarPalabra(String palabra) {
        diccionario.remove(palabra);
    }

    // Mostrar todo el diccionario
    public void mostrarDiccionario() {
        for (String palabra : diccionario.keySet()) {
            System.out.println(palabra + ": " + diccionario.get(palabra));
        }
    }

    public static void main(String[] args) {
        Diccionario diccionario = new Diccionario();

        diccionario.agregarPalabra("Zafacoca", "Sustantivo femenino que significa un malentendido o una confusión, especialmente en una conversación o situación.");
        diccionario.agregarPalabra("Obnubilar", "Verbo que significa confundir, turbar o entenebrecer la mente o la vista de alguien.");
        diccionario.agregarPalabra("Gerifalte", " Halcón de gran tamaño, que vive ordinariamente en el norte de Europa.");

        System.out.println("Definiciones de 'Zafacoca': " + diccionario.obtenerDefiniciones("Zafacoca"));
        System.out.println("Definiciones de 'Gerifalte': " + diccionario.obtenerDefiniciones("Gerifalte"));

        diccionario.eliminarPalabra("Zafacoca");

        System.out.println("\nDiccionario completo:");
        diccionario.mostrarDiccionario();
    }
}

