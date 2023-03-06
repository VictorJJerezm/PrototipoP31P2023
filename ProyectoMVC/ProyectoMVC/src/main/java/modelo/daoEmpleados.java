/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsEmpleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoEmpleados {

    private static final String SQL_SELECT = "SELECT codigo_empleado, nombre_empleado, codigo_puesto, codigo_departamento, estatus_empleado FROM sin.empleado2";
    private static final String SQL_INSERT = "INSERT INTO sin.empleado2(nombre_empleado, codigo_puesto, codigo_departamento, estatus_empleado) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE sin.empleado2 SET nombre_empleado=?, codigo_puesto=?, codigo_departamento=?, estatus_empleado=? WHERE codigo_empleado = ?";
    private static final String SQL_DELETE = "DELETE FROM sin.empleado2 WHERE codigo_empleado=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_empleado, nombre_empleado, codigo_puesto, codigo_departamento, estatus_empleado FROM sin.empleado2 WHERE nombre_empleado = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_empleado, nombre_empleado, codigo_puesto, codigo_departamento, estatus_empleado FROM sin.empleado2 WHERE codigo_empleado = ?";    

    public List<clsEmpleado> consultaEmpleados() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsEmpleado> empleado = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_empleado");
                String nombre = rs.getString("nombre_empleado");
                String codigop = rs.getString("codigo_puesto");
                String codigod = rs.getString("codigo_departamento");
                String estatus = rs.getString("estatus_empleado");
                clsEmpleado empleados = new clsEmpleado();
                empleados.setCodigoEmpleado(codigo);
                empleados.setNombreEmpleado(nombre);
                empleados.setCodigoPuesto(codigop);
                empleados.setCodigoDepartamento(codigod);
                empleados.setEstatusEmpleado(estatus);
                empleado.add(empleados);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return empleado;
    }

    public int ingresaEmpleados(clsEmpleado empleados) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleados.getNombreEmpleado());
            stmt.setString(2, empleados.getCodigoPuesto());
            stmt.setString(3, empleados.getCodigoDepartamento());
            stmt.setString(4, empleados.getEstatusEmpleado());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaEmpleados(clsEmpleado empleados) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleados.getNombreEmpleado());
            stmt.setString(2, empleados.getCodigoPuesto());
            stmt.setString(3, empleados.getCodigoDepartamento());
            stmt.setString(4, empleados.getEstatusEmpleado());
            stmt.setInt(4, empleados.getCodigoEmpleado());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarEmpleados(clsEmpleado empleados) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleados.getCodigoEmpleado());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsEmpleado consultaEmpleadoPorNombre(clsEmpleado empleados) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + empleados);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicaiones.getIdAplicacion());            
            stmt.setString(1, empleados.getNombreEmpleado());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_empleado");
                String nombre = rs.getString("nombre_empleado");
                String codigop = rs.getString("codigo_puesto");
                String codigod = rs.getString("codigo_departamento");
                String estatus = rs.getString("estatus_empleado");

                
                empleados.setCodigoEmpleado(codigo);
                empleados.setNombreEmpleado(nombre);
                empleados.setCodigoPuesto(codigop);
                empleados.setCodigoDepartamento(codigod);
                empleados.setEstatusEmpleado(estatus);
                System.out.println(" registro consultado: " + empleados);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return empleados;
    }
    public clsEmpleado consultaEmpleadosPorId(clsEmpleado empleados) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + empleados);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, empleados.getCodigoEmpleado());            
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_empleado");
                String nombre = rs.getString("nombre_empleado");
                String codigop = rs.getString("codigo_puesto");
                String codigod = rs.getString("codigo_departamento");
                String estatus = rs.getString("estatus_empleado");

               
                empleados.setCodigoEmpleado(codigo);
                empleados.setNombreEmpleado(nombre);
                empleados.setCodigoPuesto(codigop);
                empleados.setCodigoDepartamento(codigod);
                empleados.setEstatusEmpleado(estatus);
                System.out.println(" registro consultado: " + empleados);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return empleados;
    }   
}
