package dataaccess.inserttestdata;

import dataaccess.createdata.CreateEnvelopeData;
import main.java.dataaccess.DatabaseCommands;
import main.java.listdata.Envelope;
import main.java.listdata.Envelopes;

public class InsertToTestDatabase {

    public static void insertThreeEnvelopes(String connURL) {

        Envelopes envelopes = CreateEnvelopeData.createEnvelopeListSizeThree();

        for (Envelope envelope : envelopes.getList()) {
            DatabaseCommands.insertCurrentEnvelopeToDB(envelope, connURL);
        }
    }


}
