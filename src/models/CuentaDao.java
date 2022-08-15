/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import config.Conexion;
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
public class CuentaDao {

    public Connection con;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    String query = null;
    int root;

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
    
    public void inactivar (int id) throws SQLException{
        query = "UPDATE cuenta SET estado = 0 WHERE idcuenta = " + id;
        
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
    
    public void activar (int id) throws SQLException{
        query = "UPDATE cuenta SET estado = 1 WHERE idcuenta = " + id;
        
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
    
    public void update (int id, String titular, double saldo, String fechaapertura) throws SQLException{
        query = "UPDATE cuenta SET titular = '"+ titular +"' saldo = '"+ saldo +"' fechaapertura = '"+ fechaapertura +"' WHERE idcuenta = " + id;
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
    
//    public void deposit (int id, int saldo) throws SQLException{
//        
//        query = "UPDATE cuenta SET saldo = '"+ saldo +"' WHERE idcuenta = " + id;
//        try {
//            con = Conexion.connection();
//            preparedstatement = con.prepareStatement(query);
//            preparedstatement.executeUpdate();
//            preparedstatement.close();
//        } catch (Exception e) {
//            System.out.println("Fallamos" + e.getMessage());
//        } finally {
//            con.close();
//        }
//    }
}