package database;

import database.createdata.CreateEnvelopeData;
import main.database.CommandTemplates;
import main.database.ConnectToDatabase;
import main.listdata.Envelopes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertToTestDatabase {

    public void insertData(Connection conn) {
        Statement statement = null;
        Envelopes envelopes = CreateEnvelopeData.createEnvelopeListSizeThree();

        String sql = CommandTemplates.createInsertEnvelopeTable(envelopes.getFromIndex(0));

        try {
            statement = conn.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        Connection connection = ConnectToDatabase.connect("jdbc:sqlite:src/main/database/testSavedData.sqlite");

        InsertToTestDatabase insertDatabase = new InsertToTestDatabase();
        insertDatabase.insertData(connection);
    }


}
