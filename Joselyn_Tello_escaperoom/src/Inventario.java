import java.util.ArrayList;

public class Inventario {

    private ArrayList<Item> items;
    private int capacidadMax;

    public Inventario(int capacidadMax) {
        this.items = new ArrayList<>();
        this.capacidadMax = capacidadMax;
    }


    public boolean agregarItem(Item item) {
        if (items.size() < capacidadMax) {
            items.add(item);
            System.out.println("Has guardado [" + item.getNombre() + "] en tu inventario.");
            return true;
        } else {
            System.out.println("Tu inventario está lleno. Capacidad máxima: " + capacidadMax);
            return false;
        }
    }

    public void mostrarInventario() {
        System.out.println("--- INVENTARIO ---");
        if (items.isEmpty()) {
            System.out.println("No tienes ningún objeto en el inventario");
        } else {
            for (int i = 0; i < items.size(); i++) {
                System.out.println(i + ". " + items.get(i).getNombre() + " - " + items.get(i).getDescripcion());
            }
        }
    }

    public boolean estaVacio() {
        return items.isEmpty();
    }
}
