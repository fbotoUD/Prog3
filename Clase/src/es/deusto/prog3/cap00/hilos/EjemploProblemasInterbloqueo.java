package es.deusto.prog3.cap00.hilos;

/** Ejemplo de problema de interbloqueo entre dos hilos en dos objetos compartidos mutuos
 */
public class EjemploProblemasInterbloqueo implements Runnable {
	private static boolean COMPROBAR_BLOQUEOS = false;  // Cambiar si se quiere analizar el problema
	
	/** Prueba de problema - creamos dos amigos y les saludamos mutuamente con dos hilos distintos
	 * @param s	No utilizado
	 */
	public static void main( String[] s ) {
		Persona persona1 = new Persona( "Marta" );
		Persona persona2 = new Persona( "Luis" );
		Thread t1 = new Thread( new EjemploProblemasInterbloqueo( persona1, persona2 ) );
		Thread t2 = new Thread( new EjemploProblemasInterbloqueo( persona2, persona1 ) );
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {}
		System.out.println( "Fin de saludos" );
	}
	
	private Persona persona,amigo;
	public EjemploProblemasInterbloqueo( Persona persona, Persona amigo ) {
		this.persona = persona;
		this.amigo = amigo;
	}	
	@Override
	public void run() {
		// Si hiciera falta repetir
		 for (int i=0; i<50; i++) {
							if (COMPROBAR_BLOQUEOS) System.err.println( "Hagamos que " + persona + " salude a " + amigo + ":" );
			persona.saluda( amigo );
		 }
	}
	
	private static class Persona {
		private String nombre;
		Persona( String nombre ) {
			this.nombre = nombre;
		}
		synchronized public void saluda( Persona amigo ) {
							if (COMPROBAR_BLOQUEOS) System.err.println( "  Entrando en bloqueo por saludo de objeto " + this );
	    	// Saluda = sonreir + que él/ella sonría
	    	sonrie( amigo );
	    					if (COMPROBAR_BLOQUEOS) System.err.println( "    Posible bloqueo de objeto " + amigo + " antes de que sonría a " + this );
	    	amigo.sonrie( this );
	    					if (COMPROBAR_BLOQUEOS) System.err.println( "  Saliendo de bloqueo por saludo de objeto " + this );
	    }
		synchronized public void sonrie( Persona p ) {
	    	System.out.println( this + " sonríe a " + p );
	    }
	    public String toString() {
	    	return nombre;
	    }
	}
	
}
