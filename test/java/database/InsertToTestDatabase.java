package java.database;

import java.database.createdata.CreateEnvelopeData;
import main.java.database.DatabaseCommands;
import main.java.database.ConnectToDatabase;
import main.java.listdata.Envelopes;

import java.sql.Connection;
import java.sql.Statement;

public class InsertToTestDatabase {

    public void insertData(Connection conn) {
        Statement statement = null;
        Envelopes envelopes = CreateEnvelopeData.createEnvelopeListSizeThree();

        DatabaseCommands.insertCurrentEnvelopesToDB(envelopes.getFromIndex(0));
    }


    public static void main(String[] args) {
        Connection connection = ConnectToDatabase.connect("jdbc:sqlite:src/main/java.database/testSavedData.sqlite");

        InsertToTestDatabase insertDatabase = new InsertToTestDatabase();
        insertDatabase.insertData(connection);
    }


}
