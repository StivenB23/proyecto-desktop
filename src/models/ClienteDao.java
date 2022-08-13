/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author andre
 */
public class ClienteDao {

    public Connection con;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    String query = null;
    int root;

    public void save(ClienteVo cliente) throws SQLException {
        query = "INSERT INTO `cliente`(`idcliente`, `cedulacliente`, `estado`, `nombre`, `telefono`) VALUES VALUES (?,?,?,?,?)";

        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            preparedstatement.setString(1, cliente.getCedulaCliente());
            preparedstatement.setString(2, cliente.getNombre());
            preparedstatement.setString(3, cliente.getTelefono());
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (Exception e) {
            System.out.println("Fallamas" + e.getMessage());
        } finally {
            con.close();
        }
    }

    public List<ClienteVo> list() throws SQLException {
        List<ClienteVo> listaCliente = new ArrayList<>();

        query = "SELECT * FROM CLIENTE";

        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            resultset = preparedstatement.executeQuery(query);
            while (resultset.next()) {
                ClienteVo clienterow = new ClienteVo();

                clienterow.setIdcliente(resultset.getInt("idcliente"));
                clienterow.setCedulaCliente(resultset.getString("cedulacliente "));
                clienterow.setNombre(resultset.getString("nombre"));
                clienterow.setTelefono(resultset.getString("telefono"));
                clienterow.setEstado(resultset.getBoolean("estado"));
                
                listaCliente.add(clienterow);
            }
            preparedstatement.close();
        } catch (Exception e) {
            System.out.println("Fallamos" + e.getMessage());
        } finally {
            con.close();
        }
        return listaCliente; 
    }
    
    public void inactivar (Integer id) throws SQLException{
        query = "UPDATE cliente SET estado = 0 WHERE idcliente = " + id;
        
        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (Exception e) {
            System.out.println("Fallamos" + e.getMessage());
        } finally {
            con.close();
        }
    }
    
    public void activar (Integer id) throws SQLException{
        query = "UPDATE cliente SET estado = 1 WHERE idcliente = " + id;
        
        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (Exception e) {
            System.out.println("Fallamos" + e.getMessage());
        } finally {
            con.close();
        }
    }
    
    public void update (Integer id, String nombre, String telefono) throws SQLException{
        query = "UPDATE cliente SET nombre = '"+ nombre +"' telefono = '"+ telefono +"' WHERE idcliente = " + id;
        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (Exception e) {
            System.out.println("Fallamos" + e.getMessage());
        } finally {
            con.close();
        }
    }
}