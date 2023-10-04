package es.deusto.prog3.cap00.hilos;

/** Solución problema sincronización: synchronized
 */
public class EjemploProblemasSincronizacion implements Runnable {
	private static Contador miContador = new Contador();
	private static int CUANTAS_VECES = 10;
	@Override
	public void run() {
		for (int i = 0; i<CUANTAS_VECES; i++) {
			miContador.inc();
			miContador.dec();
		}
	}
	public static void main( String[] s ) {
		 Thread t1 = new Thread( new EjemploProblemasSincronizacion() );
		 Thread t2 = new Thread( new EjemploProblemasSincronizacion() );
		 Thread t3 = new Thread( new EjemploProblemasSincronizacion() );
		 System.out.println( "Contador = " + miContador.getContador() );  // Contador = 0
		 long tiempo = System.currentTimeMillis();
		 t1.start();
		 t2.start();
		 t3.start();
		 try {
			 t1.join();
			 t2.join();
			 t3.join();
		 } catch (InterruptedException e) {
		 }
		 System.out.println( "Contador = " + miContador.getContador() );  // Debería ser cero pero... 
		 System.out.println( "Tiempo transcurrido: " + (System.currentTimeMillis() - tiempo) + " msgs." );
	}
	
	private static class Contador {
	    private int c = 0;
	    public void inc() {
	    	// Haciendo miContador++ valdría 
	    	// pero se ve más claro el problema si se hace en pasos:
    		int d = c;
	    	d++;
	        c = d;		
	    }

	    public void dec() {
	    	// Haciendo miContador-- valdría 
	    	// pero se ve más claro el problema si se hace en pasos:
    		int d = c;
	    	d--;
	        c = d;  	
	    }
	    public int getContador() {
	        return c;
	    }
	}
	
}
