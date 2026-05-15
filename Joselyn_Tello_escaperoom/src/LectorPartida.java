import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class LectorPartida {

    private static final String RUTA = "ficheros/partida.txt";

    public static void mostrarHistorial() {

        File fichero = new File(RUTA);

        if (!fichero.exists()) {
            System.out.println("No hay partidas anteriores registradas");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
            System.out.println("--- Historial de intentos ---");
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer la partida: " + e.getMessage());
        }
    }
}