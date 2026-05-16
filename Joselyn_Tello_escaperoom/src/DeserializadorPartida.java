import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.File;

public class DeserializadorPartida {

    private static final String RUTA = "ficheros/jugador.obj";

    public static void mostrarUltimoJugador() {

        File fichero = new File(RUTA);

        if (!fichero.exists()) {
            System.out.println("No hay ningún estado de jugador guardado");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA))) {
            EstadoJugador estado = (EstadoJugador) ois.readObject();
            System.out.println("--- Último jugador guardado ---");
            System.out.println("Nombre: " + estado.getNombre());
            System.out.println("Energía restante: " + estado.getEnergia());
            System.out.println("Salas visitadas: " + estado.getSalasVisitadas());
        } catch (IOException e) {
            System.err.println("Error al deserializar el jugador: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada al deserializar: " + e.getMessage());
        }
    }
}