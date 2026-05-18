package persistencia;

import javax.persistence.*;
import java.util.List;

public class JugadorJPADAO {

    private static final String URL = "objectdb:ficheros/escaperoom.odb";

    // Guardo el jugador en la base de datos orientada a objetos
    public void guardar(JugadorJPA jugador) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(URL);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(jugador);
            tx.commit();
            System.out.println("Jugador persistido en ObjectDB con ID = " + jugador.getId());
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Error al persistir jugador: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    // Muestro todos los jugadores guardados
    public void mostrarTodos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(URL);
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<JugadorJPA> query = em.createQuery("SELECT j FROM JugadorJPA j", JugadorJPA.class);
            List<JugadorJPA> lista = query.getResultList();
            if (lista.isEmpty()) {
                System.out.println("No hay jugadores guardados en ObjectDB.");
            } else {
                System.out.println("--- Jugadores en ObjectDB ---");
                lista.forEach(j -> System.out.println(j));
            }
        } catch (Exception e) {
            System.err.println("Error al consultar jugadores: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}