package persistencia;

import java.sql.*;
import java.time.LocalDateTime;

public class JugadorDAO {

    // Busca un jugador por nombre
    public JugadorBD buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM jugadores WHERE nombre = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JugadorBD jugador = new JugadorBD(rs.getString("nombre"));
                jugador.setId(rs.getInt("id"));
                jugador.setIntentos(rs.getInt("intentos"));
                return jugador;
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar jugador: " + e.getMessage());
        }
        return null;
    }

    // Inserta un jugador nuevo en la base de datos
    public void insertar(JugadorBD jugador) {
        String sql = "INSERT INTO jugadores (nombre, intentos, ultima_fecha) VALUES (?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, jugador.getNombre());
            ps.setInt(2, jugador.getIntentos());
            ps.setObject(3, LocalDateTime.now());
            ps.executeUpdate();
            System.out.println("Jugador registrado en la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al insertar jugador: " + e.getMessage());
        }
    }

    // Suma 1 a los intentos y actualiza la fecha
    public void actualizarIntentos(JugadorBD jugador) {
        String sql = "UPDATE jugadores SET intentos = intentos + 1, ultima_fecha = ? WHERE id = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, LocalDateTime.now());
            ps.setInt(2, jugador.getId());
            ps.executeUpdate();
            System.out.println("Intentos actualizados en la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar jugador: " + e.getMessage());
        }
    }
}