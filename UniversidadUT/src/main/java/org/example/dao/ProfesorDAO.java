package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorDAO {

    //==================== AGREGAR PROFESOR ====================

    public boolean agregarProfesor(Profesor profesor){

        boolean agregado = false;

        String sql = "INSERT INTO profesores VALUES(?,?,?,?,?,?)";

        Connection conexion = null;

        try{

            conexion = Conexion.conectar();
            conexion.setAutoCommit(false);

            PreparedStatement stm = conexion.prepareStatement(sql);

            stm.setInt(1, profesor.getNumEmpleado());
            stm.setString(2, profesor.getNombre());
            stm.setString(3, profesor.getCurp());
            stm.setString(4, profesor.getNombreEmpleado());
            stm.setString(5, profesor.getPuesto());
            stm.setDouble(6, profesor.getSueldo());

            int filas = stm.executeUpdate();

            conexion.commit();

            if(filas > 0){
                agregado = true;
                System.out.println("Profesor agregado correctamente");
            }

        }catch(SQLException e){

            try{
                if(conexion != null){
                    conexion.rollback();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }

            System.out.println(e.getMessage());
        }

        return agregado;
    }

    //==================== MOSTRAR PROFESORES ====================

    public ArrayList<Profesor> mostrarProfesores(){

        ArrayList<Profesor> profesores = new ArrayList<>();

        String sql = "SELECT * FROM profesores";

        Connection conexion = null;

        try{

            conexion = Conexion.conectar();
            conexion.setAutoCommit(false);

            PreparedStatement stm = conexion.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while(rs.next()){

                Profesor profesor = new Profesor();

                profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setCurp(rs.getString("curp"));
                profesor.setNombreEmpleado(rs.getString("nombreEmpleado"));
                profesor.setPuesto(rs.getString("puesto"));
                profesor.setSueldo(rs.getDouble("sueldo"));

                profesores.add(profesor);
            }

            conexion.commit();

        }catch(SQLException e){

            try{
                if(conexion != null){
                    conexion.rollback();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }

            System.out.println(e.getMessage());
        }

        return profesores;
    }

    //==================== ACTUALIZAR PROFESOR ====================

    public boolean actualizarProfesor(Profesor profesor){

        boolean actualizado = false;

        String sql = "UPDATE profesores SET nombre=?, curp=?, nombreEmpleado=?, puesto=?, sueldo=? WHERE numEmpleado=?";

        Connection conexion = null;

        try{

            conexion = Conexion.conectar();
            conexion.setAutoCommit(false);

            PreparedStatement stm = conexion.prepareStatement(sql);

            stm.setString(1, profesor.getNombre());
            stm.setString(2, profesor.getCurp());
            stm.setString(3, profesor.getNombreEmpleado());
            stm.setString(4, profesor.getPuesto());
            stm.setDouble(5, profesor.getSueldo());
            stm.setInt(6, profesor.getNumEmpleado());

            int filas = stm.executeUpdate();

            conexion.commit();

            if(filas > 0){
                actualizado = true;
                System.out.println("Profesor actualizado correctamente");
            }else{
                System.out.println("No existe un profesor con ese número de empleado.");
            }

        }catch(SQLException e){

            try{
                if(conexion != null){
                    conexion.rollback();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }

            System.out.println(e.getMessage());
        }

        return actualizado;
    }

    public boolean bajaProfesor(int numEmpleado){

        boolean eliminado = false;

        String sql = "DELETE FROM profesores WHERE numEmpleado=?";

        Connection conexion = null;

        try{

            conexion = Conexion.conectar();
            conexion.setAutoCommit(false);

            PreparedStatement stm = conexion.prepareStatement(sql);

            stm.setInt(1, numEmpleado);

            int filas = stm.executeUpdate();

            conexion.commit();

            if(filas > 0){
                eliminado = true;
                System.out.println("Profesor eliminado correctamente");
            }else{
                System.out.println("No existe un profesor con ese número de empleado.");
            }

        }catch(SQLException e){

            try{
                if(conexion != null){
                    conexion.rollback();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }

            System.out.println(e.getMessage());
        }

        return eliminado;
    }

    public Profesor buscarProfesor(int numEmpleado){

        Profesor profesor = null;

        String sql = "SELECT * FROM profesores WHERE numEmpleado=?";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            stm.setInt(1, numEmpleado);

            ResultSet rs = stm.executeQuery();

            if(rs.next()){

                profesor = new Profesor();

                profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setCurp(rs.getString("curp"));
                profesor.setNombreEmpleado(rs.getString("nombreEmpleado"));
                profesor.setPuesto(rs.getString("puesto"));
                profesor.setSueldo(rs.getDouble("sueldo"));
            }

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());

        }

        return profesor;
    }

}