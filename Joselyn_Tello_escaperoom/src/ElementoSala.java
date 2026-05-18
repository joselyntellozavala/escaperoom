public class ElementoSala {

    private String nombre;
    private Desafio desafioAsociado;
    private PersonajeHistoria personajeAsociado;
    private boolean yaCompletado;

    public ElementoSala(String nombre) {
        this.nombre = nombre;
        this.yaCompletado = false;
    }

    public ElementoSala(String nombre, Desafio desafio) {
        this.nombre = nombre;
        this.yaCompletado = false;
        this.desafioAsociado = desafio;
    }

    public ElementoSala(String nombre, PersonajeHistoria personaje) {
        this.nombre = nombre;
        this.yaCompletado = false;
        this.desafioAsociado = null;
        this.personajeAsociado = personaje;
    }

    public void setDesafio(Desafio desafio) {
        this.desafioAsociado = desafio;
    }

    public void setPersonaje(PersonajeHistoria personaje) {
        this.personajeAsociado = personaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void interactuar() {
        if (yaCompletado) {
            System.out.println("Este elemento ha revelado todos sus secretos");
            return;
        }

        System.out.println();
        System.out.println("Interactuando con: " + nombre);

        if (personajeAsociado != null) {
            personajeAsociado.hablar();
            yaCompletado = true;
        }

        if (desafioAsociado != null) {
            Resultado res = desafioAsociado.jugar();
            if (res == Resultado.EXITO) {
                System.out.println("¡Has superado el obstáculo!");
                yaCompletado = true;
            } else {
                System.out.println("No lograste superar el obstáculo");
            }
        }
    }
}