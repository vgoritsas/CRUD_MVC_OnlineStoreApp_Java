/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestoreapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Evanggelos
 */
public class DBC {

    private Connection conn;

    // constructor
    public DBC() {
        // initialize  
        this.conn = null;
    }

    public Connection doConnect() {
        // check if conn is null
        if (this.conn == null) {
           
        
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvapp", "root", "");

          
           

            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            }
            return this.conn; // return connection
        } else {

            return this.conn;

        }
    }

}
