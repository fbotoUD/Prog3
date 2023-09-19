package es.deusto.prog3.cap00;

public class EjemploVariables {
	static int variableEstatica = 0; // Variable estática

    int variableDeInstancia = 0; // Variable de instancia

    public static void main(String[] args) {
        // Crear dos instancias de la clase
        EjemploVariables objeto1 = new EjemploVariables();
        EjemploVariables objeto2 = new EjemploVariables();

        // Modificar la variable estática a través de la clase
        EjemploVariables.variableEstatica = 10;

        // Modificar la variable de instancia a través de objetos individuales
        objeto1.variableDeInstancia = 20;
        objeto2.variableDeInstancia = 30;

        // Imprimir los valores
        System.out.println("Variable estática: " + EjemploVariables.variableEstatica);
        System.out.println("Variable de instancia (objeto1): " + objeto1.variableDeInstancia);
        System.out.println("Variable estática (objeto1): " + objeto1.variableEstatica);
        System.out.println("Variable de instancia (objeto2): " + objeto2.variableDeInstancia);
//        objeto2.variableEstatica = 20; // Esto qué hace??
        System.out.println("Variable estática (objeto2): " + objeto2.variableEstatica);
        
        System.out.println("Suma: " + (EjemploVariables.variableEstatica + objeto1.variableDeInstancia + objeto2.variableDeInstancia));
    }
}
