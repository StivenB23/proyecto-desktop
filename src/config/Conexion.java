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
    private static final String bbdd = "jdbc:mysql://localhost:3306/senasoft";
    private static final String user = "root";
    private static final String password = "";
    private static Connection con;
    
    public static Connection connection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(bbdd, user, password);
            System.out.println("CONEXIÓN EXITOSA");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return con;
    }
    public static void main(String[] args) {
        Conexion.connection();
    }
}
