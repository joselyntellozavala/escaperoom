public class FuerzaAgotadaException extends Exception {
    private String mensajePersonalizado;

    public FuerzaAgotadaException(String mensaje) {
        this.mensajePersonalizado = mensaje;
    }

    @Override
    public String getMessage() {
        return "Alerta: " + mensajePersonalizado;
    }
}