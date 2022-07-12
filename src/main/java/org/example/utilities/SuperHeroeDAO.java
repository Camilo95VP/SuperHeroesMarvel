package org.example.utilities;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.*;

import static org.example.utilities.MySQLConection.getConnection;


public class SuperHeroeDAO {
    private static final String SQL_SELECT = "SELECT id, name, description FROM heroes";
    private static final String SQL_INSERT = "INSERT INTO heroes(name, description) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE heroes SET name = ?, description = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM heroes WHERE id = ?";


    public List<SuperHeroe> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SuperHeroe superh;
        List<SuperHeroe> superheroes = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                superh = new SuperHeroe(id, name, description);

                superheroes.add(superh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                assert rs != null;
                MySQLConection.close(rs);
                MySQLConection.close(stmt);
                MySQLConection.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return superheroes;
    }

    public static void insertar(SuperHeroe heroe){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, heroe.getName());
            stmt.setString(2, heroe.getDescription());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                MySQLConection.close(stmt);
                MySQLConection.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
    public static int actualizar(SuperHeroe heroe){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, heroe.getId());
            stmt.setString(2, heroe.getName());
            stmt.setString(3, heroe.getDescription());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                MySQLConection.close(stmt);
                MySQLConection.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    public static int eliminar(@NotNull SuperHeroe heroe){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, heroe.getId());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                MySQLConection.close(stmt);
                MySQLConection.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
