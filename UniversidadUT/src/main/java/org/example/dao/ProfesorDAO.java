package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesorDAO {

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
                System.out.println("Profesor agregado");
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
}