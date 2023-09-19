package es.deusto.prog3.cap00;

public class PrimitivosVsObjetos {

	public static void main(String[] args) {
		int a = 5;
		int b = a;
		b = 10;    // Cambiar ‘b’ afecta al valor de ‘a’
		System.out.println(a); // Qué se imprime?
		
		class MiClase {
		    int valor;
		    MiClase(int v) { valor = v; }
		}

		MiClase obj1 = new MiClase(5);
		MiClase obj2 = obj1; 
		obj2.valor = 10;     // Cambiar obj2 afecta a obj1?
		System.out.println(obj1.valor); // Qué se imprime?

	}
}
