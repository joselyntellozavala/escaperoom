import java.util.Scanner;

public class TresEnRaya extends Desafio {
    Scanner entrada = new Scanner(System.in);

    private char[][] tablero;

    public TresEnRaya() {
        super("Duelo Mental Holográfico", "Aquel que controla el centro, controla el campo de batalla");
        tablero = new char[][] {
                { '1', '2', '3' },
                { '4', '5', '6' },
                { '7', '8', '9' }
        };
    }

    @Override
    public Resultado jugar() {
        int turnos = 0;
        System.out.println("\n--- " + nombreDesafio + " ---");
        System.out.println("Derrota al droide para demostrar tu habilidad");

        while (turnos < 9) {
            imprimirTablero();
            System.out.print("Elige casilla (1-9): ");
            try {
                char jugada = entrada.nextLine().charAt(0);
                if (ponerFicha(jugada, 'X')) {
                    if (hayGanador('X')){
                        return Resultado.EXITO;
                    }
                    turnos++;

                    if (turnos < 9) {
                        juegoMaquina('O');
                        
                        if (hayGanador('O'))
                            return Resultado.FRACASO;
                        turnos++;
                    }
                } else {
                    System.out.println("Movimiento no válido");
                }
            } catch (StringIndexOutOfBoundsException sioobe) {     
                System.out.println("Entrada corrupta.");
            }
        }
        return Resultado.EMPATE;

    }

    private void imprimirTablero() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + tablero[i][0] + " | " + tablero[i][1] + " | " + tablero[i][2]);
            if (i < 2){
                System.out.println("---+---+---");
            }
        }
    }

    private boolean ponerFicha(char entrada, char simbolo) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == entrada) {
                    tablero[i][j] = simbolo;
                    return true;
                }
            }
        }
        return false;
    }

    private void juegoMaquina(char simbolo) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] != 'X' && tablero[i][j] != 'O') {
                    tablero[i][j] = simbolo;
                    return;
                }
            }
        }
    }

    private boolean hayGanador(char f) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == f && tablero[i][1] == f && tablero[i][2] == f){
                return true;
            }

            if (tablero[0][i] == f && tablero[1][i] == f && tablero[2][i] == f){
                return true;
            }
        }
        if (tablero[0][0] == f && tablero[1][1] == f && tablero[2][2] == f){
            return true;
        }

        return tablero[0][2] == f && tablero[1][1] == f && tablero[2][0] == f; 
    }

}
