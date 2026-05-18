package persistencia;

import javax.persistence.*;
import java.util.List;

@Entity
public class JugadorJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private int energia;

    @ElementCollection
    private List<String> salasVisitadas;

    public JugadorJPA() {}

    public JugadorJPA(String nombre, int energia, List<String> salasVisitadas) {
        this.nombre = nombre;
        this.energia = energia;
        this.salasVisitadas = salasVisitadas;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEnergia() { return energia; }
    public List<String> getSalasVisitadas() { return salasVisitadas; }

    @Override
    public String toString() {
        return "JugadorJPA [id=" + id + ", nombre='" + nombre + "', energia=" + energia + ", salasVisitadas=" + salasVisitadas + "]";
    }
}