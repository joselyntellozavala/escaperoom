import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Inventario {

    private ArrayList<Item> items;
    private HashMap<String, Item> itemsPorNombre;
    private int capacidadMax;

    public Inventario(int capacidadMax) {
        this.items = new ArrayList<>();
        this.itemsPorNombre = new HashMap<>();
        this.capacidadMax = capacidadMax;
    }

    public boolean agregarItem(Item item) {
        if (items.size() < capacidadMax) {
            items.add(item);
            itemsPorNombre.put(item.getNombre(), item);
            System.out.println("Has guardado [" + item.getNombre() + "] en tu inventario.");
            return true;
        } else {
            System.out.println("Tu inventario está lleno. Capacidad máxima: " + capacidadMax);
            return false;
        }
    }


    public Item buscarItem(String nombre) {
        return itemsPorNombre.getOrDefault(nombre, null);
    }


    public void mostrarInventario() {
        System.out.println("--- INVENTARIO ---");
        if (items.isEmpty()) {
            System.out.println("No tienes ningún objeto en el inventario");
        } else {
            items.stream()
                    .forEach(item -> System.out.println("• " + item.getNombre() + " - " + item.getDescripcion()));
        }
    }


    public void mostrarPistas() {
        System.out.println("--- PISTAS EN INVENTARIO ---");
        items.stream()
                .filter(item -> item.getAccion() == AccionItem.LEER_PISTA)
                .forEach(item -> System.out.println("📜 " + item.getNombre() + ": " + item.getDescripcion()));
    }

    public boolean estaVacio() {
        return items.isEmpty();
    }
}