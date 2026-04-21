public abstract class Desafio implements Jugable {
    protected String nombreDesafio;
    protected String pista;

    public Desafio(String nombreDesafio, String pista) {
        this.nombreDesafio = nombreDesafio;
        this.pista = pista;
    }

    public String getNombreDesafio() {
        return nombreDesafio;
    }

    public void mostrarPista() {
        System.out.println("Una voz en tu mente te dice: " + pista);
    }

    @Override
    public abstract Resultado jugar();

}