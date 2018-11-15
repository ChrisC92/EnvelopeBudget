package main.java.dataaccess;

import main.java.listdata.Envelope;

import java.sql.*;

public class DatabaseCommands {

    /**
     * Two different databases are used within these commands, one real and one test. Both are mirrored with same
     * tables and schemas -
     * <p>
     * connURL for test = "jdbc:dataaccess:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/dataaccess/databasefiles/TestSavedData.sqlite"
     */
    public static void insertCurrentEnvelopeToDB(Envelope envelope, String connURL) {
        String sql = "INSERT INTO envelopes (name, type, totalFunds, " +
                "fundsRemaining, recurring) VALUES (?, ?, ?, ?, ?)";

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

    public static void clearEnvelopesTableTestDb(String connURL) {
        Connection conn = ConnectToDatabase.connect(connURL);
        try {
            Statement statement = conn.createStatement();

            String delete = "DELETE FROM envelopes";
            statement.executeUpdate(delete);

            statement.executeUpdate("VACUUM");

        } catch (SQLException e) {
            System.out.println("error clearing rows in the envelope table");
            e.printStackTrace();
        }
    }

    public static void saveRecurringForMonth(Envelope envelope, String connURL) {
        String sql = "INSERT INTO previousEnvelopes (";

        Connection conn = ConnectToDatabase.connect(connURL);

        try {
            Statement statement = conn.createStatement();


        } catch (SQLException e) {
            System.out.println("exception in saving recurring");
            e.printStackTrace();
        }
    }


    public static int getEnvelopeID(Envelope envelope, String connURL) throws SQLException {
        String sql = "SELECT nameID FROM envelopes WHERE name = " + envelope.getName();

        try {
            Connection conn = ConnectToDatabase.connect(connURL);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet.getInt("nameID");
        } catch(SQLException e) {
            System.out.println("error in getting envelope id");
            throw e;
        }
    }

}
