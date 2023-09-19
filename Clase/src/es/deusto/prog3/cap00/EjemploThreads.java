package es.deusto.prog3.cap00;

public class EjemploThreads {

    public static void main(String[] args) {
        // Creamos dos objetos de tipo MiHilo
        MiHilo hilo1 = new MiHilo("Tarea 1");
        MiHilo hilo2 = new MiHilo("Tarea 2");

        // Iniciamos los hilos
        hilo1.start();
        hilo2.start();
    }
}

class MiHilo extends Thread {
    private String nombre;

    public MiHilo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(nombre + ": Contador " + i);
            try {
                Thread.sleep(1000); // Hacemos que el hilo duerma por un segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
