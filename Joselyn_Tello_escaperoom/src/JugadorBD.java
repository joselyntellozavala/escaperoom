import java.time.LocalDateTime;

public class JugadorBD {

    private int id;
    private String nombre;
    private int intentos;
    private LocalDateTime ultimaFechaDeJuego;

    public JugadorBD(String nombre) {
        this.nombre = nombre;
        this.intentos = 1;
        this.ultimaFechaDeJuego = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIntentos() {
        return intentos;
    }

    public LocalDateTime getUltimaFechaDeJuego() {
        return ultimaFechaDeJuego;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public void setUltimaFechaDeJuego(LocalDateTime ultimaFechaDeJuego) {
        this.ultimaFechaDeJuego = ultimaFechaDeJuego;
    }
}