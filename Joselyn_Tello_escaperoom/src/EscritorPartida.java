import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorPartida {

    private static final String RUTA = "ficheros/partida.txt";

    public static void guardar(Jugador jugador, boolean gano) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {
            bw.write("=== INTENTO ===");
            bw.newLine();
            bw.write("Jugador: " + jugador.getNombre());
            bw.newLine();
            bw.write("Energia restante: " + jugador.getEnergiaEnLaFuerza());
            bw.newLine();
            bw.write("Salas visitadas: " + String.join(", ", jugador.getSalasUnicasVisitadas()));
            bw.newLine();
            bw.write("Resultado: " + (gano ? "ESCAPÓ" : "ATRAPADO"));
            bw.newLine();
            bw.write("===============");
            bw.newLine();
            System.out.println("Partida registrada en fichero.");
        } catch (IOException e) {
            System.err.println("Error al escribir la partida: " + e.getMessage());
        }
    }
}