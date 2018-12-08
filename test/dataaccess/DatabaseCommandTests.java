package dataaccess;

import main.java.dataaccess.DatabaseCommands;
import main.java.envelopedata.Envelope;
import org.junit.Test;
import java.util.Optional;
import static org.junit.Assert.*;
import static main.java.envelopedata.Envelope.*;


/**
 * Database commandsDB holds numerous static methods for communicating with dataaccess data
 * all tests will use the TestSavedData dataaccess
 */
public class DatabaseCommandTests {

    private DatabaseCommands commandsDB = new DatabaseCommands("jdbc:sqlite:/Users/ChrisCorner/Programming/Java/Projects/EnvelopeBudget/src/main/java/dataaccess/databasefiles/TestSavedData.sqlite");
    private Envelope fullFunds = new Envelope("full funds GENERAL", Envelope.EnvelopeCat.GENERAL, 1000, false);
    private Envelope partialFunds = new Envelope("partial funds CREDIT", Envelope.EnvelopeCat.GENERAL, 1000, false);
    private Envelope fullCredit = new Envelope("full funds CREDIT", EnvelopeCat.CREDITCARD, 2000, true);
    private Envelope savings = new Envelope("add first savings", Envelope.EnvelopeCat.CREDITCARD, 1000, false);

    private Envelope nonExistant = new Envelope("none", Envelope.EnvelopeCat.GENERAL, 100, false);

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

        Optional<Integer> badReturn = commandsDB.getEnvelopeID(nonExistant);
        badReturn.ifPresent(user -> {
            assertEquals(Optional.empty(), user.intValue());
        });

    }

    @Test
    public void getTotalFundsFromName() {
        Optional<Integer> generalFullFunds = commandsDB.getTotalFundsFromName(fullFunds.getName());
        generalFullFunds.ifPresent(funds -> {
            assertEquals(1000, funds.intValue());
        });

        Optional<Integer> creditPartialFunds = commandsDB.getTotalFundsFromName(partialFunds.getName());
        creditPartialFunds.ifPresent(funds -> {
            assertEquals(1800, funds.intValue());
        });

        Optional<Integer> savingsFunds = commandsDB.getTotalFundsFromName(savings.getName());
        savingsFunds.ifPresent(funds -> {
            assertEquals(250, funds.intValue());
        });

    }

    @Test
    public void getFundsRemainingFromName() {
        Optional<Integer> generalFundsLeft = commandsDB.getRemainingFundsFromName(fullFunds.getName());
        generalFundsLeft.ifPresent(funds -> {
            assertEquals(1000, funds.intValue());
        });

        Optional<Integer> creditRemainingFunds = commandsDB.getRemainingFundsFromName(fullFunds.getName());
        creditRemainingFunds.ifPresent(funds -> {
            assertEquals(800, funds.intValue());
        });

    }

    @Test
    public void getTypeFromName() {
        Optional<EnvelopeCat> generalType = commandsDB.getTypeFromName(fullFunds.getName());
        generalType.ifPresent(cat -> {
            assertEquals(EnvelopeCat.GENERAL, cat.name());
        });

        Optional<EnvelopeCat> savingsType = commandsDB.getTypeFromName(fullFunds.getName());
        savingsType.ifPresent(cat -> {
            assertEquals(EnvelopeCat.SAVINGS, cat.name());
        });
    }

    @Test
    public void getRecurringFromName() {
        boolean fullFundsRecurring = commandsDB.getRecurringFromName(fullFunds.getName());
        assertEquals(false, fullFundsRecurring);

        boolean partialFundsRecurring = commandsDB.getRecurringFromName(partialFunds.getName());
        assertEquals(false, partialFundsRecurring);

        boolean fullCreditRecurring = commandsDB.getRecurringFromName(fullCredit.getName());
        assertEquals(true, fullCreditRecurring);
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