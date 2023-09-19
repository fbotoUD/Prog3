package es.deusto.prog3.cap00;

import java.util.HashMap;
import java.util.Map;

public class EjemploHashMap {
	public static void main(String[] args) {
        // Crear un HashMap para almacenar nombres y edades
        Map<String, Integer> mapaDePersonas = new HashMap<>();

        // Agregar datos al HashMap
        mapaDePersonas.put("Alice", 25);
        mapaDePersonas.put("Bob", 30);
        mapaDePersonas.put("Charlie", 28);
        mapaDePersonas.put("David", 22);

        // Acceder a los valores a través de las claves
        String nombreBuscado = "Bob";
        if (mapaDePersonas.containsKey(nombreBuscado)) {
            int edad = mapaDePersonas.get(nombreBuscado);
            System.out.println(nombreBuscado + " tiene " + edad + " años.");
        } else {
            System.out.println(nombreBuscado + " no se encuentra en el mapa.");
        }

        // Iterar a través de las claves y valores del HashMap
        System.out.println("\nLista de personas y edades:");
        for (Map.Entry<String, Integer> entrada : mapaDePersonas.entrySet()) {
            String nombre = entrada.getKey();
            int edad = entrada.getValue();
            System.out.println(nombre + ": " + edad + " años");
        }
    }
}
