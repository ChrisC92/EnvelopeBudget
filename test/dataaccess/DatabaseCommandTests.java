package dataaccess;

import main.java.dataaccess.DatabaseCommands;
import main.java.envelopedata.Envelope;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;


/**
 * Database commandsDB holds numerous static methods for communicating with dataaccess data
 * all tests will use the TestSavedData dataaccess
 */
public class DatabaseCommandTests {

    private DatabaseCommands commandsDB = new DatabaseCommands("jdbc:sqlite:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/dataaccess/databasefiles/TestSavedData.sqlite");
    private Envelope fullFunds = new Envelope("full funds GENERAL", Envelope.EnvelopeCat.GENERAL, 1000, false);
    private Envelope partialFunds = new Envelope("partial funds CREDIT", Envelope.EnvelopeCat.GENERAL, 1000, false);
    private Envelope savings = new Envelope("add first savings", Envelope.EnvelopeCat.CREDITCARD, 1000, false);


    // Methods assume that methods for saving into tables are correct, tested through checking test data saved
    @Test
    public void getEnvelopeID() {
        Optional<Integer> fullFundsID = commandsDB.getEnvelopeID(fullFunds);
        fullFundsID.ifPresent(user -> {
            assertEquals(1, user.intValue());
        });

        Optional<Integer> partialFundsID = commandsDB.getEnvelopeID(partialFunds);
        partialFundsID.ifPresent(user -> {
            assertEquals(5, user.intValue());
        });

        Optional<Integer> savingsID = commandsDB.getEnvelopeID(savings);
        savingsID.ifPresent(user -> {
            assertEquals(6, user.intValue());
        });

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