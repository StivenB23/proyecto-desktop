/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Aprendiz
 */
public class Conexion {
    public Connection con;
    
    public Connection connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/senasoft","root","");
            System.out.println("CONEXIÓN EXITOSA");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return con;
    }
    public static void main(String[] args) {
        Conexion con =new Conexion();
        con.connection(); 
    }
}
