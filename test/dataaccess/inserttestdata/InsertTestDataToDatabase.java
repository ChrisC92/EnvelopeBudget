package dataaccess.inserttestdata;

import dataaccess.createdata.CreateEnvelopeData;
import main.java.dataaccess.DatabaseCommands;
import main.java.dataaccess.insertToDB;
import main.java.envelopedata.Envelopes;

import java.sql.Date;
import java.time.LocalDate;


public class InsertTestDataToDatabase {

    private DatabaseCommands dbCommands = new DatabaseCommands("jdbc:sqlite:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/dataaccess/databasefiles/TestSavedData.sqlite");
    private insertToDB insertToDB = new insertToDB(dbCommands);


    public void insertTestEnvelopes() {

        CreateEnvelopeData envelopeData = new CreateEnvelopeData();
        Envelopes envelopes = envelopeData.createEnvelopeData();
        dbCommands.clearEnvelopesTable();
        insertToDB.saveCurrentToDB(envelopes);
    }

    public void insertRecurringEnvelopes() {
        CreateEnvelopeData envelopeData = new CreateEnvelopeData();
        Envelopes envelopes = envelopeData.createEnvelopeData();
        dbCommands.clearPreviousEnvelopesTable();

        Date lastMonth = Date.valueOf(LocalDate.now().minusMonths(1));
        Date today = Date.valueOf(LocalDate.now());

        insertToDB.saveRecurringToDB(envelopes, lastMonth);
        insertToDB.saveRecurringToDB(envelopes, today);
    }


    public static void main(String[] args) {
        InsertTestDataToDatabase testData = new InsertTestDataToDatabase();

//        testData.insertTestEnvelopes();



        testData.insertRecurringEnvelopes();
    }

}
