package dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLiteConnectionTest {

    public static void connect() {
        Connection conn = null;

        try {
            String url = "jdbc:sqlite:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/dataaccess/databasefiles/NewTest.sqlite";
            conn = DriverManager.getConnection(url);
            System.out.println("connection to SQLite has been established");
        } catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        connect();
    }
}
