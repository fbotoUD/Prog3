package es.deusto.prog3.cap00.hilos;

public class InterrupcionDeHilo {
    public static void main(String[] args) {
        // Definir un hilo que ejecuta un interación
        Runnable tareaHilo = new Runnable() {
        	private int DURACION_SEGUNDOS = 15;
            @Override
            public void run() {
                try {
                    // Simular un trabajo en el hilo secundario
                    for (int i = 1; i <= DURACION_SEGUNDOS; i++) {
                        System.out.println("Hilo secundario: Iteración " + i);
                        Thread.sleep(1000); // Esperar 1 segundo
                    }
                } catch (InterruptedException e) {
                    // Capturar la excepción de interrupción
                    System.out.println("Hilo secundario interrumpido.");
                }
            }
        };

        // Resto del código sigue siendo igual
        Thread hiloSecundario = new Thread(tareaHilo);
        
        //Declarar el hilo como daemon o no
//        hiloSecundario.setDaemon(false);
        hiloSecundario.start();
        // El hilo empieza y termina en los segundos indicados si nadie lo interrunpe
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        hiloSecundario.interrupt();
    }
}

