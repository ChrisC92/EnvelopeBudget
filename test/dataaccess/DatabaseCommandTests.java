package dataaccess;

import main.java.dataaccess.DatabaseCommands;
import main.java.listdata.Envelope;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dataaccess.inserttestdata.InsertToTestDatabase;

import java.sql.SQLException;


/**
 * Database commands holds numerous static methods for communicating with dataaccess data
 * all tests will use the TestSavedData dataaccess
 */
public class DatabaseCommandTests {
    private String connURL = "jdbc:sqlite:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/dataaccess/databasefiles/TestSavedData.sqlite";
    private Envelope fullFunds = new Envelope("full funds", Envelope.EnvelopeCat.GENERAL, 1000, false);
    private Envelope partialFunds = new Envelope("partial funds", Envelope.EnvelopeCat.GENERAL, 1000, false);
    private Envelope fundsSpent = new Envelope("funds spent", Envelope.EnvelopeCat.CREDITCARD, 1000, false);


    @BeforeClass
    public void initialise() {
        DatabaseCommands.clearEnvelopesTableTestDb(connURL);
        InsertToTestDatabase.insertThreeEnvelopes(connURL);
        fullFunds.deductFunds(750);
        fundsSpent.deductFunds(1000);

    }

    // Methods assume that methods for saving into tables are correct, tested through checking test data saved
    @Test
    public void getEnvelopeID() {

        int fullID = DatabaseCommands.getEnvelopeID(fullFunds, connURL);
    }


    @Test
    public void getTotalFundsFromName() {

    }

    @Test
    public void getFundsRemainingFromName() {

    }

    @Test
    public void getTypeFromName() {

    }

    @Test
    public void getRecurringFromName() {

    }

    @Test
    public void getAllFromType() {

    }

    @Test
    public void getAllFromRecurring() {

    }

    @Test
    public void loadAllFromDatabase() {

    }


    // next set of tests will be for checking the saving into different months

}