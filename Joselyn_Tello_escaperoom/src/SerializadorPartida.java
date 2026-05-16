import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializadorPartida {

    private static final String RUTA = "ficheros/jugador.obj";

    public static void guardar(Jugador jugador) {

        EstadoJugador estado = new EstadoJugador(
                jugador.getNombre(),
                jugador.getEnergiaEnLaFuerza(),
                String.join(", ", jugador.getSalasUnicasVisitadas())
        );

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA))) {
            oos.writeObject(estado);
            System.out.println("Estado del jugador serializado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al serializar el jugador: " + e.getMessage());
        }
    }
}