import java.io.Serializable;

public class EstadoJugador implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private int energia;
    private String salasVisitadas;

    public EstadoJugador(String nombre, int energia, String salasVisitadas) {
        this.nombre = nombre;
        this.energia = energia;
        this.salasVisitadas = salasVisitadas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public String getSalasVisitadas() {
        return salasVisitadas;
    }
}