import java.util.ArrayList;
import java.util.Stack;

public class Jugador {
    private String nombre;
    private int energiaEnLaFuerza;
    private Inventario inventario;
    private Sala habitacionActual;
    private Stack<Sala> historialSalas;

    public Jugador(String nombre, int energia, Sala habitacionInicial) {
        this.nombre = nombre;
        this.energiaEnLaFuerza = energia;
        this.habitacionActual = habitacionInicial;
        this.inventario = new Inventario(5);
        this.historialSalas = new Stack<>();
        historialSalas.push(habitacionInicial);
    }

    public void consumirRecurso() throws FuerzaAgotadaException {
        energiaEnLaFuerza--;
        if (energiaEnLaFuerza <= 0) {
            throw new FuerzaAgotadaException("El Lado Oscuro ha drenado tu energía");
        }
    }

    public void mostrarEstado() {
        System.out.print("Fuerza: " + energiaEnLaFuerza + " | Salas visitadas: "
                + historialSalas.size() + " | Inventario: ");
        if (inventario.estaVacio()) {
            System.out.println("vacío");
        } else {
            System.out.println("con objetos");
        }
    }

    public void moverA(int indiceVecina) {
        ArrayList<Sala> salasDisponibles = habitacionActual.getSalasConectadas();
        if (indiceVecina >= 0 && indiceVecina < salasDisponibles.size()) {
            this.habitacionActual = salasDisponibles.get(indiceVecina);
            historialSalas.push(habitacionActual); // ← cada movimiento se apila
            System.out.println("Te has movido a: " + habitacionActual.getNombre());
        } else {
            System.out.println("Esa ruta no existe");
        }
    }

    public void mostrarHistorial() {
        System.out.println("--- Tu camino hasta aquí ---");
        historialSalas.stream()
                .forEach(sala -> System.out.println("  → " + sala.getNombre()));
    }

    public void mostrarVecinas() {
        ArrayList<Sala> salasDisponibles = habitacionActual.getSalasConectadas();
        System.out.println("Salidas desde " + habitacionActual.getNombre() + ":");
        for (int i = 0; i < salasDisponibles.size(); i++) {
            System.out.println(i + ". " + salasDisponibles.get(i).getNombre());
        }
    }

    public void explorarHabitacion() {
        ArrayList<ElementoSala> elementos = habitacionActual.getElementos();
        if (elementos.isEmpty()) {
            System.out.println("La sala parece vacía de interés");
            return;
        }
        System.out.println("Elementos en la sala:");
        for (int i = 0; i < elementos.size(); i++) {
            System.out.println(i + ". " + elementos.get(i).getNombre());
        }
    }

    public void interactuarCon(int indiceElemento) {
        ArrayList<ElementoSala> elementos = habitacionActual.getElementos();
        if (indiceElemento >= 0 && indiceElemento < elementos.size()) {
            elementos.get(indiceElemento).interactuar();
        } else {
            System.out.println("No hay nada ahí");
        }
    }

    public Inventario getInventario() {
        return inventario;
    }

    public Sala getHabitacionActual() {
        return habitacionActual;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEnergiaEnLaFuerza() {
        return energiaEnLaFuerza;
    }
}