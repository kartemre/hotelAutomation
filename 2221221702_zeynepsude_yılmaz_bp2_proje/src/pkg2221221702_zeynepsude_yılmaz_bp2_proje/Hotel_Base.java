/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2221221702_zeynepsude_yılmaz_bp2_proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zeysu
 */
public class Hotel_Base {
      static final String connectionString = "jdbc:mysql://127.0.0.1:3306/login?user=root&password=893265Azra";
    static Connection conn = null;
    
    // Gets the connection object
    public static Connection getConnection() {    
        try {
            conn = (Connection) DriverManager
                .getConnection(connectionString);
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(
                Hotel_database.class.getName()).log(Level.SEVERE, 
                null, 
                ex
            );
        }
        
        return null;
    
}
}
