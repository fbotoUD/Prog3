package es.deusto.prog3.cap00;

public class HiloEjemploRunnable implements Runnable{
	static long horaInicio = System.currentTimeMillis(); 
	int cont = 0; 
	int num; 

	public static void main( String[] pars ) { 
		Thread[] t = new Thread [4]; 
		HiloEjemploRunnable[] o = new HiloEjemploRunnable [4];
		for (int i = 0; i < 4; i++) { 
			o[i] = new HiloEjemploRunnable(i); 
			t[i] = new Thread(o[i]);
			System.out.println( "nuevo Thread() " + 
			(t[i] == null ? "fallo" : "correcto") + " - " + t[i].getName() ); 
		} 
		t[0].setPriority(10);
		t[1].setPriority(7);
		t[2].setPriority(4);
		t[3].setPriority(1);
		for (int i = 0; i < 4; i++) 
			t[i].start();  // Llama el o[i].run()
		try { 
			for (int i = 0; i < 4; i++) {
				t[i].join(); // Espera a que acabe el hilo i
			}
		} catch (InterruptedException e) { }
		System.out.println();
		for (int i = 0; i < 4; i++) 
			o[i].visualizar(); 
	} 
	
	public HiloEjemploRunnable( int numObjeto ) {
		num = numObjeto; 
	}
	
	public void run() { 
		while( System.currentTimeMillis() - horaInicio < 3000) 
		{
			System.out.print( num );  
			if (cont%100==0) { 
				System.out.println();
			}
			cont++; 
		} 
	} 
	
	public void visualizar() { 
		System.out.println( "Objeto num. " + num + " - " + cont + " veces." ); 
	} 

}
