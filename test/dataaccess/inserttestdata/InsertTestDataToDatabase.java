package dataaccess.inserttestdata;

import dataaccess.createdata.CreateEnvelopeData;
import main.java.dataaccess.DatabaseCommands;
import main.java.listdata.Envelope;
import main.java.listdata.Envelopes;

public class InsertTestDataToDatabase {

    private String connURL = "jdbc:sqlite:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/dataaccess/databasefiles/TestSavedData.sqlite";

    public void insertThreeEnvelopes() {
        DatabaseCommands commands = new DatabaseCommands();
        Envelopes envelopes = CreateEnvelopeData.createEnvelopeListSizeThree();

        for (Envelope envelope : envelopes.getList()) {
            commands.insertCurrentEnvelopeToDB(envelope);
        }
    }


}
