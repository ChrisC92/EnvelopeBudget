package main.java.database;

import main.java.listdata.Envelope;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCommands {


    // connURL for test = jdbc:sqlite:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/database/TestSavedData.sqlite
    // connURL for real = jdbc:sqlite:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/database/savedData.sqlite
    public static void insertCurrentEnvelopesToDB(Envelope envelope, String connURL) {
        String sql = "INSERT INTO envelope (name, type, totalFunds, " +
                "fundsLeft, recurring) VALUES (?, ?, ?, ?, ?)";

        Connection conn = ConnectToDatabase.connect(connURL);
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, envelope.getName());
            pstmt.setString(2, envelope.getType().name());
            pstmt.setDouble(3, envelope.getTotalFunds());
            pstmt.setDouble(4, envelope.getRemainingFunds());
            pstmt.setString(5, envelope.getRecurringAsString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error with inserted through prepared statement");
            e.printStackTrace();
        }

    }

    public static void clearEnvelopesTableTestDb() {

        Connection conn = ConnectToDatabase.connect("jdbc:sqlite:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/database/TestSavedData.sqlite");
        try {
            Statement statement = conn.createStatement();

            String delete = "DELETE FROM envelope";
            statement.executeUpdate(delete);

            statement.executeUpdate("VACUUM");

        } catch (SQLException e) {
            System.out.println("error clearing rows in the envelope table");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        DatabaseCommands.clearEnvelopesTableTestDb();
    }
}
