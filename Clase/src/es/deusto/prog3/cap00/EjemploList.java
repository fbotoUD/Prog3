package es.deusto.prog3.cap00;

import java.util.ArrayList;
import java.util.List;

public class EjemploList {
	public static void main(String[] args) {
        // Creamos una lista de enteros utilizando genericidad
        List<Integer> listaDeEnteros = new ArrayList<>();

        // Agregamos elementos a la lista
        listaDeEnteros.add(10);
        listaDeEnteros.add(20);
        listaDeEnteros.add(30);

        // Accedemos a los elementos de la lista y los imprimimos
        for (Integer numero : listaDeEnteros) {
            System.out.println(numero);
        }
    }
}
