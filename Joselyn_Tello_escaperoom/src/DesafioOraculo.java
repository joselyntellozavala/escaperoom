import java.util.Scanner;

public class DesafioOraculo extends Desafio {
    Scanner entrada = new Scanner(System.in);

    private int numeroSecreto;

    public DesafioOraculo() {
        super("El Oráculo Sith", "Cierra los ojos. Siente la vibración del número en tu mente");
        this.numeroSecreto = 7;
    }

    @Override
    public Resultado jugar() {
        int intentos = 3;

        System.out.println("--- " + nombreDesafio + " ---");
        System.out.println("Adivina el número que guarda mi memoria (entre 1 y 10). Tienes 3 intentos");

        while (intentos > 0) {
            System.out.print("Ingresa un número: ");
            try {
                int numeroIngresado = Integer.parseInt(entrada.nextLine());

                if (numeroIngresado == numeroSecreto) {
                    System.out.println("¡Adivinaste! El pedestal revela sus secretos");
                    return Resultado.EXITO;

                } else if (numeroIngresado < numeroSecreto) {
                    System.out.println("Pista: el número es MAYOR");

                } else {
                    System.out.println("Pista: el número es MENOR");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número");
            }
            intentos--;
            System.out.println("Intentos restantes: " + intentos);
        }
        System.out.println("Has agotado tus intentos en el Oráculo");
        return Resultado.FRACASO;

    }
}