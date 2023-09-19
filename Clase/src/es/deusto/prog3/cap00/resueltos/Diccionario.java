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

        diccionario.agregarPalabra("perro", "Animal doméstico de la familia de los cánidos.");
        diccionario.agregarPalabra("gato", "Animal doméstico de la familia de los felinos.");
        diccionario.agregarPalabra("perro", "Término coloquial para referirse a un amigo fiel.");

        System.out.println("Definiciones de 'perro': " + diccionario.obtenerDefiniciones("perro"));
        System.out.println("Definiciones de 'gato': " + diccionario.obtenerDefiniciones("gato"));

        diccionario.eliminarPalabra("gato");

        System.out.println("\nDiccionario completo:");
        diccionario.mostrarDiccionario();
    }
}

