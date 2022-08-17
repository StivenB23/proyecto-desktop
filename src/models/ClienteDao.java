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
import javax.swing.JComboBox;

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
        query = "INSERT INTO `cliente`(`cedulacliente`, `estado`, `nombre`, `telefono`) VALUES (?, ?, ?, ?)";

        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            preparedstatement.setString(1, cliente.getCedulaCliente());
            preparedstatement.setBoolean(2, cliente.getEstado());
            preparedstatement.setString(3, cliente.getNombre());
            preparedstatement.setString(4, cliente.getTelefono());
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (Exception e) {
            System.out.println("Fallamos " + e.getMessage());
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
                clienterow.setCedulaCliente(resultset.getString("cedulacliente"));
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

    public boolean changeStatus(String cedula) throws SQLException {
        query = "SELECT * FROM `cliente` WHERE cedulaCliente =" + cedula;
        boolean status = false;
        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            resultset = preparedstatement.executeQuery(query);
            while (resultset.next()) {
                ClienteVo cedulaVo = new ClienteVo();
                status = resultset.getBoolean("estado");
                System.out.println(status);
                if (status == true) {
                    inactivar(cedula);
                } else {
                    activar(cedula);
                }
            }
        } catch (Exception e) {
            System.out.println("no se encontro la cedula" + cedula + e.getMessage());
        } finally {
            con.close();
        }
        preparedstatement.close();
        return status;
    }

    public void inactivar(String cedula) throws SQLException {
        query = "UPDATE cliente SET estado = 0 WHERE cedulaCliente = " + cedula;

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

    public void activar(String cedula) throws SQLException {
        query = "UPDATE cliente SET estado = 1 WHERE cedulaCliente = " + cedula;

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

    public void update(Integer id, String nombre, String telefono) throws SQLException {
        query = "UPDATE cliente SET nombre = '" + nombre + "' telefono = '" + telefono + "' WHERE idcliente = " + id;
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

    public void delete(String cedula) throws SQLException {
        query = "Delete from cliente WHERE cedulacliente = " + cedula;

        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar desde el dao" + e.getMessage());
        } finally {
            con.close();
        }
    }

    public ArrayList<ClienteVo> getClienteVo() {

        query = "SELECT * FROM cliente";

        ArrayList<ClienteVo> listClients = new ArrayList<>();

        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            resultset = preparedstatement.executeQuery(query);

            while (resultset.next()) {
                ClienteVo cliente = new ClienteVo();

                cliente.setIdcliente(resultset.getInt("idcliente"));
                cliente.setCedulaCliente(resultset.getString("cedulacliente"));
                cliente.setNombre(resultset.getString("nombre"));
                cliente.setTelefono(resultset.getString("telefono"));
                cliente.setEstado(resultset.getBoolean("estado"));

                listClients.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Fallamos al traer clientes 😦 " + e.getMessage());

        }
        return listClients;
    }
}
