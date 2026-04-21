public class Item {
    
    private String nombre;
    private String descripcion;
    private AccionItem accion;

    public Item(String nombre, String descripcion, AccionItem accion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.accion = accion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public AccionItem getAccion() {
        return accion;
    }

}