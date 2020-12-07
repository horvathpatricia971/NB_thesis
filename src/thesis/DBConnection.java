/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author horvathpatricia
 */
    
public class DBConnection {
    private static Connection conn;
    private static final String URL = "jdbc:mysql://localhost:3306/language_db?serverTimezone=UTC";
    private static final String Username = "root";
    private static final String Password = "Database";
    
    public static Connection getInstance() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(URL, Username, Password);
        }
        return conn;
    }
    
    
    
}
