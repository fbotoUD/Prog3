package es.deusto.prog3.cap00;

//Definición de una interfaz
interface Forma {
 double calcularArea();
}

//Implementación de la interfaz en clases concretas
class Circulo implements Forma {
 private double radio;

 public Circulo(double radio) {
     this.radio = radio;
 }

 @Override
 public double calcularArea() {
     return Math.PI * radio * radio;
 }
}

class Rectangulo implements Forma {
 private double longitud;
 private double anchura;

 public Rectangulo(double longitud, double anchura) {
     this.longitud = longitud;
     this.anchura = anchura;
 }

 @Override
 public double calcularArea() {
     return longitud * anchura;
 }
}

//Clase que utiliza el polimorfismo de datos y de código
public class PolimorfismoFormas {
 public static void main(String[] args) {
     // Creación de objetos de diferentes formas
     Forma forma1 = new Circulo(5.0);
     Forma forma2 = new Rectangulo(4.0, 3.0);

     // Uso del polimorfismo de código
     System.out.println("Área del círculo: " + forma1.calcularArea());
     System.out.println("Área del rectángulo: " + forma2.calcularArea());

     // Uso del polimorfismo de datos
     Forma[] formas = new Forma[2];
     formas[0] = forma1;
     formas[1] = forma2;

     for (Forma forma : formas) {
         System.out.println("Área: " + forma.calcularArea());
     }
 }
}
