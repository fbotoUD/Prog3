package es.deusto.prog3.cap00.resueltos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Diccionario {
    private TreeMap<String, List<String>> diccionario;

    public Diccionario() {
        diccionario = new TreeMap<>();
    }

    // Agregar una palabra con su definición al diccionario
    public void agregarPalabra(String palabra, String definicion) {
    	/*
    	 * Esta instrucción permite agregar una definición (definicion) a una entrada (palabra) del diccionario.
    	 * Si la palabra ya existe en el diccionario, la definición se agrega a la lista existente de definiciones asociadas.
    	 * Si la palabra no existe en el diccionario, se crea una nueva lista de definiciones y se asocia con la palabra en el diccionario
    	 * antes de agregar la definición. 
    	 */
//        diccionario.computeIfAbsent(palabra, k -> new ArrayList<>()).add(definicion);
    	
    	//El siguiente trozo de código es lo que haría la instrucción anterior 
        
    	
     // Verificar si la palabra ya existe
        if (diccionario.containsKey(palabra)) {
        	diccionario.get(palabra).add(definicion); // Agrega la puntuación a la lista existente
        } else {
            List<String> definiciones = new ArrayList<>();
            definiciones.add(definicion); // Crear una nueva lista y agregar la puntuación
            diccionario.put(palabra,definiciones);
        }
    }

    // Obtener las definiciones de una palabra
    public List<String> obtenerDefiniciones(String palabra) {
    	//Devuelve una lista vacía
        return diccionario.getOrDefault(palabra, new ArrayList<>());
        //Devuelve null
//    	return diccionario.get(palabra);
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
        diccionario.agregarPalabra("Gerifalte", "Halcón de gran tamaño, que vive ordinariamente en el norte de Europa.");

        System.out.println("Definiciones de 'Zafacoca': " + diccionario.obtenerDefiniciones("Zafacoca"));
        System.out.println("Definiciones de 'Gerifalte': " + diccionario.obtenerDefiniciones("Gerifalte"));

        diccionario.eliminarPalabra("Zafacoca");

        System.out.println("\nDiccionario completo:");
        diccionario.mostrarDiccionario();
    }
}

