package es.deusto.prog3.cap01.resueltos;

public class OperacionesConArray {
	
	public static void sumarAPosicion(int[] array, int posicion, int numero) {
		array[posicion] = array[posicion] + numero;
	}
	
	public static int sumarPosiciones(int[] array) {
		int total = 0;
		for(int i=0; i< array.length; i++) {
			total += array[i];
		}
		return total;
	}
}
