import java.util.Scanner;

public class AdivinaPalabra extends Desafio {
    Scanner entrada = new Scanner(System.in);

    private String palabraSecreta;

    public AdivinaPalabra() {
        super("Prueba de los Cristales Kyber", "Piensa en el arma elegante de tiempos más civilizados");
        this.palabraSecreta = "sable";
    }

    @Override
    public Resultado jugar() {
        System.out.println("--- " + nombreDesafio + " ---");
        System.out.println("Acertijo: Requiero entrenamiento y habilidad para mi uso. Doy luz en la oscuridad");
        System.out.print("Tu respuesta (5 letras): ");
        
        String respuesta = entrada.nextLine().trim().toLowerCase();
        
        if (respuesta.equals(palabraSecreta)) {
            System.out.println("El cristal brilla intensamente ¡Adivinaste!");
            return Resultado.EXITO;
        } else {
            System.out.println("El cristal se apaga. Has fallado");
            return Resultado.FRACASO;
        }

    }
    
}