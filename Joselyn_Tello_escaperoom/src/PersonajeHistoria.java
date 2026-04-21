public class PersonajeHistoria {
    
    private String nombre;
    private String dialogo;

    public PersonajeHistoria(String nombre, String dialogo) {
        this.nombre = nombre;
        this.dialogo = dialogo;
    }

    public void hablar() {
        System.out.println(nombre + " susurra: '" + dialogo + "'");
    }
}