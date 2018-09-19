package database.createdata;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.listdata.Envelope;
import main.listdata.Envelopes;

public class CreateEnvelopeData {


    public static Envelopes createEnvelopeListSizeThree() {
        ObservableList<Envelope> envelopes = FXCollections.observableArrayList();


        Envelope fullFunds = new Envelope("full funds", Envelope.EnvelopeCat.GENERAL,
                1000, false);
        envelopes.add(fullFunds);

        Envelope partialFunds = new Envelope("partial funds", Envelope.EnvelopeCat.GENERAL,
                1000, false);
        partialFunds.deductFunds(750);
        envelopes.add(partialFunds);

        Envelope fundsSpent = new Envelope("funds spent", Envelope.EnvelopeCat.CREDITCARD,
                1000, false);
        fundsSpent.deductFunds(1000);
        envelopes.add(fundsSpent);
        return new Envelopes(envelopes);
    }

}
