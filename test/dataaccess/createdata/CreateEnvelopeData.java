package dataaccess.createdata;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.listdata.Envelope;
import main.java.listdata.Envelopes;

public class CreateEnvelopeData {


    public Envelopes createEnvelopeData() {
        ObservableList<Envelope> envelopes = FXCollections.observableArrayList();


        Envelope fullFundsGeneral = new Envelope("full funds GENERAL", Envelope.EnvelopeCat.GENERAL,
                1000, false);
        envelopes.add(fullFundsGeneral);

        Envelope partialFundsGeneral = new Envelope("partial funds GENERAL", Envelope.EnvelopeCat.GENERAL,
                750, false);
        partialFundsGeneral.deductFunds(250);
        envelopes.add(partialFundsGeneral);

        Envelope fundsSpentGeneral = new Envelope("funds spent CREDIT", Envelope.EnvelopeCat.GENERAL,
                800, true);
        fundsSpentGeneral.deductFunds(1000);
        envelopes.add(fundsSpentGeneral);

        Envelope fundsFullCredit = new Envelope("full funds CREDIT", Envelope.EnvelopeCat.CREDITCARD,
                2000, true);
        envelopes.add(fundsFullCredit);

        Envelope partialFundsCredit = new Envelope("partial funds CREDIT", Envelope.EnvelopeCat.CREDITCARD,
                1800, true);
        partialFundsCredit.deductFunds(1000);
        envelopes.add(partialFundsCredit);

        Envelope addToSavings1 = new Envelope("partial funds SAVINGS", Envelope.EnvelopeCat.SAVINGS,
                250, true);
        envelopes.add(addToSavings1);

        Envelope addToSavings2 = new Envelope("partial funds SAVINGS", Envelope.EnvelopeCat.SAVINGS,
                300, true);
        envelopes.add(addToSavings1);

        Envelope addToSavings3 = new Envelope("partial funds SAVINGS", Envelope.EnvelopeCat.SAVINGS,
                100, true);
        envelopes.add(addToSavings1);

        Envelope addToSavings4 = new Envelope("partial funds SAVINGS", Envelope.EnvelopeCat.SAVINGS,
                500, true);
        envelopes.add(addToSavings1);

        Envelope addToSavings5 = new Envelope("partial funds SAVINGS", Envelope.EnvelopeCat.SAVINGS,
                250, true);
        envelopes.add(addToSavings1);

        return new Envelopes(envelopes);
    }





}
