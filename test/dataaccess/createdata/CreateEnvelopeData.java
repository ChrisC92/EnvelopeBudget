package dataaccess.createdata;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.envelopedata.Envelope;
import main.java.envelopedata.Envelopes;

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
        fundsSpentGeneral.deductFunds(800);
        envelopes.add(fundsSpentGeneral);

        Envelope fundsFullCredit = new Envelope("full funds CREDIT", Envelope.EnvelopeCat.CREDITCARD,
                2000, true);
        envelopes.add(fundsFullCredit);

        Envelope partialFundsCredit = new Envelope("partial funds CREDIT", Envelope.EnvelopeCat.CREDITCARD,
                1800, true);
        partialFundsCredit.deductFunds(1000);
        envelopes.add(partialFundsCredit);

        Envelope addToSavings1 = new Envelope("add first savings", Envelope.EnvelopeCat.SAVINGS,
                250, true);
        envelopes.add(addToSavings1);

        Envelope addToSavings2 = new Envelope("add second savings", Envelope.EnvelopeCat.SAVINGS,
                300, true);
        envelopes.add(addToSavings2);

        Envelope addToSavings3 = new Envelope("add third savings", Envelope.EnvelopeCat.SAVINGS,
                100, true);
        envelopes.add(addToSavings3);

        Envelope addToSavings4 = new Envelope("add fourth savings", Envelope.EnvelopeCat.SAVINGS,
                500, true);
        envelopes.add(addToSavings4);

        Envelope addToSavings5 = new Envelope("add fifth savings", Envelope.EnvelopeCat.SAVINGS,
                250, true);
        envelopes.add(addToSavings5);

        return new Envelopes(envelopes);
    }





}
