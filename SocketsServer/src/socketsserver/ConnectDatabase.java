/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aleli
 */
public class ConnectDatabase {

    public static Connection getConnection() {

        Connection conn;

        try {

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String sUrl = "jdbc:mysql://localhost:3306/series_sockets?userTimezone=true&serverTimezone=GMT";
            conn = DriverManager.getConnection(sUrl, "root", "1234");

        } catch (SQLException ex) {
            conn = null;
            throw new RuntimeException("Error con la conexión : " + ex.getMessage());
        }
        return conn;

    }

    public static String getSynopsis(String id) {
        String query = "";
        ResultSet result;
        String resultado = "vacio";
        try {
            query = "SELECT * FROM series where id=" + id;
            Statement sentencia = ConnectDatabase.getConnection().createStatement();
            result = sentencia.executeQuery(query);

            result.next();
            resultado = result.getString("sinopsis");
            sentencia.close();
            
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return resultado;
    }
}
