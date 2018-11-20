package dataaccess;

import main.java.dataaccess.DatabaseCommands;
import main.java.listdata.Envelope;
import org.junit.BeforeClass;
import org.junit.Test;
import dataaccess.inserttestdata.InsertTestDataToDatabase;


/**
 * Database commandsDB holds numerous static methods for communicating with dataaccess data
 * all tests will use the TestSavedData dataaccess
 */
public class DatabaseCommandTests {

    private DatabaseCommands commandsDB = new DatabaseCommands();
    private InsertTestDataToDatabase insertToDB = new InsertTestDataToDatabase();
    private Envelope fullFunds = new Envelope("full funds", Envelope.EnvelopeCat.GENERAL, 1000, false);
    private Envelope partialFunds = new Envelope("partial funds", Envelope.EnvelopeCat.GENERAL, 1000, false);
    private Envelope fundsSpent = new Envelope("funds spent", Envelope.EnvelopeCat.CREDITCARD, 1000, false);


    @BeforeClass
    public void initialise() {
        commandsDB.clearEnvelopesTableTestDb();
        insertToDB.insertThreeEnvelopes();
        partialFunds.deductFunds(750);
        fundsSpent.deductFunds(1000);

    }

    // Methods assume that methods for saving into tables are correct, tested through checking test data saved
    @Test
    public void getEnvelopeID() {

        //int fullID = DatabaseCommands.getEnvelopeID(fullFunds, connURL);
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