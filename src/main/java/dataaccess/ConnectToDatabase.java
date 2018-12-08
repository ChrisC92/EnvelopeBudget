package main.java.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase {

    public static Connection connect(String url) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            return conn;
        } catch(SQLException e) {
            System.out.printf(e.getMessage());
        }
        return conn;
    }

}


