package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDAO {

    public boolean inscribirAlumno(Alumno alumno) {

        boolean inscrito = false;

        String sql = "INSERT INTO alumnos VALUES (?,?,?,?,?)";

        Connection conexion = null;

        try {

            conexion = Conexion.conectar();
            conexion.setAutoCommit(false);

            PreparedStatement stm = conexion.prepareStatement(sql);

            stm.setInt(1, alumno.getNumExpediente());
            stm.setString(2, alumno.getNombre());
            stm.setString(3, alumno.getCurp());
            stm.setString(4, alumno.getGrupo());
            stm.setDouble(5, alumno.getPromedio());

            int filas = stm.executeUpdate();

            conexion.commit();

            if (filas > 0) {
                inscrito = true;
                System.out.println("Registro realizado correctamente");
            }

        } catch (SQLException err) {

            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("Error: " + err.getMessage());
        }

        return inscrito;
    }

    public ArrayList<Alumno> extraerAlumno() {

        ArrayList<Alumno> alumnos = new ArrayList<>();

        String sql = "SELECT * FROM alumnos";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Alumno alumno = new Alumno();

                alumno.setNumExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setGrupo(rs.getString("grupo"));
                alumno.setPromedio(rs.getDouble("promedio"));

                alumnos.add(alumno);
            }

        } catch (SQLException err) {

            System.out.println("Error al extraer alumnos: " + err.getMessage());

        }

        return alumnos;
    }

    public boolean actualizar(Alumno alumno) {

        boolean actualizado = false;

        String sql = "UPDATE alumnos SET nombre=?, curp=?, grupo=?, promedio=? WHERE numExpediente=?";

        Connection conexion = null;

        try {

            conexion = Conexion.conectar();
            conexion.setAutoCommit(false);

            PreparedStatement stm = conexion.prepareStatement(sql);

            stm.setString(1, alumno.getNombre());
            stm.setString(2, alumno.getCurp());
            stm.setString(3, alumno.getGrupo());
            stm.setDouble(4, alumno.getPromedio());
            stm.setInt(5, alumno.getNumExpediente());

            int filas = stm.executeUpdate();

            conexion.commit();

            if (filas > 0) {
                actualizado = true;
                System.out.println("Alumno actualizado correctamente");
            } else {
                System.out.println("No existe un alumno con ese número de expediente.");
            }

        } catch (SQLException err) {

            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("Error al actualizar: " + err.getMessage());
        }

        return actualizado;
    }


    public boolean bajaAlumno(int numExpediente) {

        boolean eliminado = false;

        String sql = "DELETE FROM alumnos WHERE numExpediente=?";

        Connection conexion = null;

        try {

            conexion = Conexion.conectar();
            conexion.setAutoCommit(false);

            PreparedStatement stm = conexion.prepareStatement(sql);

            stm.setInt(1, numExpediente);

            int filas = stm.executeUpdate();

            conexion.commit();

            if (filas > 0) {
                eliminado = true;
                System.out.println("Alumno eliminado correctamente");
            } else {
                System.out.println("No existe un alumno con ese número de expediente.");
            }

        } catch (SQLException err) {

            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("Error: " + err.getMessage());
        }

        return eliminado;
    }

    public Alumno buscarAlumno(int numExpediente) {

        Alumno alumno = null;

        String sql = "SELECT * FROM alumnos WHERE numExpediente=?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, numExpediente);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                alumno = new Alumno();

                alumno.setNumExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setGrupo(rs.getString("grupo"));
                alumno.setPromedio(rs.getDouble("promedio"));
            }

        } catch (SQLException e) {

            System.out.println("Error: " + e.getMessage());

        }

        return alumno;
    }

}

