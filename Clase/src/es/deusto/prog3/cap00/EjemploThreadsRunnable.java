package es.deusto.prog3.cap00;

public class EjemploThreadsRunnable {
    public static void main(String[] args) {
        // Creamos dos objetos de tipo Runnable
        Runnable tarea1 = new MiRunnable("Tarea 1");
        Runnable tarea2 = new MiRunnable("Tarea 2");

        // Creamos dos hilos y les asignamos las tareas
        Thread hilo1 = new Thread(tarea1);
        Thread hilo2 = new Thread(tarea2);

        // Iniciamos los hilos
        hilo1.start();
        hilo2.start();
    }
}

class MiRunnable implements Runnable {
    private String nombre;

    public MiRunnable(String nombre) {
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
