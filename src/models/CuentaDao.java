/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class CuentaDao {

    public Connection con;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    String query = null;
    int root;
    boolean success = false;

    public void save(CuentaVo cuenta) throws SQLException {
        query = "INSERT INTO `cuenta`(`numerocuenta`, `titular`, `estado`, `fechaapertura`, `saldo`, `idcliente`) VALUES (?,?,?,?,?,?)";

        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            preparedstatement.setInt(1, cuenta.getNumeroCuenta());
            preparedstatement.setString(2, cuenta.getTitular());
            preparedstatement.setBoolean(3, cuenta.isEstado());
            preparedstatement.setString(4, cuenta.getFechaApertura());
            preparedstatement.setDouble(5, cuenta.getSaldo());
            preparedstatement.setInt(6, cuenta.getIdCliente());
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (Exception e) {
            System.out.println("Fallamos" + e.getMessage());
        } finally {
            con.close();
        }
    }

    public List<CuentaVo> list() throws SQLException {
        List<CuentaVo> listaCuenta = new ArrayList<>();

        query = "SELECT * FROM CUENTA";

        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            resultset = preparedstatement.executeQuery(query);
            while (resultset.next()) {
                CuentaVo cuentarow = new CuentaVo();

                cuentarow.setIdCuenta(resultset.getInt("idcuenta"));
                cuentarow.setNumeroCuenta(resultset.getInt("numerocuenta"));
                cuentarow.setTitular(resultset.getString("titular"));
                cuentarow.setEstado(resultset.getBoolean("estado"));
                cuentarow.setSaldo(resultset.getDouble("saldo"));
                cuentarow.setFechaApertura(resultset.getString("fechaapertura"));
                cuentarow.setIdCliente(resultset.getInt("idcliente"));

                listaCuenta.add(cuentarow);
            }
            preparedstatement.close();
        } catch (Exception e) {
            System.out.println("Fallamos" + e.getMessage());
        } finally {
            con.close();
        }
        return listaCuenta;
    }

    public boolean changeStatus(int numberAccount) throws SQLException {
        query = "SELECT * FROM `cuenta` WHERE numerocuenta =" + numberAccount;
        boolean status = false;
        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            resultset = preparedstatement.executeQuery(query);
            while (resultset.next()) {
                CuentaVo accountVo = new CuentaVo();
                status = resultset.getBoolean("estado");
                System.out.println(status);
                if (status == true) {
                    inactivar(numberAccount);
                } else {
                    activar(numberAccount);
                }
            }
        } catch (Exception e) {
            System.out.println("no se encontro el numero de cuenta" + numberAccount + e.getMessage());
        } finally {
            con.close();
        }
        preparedstatement.close();
        return status;
    }

    public void inactivar(int numberAccount) throws SQLException {
        query = "UPDATE cuenta SET estado = 0 WHERE numerocuenta = " + numberAccount;

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

    public void activar(int numberAccount) throws SQLException {
        query = "UPDATE cuenta SET estado = 1 WHERE numerocuenta = " + numberAccount;

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

    public void delete(int numberAccount) throws SQLException {
        query = "Delete from cuenta WHERE numerocuenta = " + numberAccount;

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
    
    public ArrayList<CuentaVo> getCuentaVo() {

        query = "SELECT * FROM cuenta";

        ArrayList<CuentaVo> listAccounts = new ArrayList<>();

        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            resultset = preparedstatement.executeQuery(query);

            while (resultset.next()) {
                CuentaVo cuentarow = new CuentaVo();

                cuentarow.setIdCuenta(resultset.getInt("idcuenta"));
                cuentarow.setNumeroCuenta(resultset.getInt("numerocuenta"));
                cuentarow.setTitular(resultset.getString("titular"));
                cuentarow.setEstado(resultset.getBoolean("estado"));
                cuentarow.setSaldo(resultset.getDouble("saldo"));
                cuentarow.setFechaApertura(resultset.getString("fechaapertura"));
                cuentarow.setIdCliente(resultset.getInt("idcliente"));

                listAccounts.add(cuentarow);
            }
        } catch (Exception e) {
            System.out.println("Fallamos al traer clientes 😦 " + e.getMessage());

        }
        return listAccounts;
    }
    
    public void deposit(int numberAccount, double saldo) throws SQLException {
        query = "UPDATE cuenta SET saldo = '" + saldo + "' WHERE numerocuenta = " + numberAccount;

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
    
    public void retirar(int numberAccount, double saldo) throws SQLException {
        query = "UPDATE cuenta SET saldo = '" + saldo + "' WHERE numerocuenta = " + numberAccount;

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
