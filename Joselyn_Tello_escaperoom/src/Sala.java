import java.util.ArrayList;

public class Sala {

    private String nombre;
    private String descripcion;
    private ArrayList<ElementoSala> elementos;
    private ArrayList<Sala> salasConectadas;

    public Sala(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.elementos = new ArrayList<>();
        this.salasConectadas = new ArrayList<>();
    }

    public void agregarSalida(Sala s) {
        salasConectadas.add(s);
    }

    public void agregarElemento(ElementoSala e) {
        elementos.add(e);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<ElementoSala> getElementos() {
        return elementos;
    }

    public ArrayList<Sala> getSalasConectadas() {
        return salasConectadas;
    }
}