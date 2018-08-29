package main.listdata;

import javafx.collections.ObservableList;

public class Envelopes {

    private ObservableList<Envelope> envelopes;


    public Envelopes(ObservableList<Envelope> envelopes) {
        this.envelopes = envelopes;
    }

    public ObservableList<Envelope> get() {
        return envelopes;
    }
}
