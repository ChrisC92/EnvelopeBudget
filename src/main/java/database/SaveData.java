package main.java.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.listdata.Envelope;
import main.java.listdata.Envelopes;

import java.sql.Connection;
import java.sql.SQLException;

public class SaveData {

    public static void saveToDB(Envelopes envelopes) {

        String databaseLocation = "jdbc:sqlite:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/database/TestSavedData.sqlite";
        for(Envelope envelope : envelopes.getList()) {
            DatabaseCommands.insertCurrentEnvelopesToDB(envelope, databaseLocation);
        }

    }


    private static void setAutoCommitFalse(Connection conn) {
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("unable to set auto commit to false");
            System.out.println(e.getMessage());
        }
    }

    private static void connectionCommitAndClose(Connection conn) {
        try {
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            System.out.println("connection cannot commit and close: ");
            System.out.println(e.getMessage());
        }

    }


    public static void main(String[] args) {

        ObservableList<Envelope> listEnvelopes = FXCollections.observableArrayList();

        Envelope env1 = new Envelope("env1", Envelope.EnvelopeCat.CREDITCARD, 100,
                false);
        Envelope env2 = new Envelope("env2", Envelope.EnvelopeCat.GENERAL, 100,
                false);
        Envelope env3 = new Envelope("env3", Envelope.EnvelopeCat.CREDITCARD, 100,
                false);

        listEnvelopes.add(env1);
        listEnvelopes.add(env2);
        listEnvelopes.add(env3);

        Envelopes envelopes = new Envelopes(listEnvelopes);

        SaveData.saveToDB(envelopes);

    }
}
