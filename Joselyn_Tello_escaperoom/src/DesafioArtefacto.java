import java.util.Scanner;

public class DesafioArtefacto extends Desafio {
    Scanner entrada = new Scanner(System.in);
    
    public DesafioArtefacto() {
        super("Cámara de los Artefactos", "Los verdaderos Sith confían en los minerales resonantes, no en el acero o los datos");
    }

    @Override
    public Resultado jugar() {
        System.out.println("--- " + nombreDesafio + " ---");
        System.out.println("Ante ti aparecen tres artefactos. Solo uno activa la salida");
        System.out.println("1. Una daga ceremonial Sith");
        System.out.println("2. Una esfera de datos antigua");
        System.out.println("3. Un cristal Kyber rojo");
        System.out.print("Elige con cuidado (1-3): ");

        try {
            int eleccion = Integer.parseInt(entrada.nextLine());
            switch(eleccion) {
                case 1:
                    System.out.println("La daga vibra, pero no hace nada. Falta conexión con la Fuerza");
                    return Resultado.FRACASO;
                case 2:
                    System.out.println("La esfera muestra datos corruptos. Los Sith preferían los cristales");
                    return Resultado.FRACASO;
                case 3:
                    System.out.println("El cristal Kyber resuena contigo. Los mecanismos se desbloquean");
                    return Resultado.EXITO;
                default:
                    System.out.println("Esa opción no existe en los pedestales");
                    return Resultado.FRACASO;
            }
        } catch (NumberFormatException e) {
            System.out.println("Debes introducir un número");
            return Resultado.FRACASO;
        
        }
    }
}
