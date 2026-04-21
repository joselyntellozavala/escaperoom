import java.util.Scanner;

public class DesafioEncrucijada extends Desafio {
    Scanner entrada = new Scanner(System.in);

    public DesafioEncrucijada() {
        super("La Encrucijada de los caminos", "Solo un Sith lidia en absolutos. Evita los extremos");
    }

    @Override
    public Resultado jugar() {
        System.out.println("--- " + nombreDesafio + " ---");
        System.out.println("Tres pasillos se despliegan ante ti.");
        System.out.println("Un grabado señala: 'El sendero de la verdad no es extremo ni lateral'");
        System.out.print("Elige un pasillo (A/B/C): ");

        String eleccion = entrada.nextLine().trim().toUpperCase();

        if (eleccion.equals("B")) {
            System.out.println("La losa se desliza. Has elegido el camino correcto");
            return Resultado.EXITO;
        } else {
            System.out.println("Ese camino era una ilusión Sith. Cuidado con los extremos");
            return Resultado.FRACASO;
        }
    }
}