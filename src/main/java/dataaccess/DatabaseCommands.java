package main.java.dataaccess;

import main.java.envelopedata.Envelope;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

import static main.java.envelopedata.Envelope.EnvelopeCat;

public class DatabaseCommands {

    private String connURL;

    // "jdbc:sqlite:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/dataaccess/databasefiles/TestSavedData.sqlite";

    public DatabaseCommands(String connURL) {
        this.connURL = connURL;
    }


    public void insertCurrentEnvelopeToDB(Envelope envelope) {
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

    public void saveRecurringForMonth(Envelope envelope, int envelopeID, Date date) {
        String sql = "INSERT INTO previousEnvelopes (nameID, totalFunds, " +
                "fundsRemaining, type, date) VALUES (?,?,?,?,?)";

        Connection conn = ConnectToDatabase.connect(connURL);
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, envelopeID);
            pstmt.setDouble(2, envelope.getTotalFunds());
            pstmt.setDouble(3, envelope.getRemainingFunds());
            pstmt.setString(4, envelope.getType().name());
            pstmt.setDate(5, date);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("exception in saving recurring");
            e.printStackTrace();
        }
    }

    public void clearEnvelopesTable() {
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

    public void clearPreviousEnvelopesTable() {
        Connection conn = ConnectToDatabase.connect(connURL);
        try {
            Statement statement = conn.createStatement();

            String delete = "DELETE FROM previousEnvelopes";
            statement.executeUpdate(delete);
            statement.executeUpdate("VACUUM");
        } catch (SQLException e) {
            System.out.println("error clearing previous envelopes");
            e.printStackTrace();
        }
    }

    public Optional<Integer> getEnvelopeID(Envelope envelope) {
        String sql = "SELECT nameID FROM envelopes WHERE name = ?";
        Optional<Integer> envID = Optional.empty();
        try {
            Connection conn = ConnectToDatabase.connect(connURL);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, envelope.getName());

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int i = resultSet.getInt("nameID");
                statement.close();
                conn.close();
                resultSet.close();
                return envID.of(new Integer(i));
            }
            return envID;
        } catch (SQLException e) {
            System.out.println("error in getting envelope id");
            e.printStackTrace();
            return envID;
        }
    }

    public Optional<Integer> getTotalFundsFromName(String name) {


        return Optional.empty();
    }

    public Optional<Integer> getRemainingFundsFromName(String name) {

        return Optional.empty();
    }

    public Optional<EnvelopeCat> getTypeFromName(String name) {

        return Optional.empty();
    }

    public boolean getRecurringFromName(String name) {

        return false;
    }

    public static void main(String[] args) {
        DatabaseCommands commands = new DatabaseCommands("jdbc:sqlite:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/dataaccess/databasefiles/TestSavedData.sqlite");

        Envelope envelope = new Envelope("no working", EnvelopeCat.GENERAL, 105000, true);
        Date date = Date.valueOf(LocalDate.now());
        commands.saveRecurringForMonth(envelope, 1000, date);
    }
}

