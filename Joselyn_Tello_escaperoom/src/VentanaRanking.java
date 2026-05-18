import persistencia.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.sql.*;

public class VentanaRanking extends JFrame {

    public VentanaRanking() {

        // Configuración del JFrame
        setTitle("Escape Room: El Templo Sith - Ranking");
        setSize(600, 450);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Título
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
        panelSuperior.setBackground(Color.BLACK);
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20));

        JLabel titulo = new JLabel("EL TEMPLO SITH - REGISTRO DE APRENDICES", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        titulo.setForeground(new Color(255, 200, 0));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelSuperior.add(titulo);

        panelSuperior.add(Box.createVerticalStrut(10));
        add(panelSuperior, BorderLayout.NORTH);

        // Tabla de jugadores
        String[] columnas = {"Nombre", "Intentos", "Última fecha"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Datos desde MySQL
        try (Connection coneccion = ConexionBD.conectar();
             Statement st = coneccion.createStatement();
             ResultSet rs = st.executeQuery("SELECT nombre, intentos, ultima_fecha FROM jugadores ORDER BY intentos DESC")) {
            while (rs.next()) {
                modelo.addRow(new Object[]{
                        rs.getString("nombre"),
                        rs.getInt("intentos"),
                        rs.getString("ultima_fecha")
                });
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar ranking: " + e.getMessage());
        }

        JTable tabla = new JTable(modelo);
        tabla.setBackground(new Color(20, 20, 20));
        tabla.setForeground(new Color(255, 200, 0));
        tabla.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tabla.setRowHeight(25);
        tabla.getTableHeader().setBackground(new Color(50, 50, 50));
        tabla.getTableHeader().setForeground(new Color(255, 200, 0));
        tabla.getTableHeader().setFont(new Font("Serif", Font.BOLD, 13));
        tabla.setGridColor(new Color(80, 80, 80));

        // Centrar
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        centrado.setBackground(new Color(20, 20, 20));
        centrado.setForeground(new Color(255, 200, 0));
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.getViewport().setBackground(new Color(20, 20, 20));
        scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}