import java.util.Scanner;

public class MainJuego {

    public static void main(String[] args) {
        
        try (Scanner entrada = new Scanner(System.in)) {
            
            Sala pasillo = new Sala("Corredor de la Encrucijada", "Un corredor oscuro que se divide ante ti");
            Sala camaraOraculo = new Sala("Cámara del Oráculo", "Las antorchas se encienden solas al entrar");
            Sala salaDuelo = new Sala("Cámara de Entrenamiento", "El suelo está marcado por quemaduras de láser");
            Sala biblioteca = new Sala("Archivos Sith", "Estanterías llenas de cristales y polvo");
            Sala camaraFinal = new Sala("Cámara Final", "La inmensa puerta del templo te corta el paso");
            
            pasillo.agregarSalida(camaraOraculo);
            pasillo.agregarSalida(salaDuelo);
            camaraOraculo.agregarSalida(pasillo);
            salaDuelo.agregarSalida(pasillo);
            salaDuelo.agregarSalida(biblioteca);
            biblioteca.agregarSalida(salaDuelo);
            biblioteca.agregarSalida(camaraFinal);
            camaraFinal.agregarSalida(biblioteca);
            
            pasillo.agregarElemento(new ElementoSala("Espíritu Errante", new PersonajeHistoria("Espíritu", "No confíes en los extremos")));
            pasillo.agregarElemento(new ElementoSala("Caminos Grabados", new DesafioEncrucijada()));  
            camaraOraculo.agregarElemento(new ElementoSala("Pedestal en Llamas", new DesafioOraculo()));  
            salaDuelo.agregarElemento(new ElementoSala("Droide de Combate", new TresEnRaya()));
            salaDuelo.agregarElemento(new ElementoSala("Holograma del Maestro", new PersonajeHistoria("Maestro", "Un droide es predecible."))); 
            biblioteca.agregarElemento(new ElementoSala("Holocrón Roto")); 
            biblioteca.agregarElemento(new ElementoSala("Mesa de Alquimia", new AdivinaPalabra()));   
            camaraFinal.agregarElemento(new ElementoSala("Mecanismo de la Puerta", new DesafioArtefacto()));

            Jugador padawan = new Jugador("Joven Aprendiz", 22, pasillo); 
            boolean juegoTerminado = false;
            
            System.out.println("*******************************************************************************");
            System.out.println("              E S C A P E   R O O M :   E L   T E M P L O   S I T H            ");
            System.out.println("*******************************************************************************");
            System.out.println();
            System.out.println("La Orden te ha enviado a las ruinas del planeta Korriban para recuperar");
            System.out.println("información vital. Sin embargo, al cruzar el umbral del Templo de la Encrucijada,");
            System.out.println("un antiguo mecanismo de seguridad se ha activado sellando la salida a tu espalda.");
            System.out.println("El aire aquí es denso y hostil.\n");

            System.out.println("Condiciones para tu supervivencia:");
            System.out.println();
            System.out.println("1.  Puedes moverte libremente entre las salas conectadas");
            System.out.println("   Si un acertijo te bloquea, busca pistas en otras habitaciones y vuelve más tarde");
            System.out.println("2. La atmósfera del templo está corrupta. Tienes un total");
            System.out.println("   de " + padawan.getEnergiaEnLaFuerza() + " puntos de Fuerza. Cada acción consume 1 punto.");
            System.out.println("   Si tu contador llega a 0, quedarás atrapado para siempre.");
            System.out.println("3. Encuentra la Sala Final y activa el mecanismo");
            System.out.println("   correcto para abrir la puerta antes de que se agote tu energía");
            System.out.println();
            System.out.println("*******************************************************************************\n");
            System.out.println("Escapa antes de que el Lado Oscuro drene tu energía");
            
            while (!juegoTerminado) {
                try {
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("Ubicación: " + padawan.getHabitacionActual().getNombre());
                    System.out.println(padawan.getHabitacionActual().getDescripcion());
                    padawan.mostrarEstado();
                    
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Investigar los elementos de la sala");
                    System.out.println("2. Moverse a otra sala conectada");
                    System.out.print("Tu elección: ");
                    
                    int accion = Integer.parseInt(entrada.nextLine()); 
                    
                    padawan.consumirRecurso(); 

                    if (accion == 1) {
                        padawan.explorarHabitacion(); 
                        
                        if (!padawan.getHabitacionActual().getElementos().isEmpty()) {
                            System.out.print("Elige el número para interactuar: ");
                            int indice = Integer.parseInt(entrada.nextLine());
                            
                            padawan.interactuarCon(indice); 
                            
                            if (padawan.getHabitacionActual().getNombre().equals("Cámara Final") && 
                                padawan.getHabitacionActual().getElementos().get(indice).getNombre().equals("Mecanismo de la Puerta")) {
                                
                                System.out.println("¡El mecanismo gira con un estruendo! La gran puerta se abre y logras escapar");
                                System.out.println("¡Ganaste! Juego terminado");
                                juegoTerminado = true;
                            }
                        }
                    } else if (accion == 2) {
                        padawan.mostrarVecinas(); 
                        System.out.print("Elige el número de la ruta: ");
                        int indice = Integer.parseInt(entrada.nextLine());
                        
                        padawan.moverA(indice); 
                    } else {
                        System.out.println("Opción no válida");
                    }

                } catch (FuerzaAgotadaException e) {
                    System.out.println("\n" + e.getMessage());
                    System.out.println("Has caído en el Lado Oscuro. Juego terminado.");
                    juegoTerminado = true; 
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debes introducir un número");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Error: Esa opción no existe en tu entorno");
                }
            }
        }
    }
}