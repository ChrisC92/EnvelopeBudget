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

    public void add(Envelope envelope) {
        envelopes.add(envelope);
    }

    public boolean notEmpty() {
        return !envelopes.isEmpty();
    }

    public String printFirst() {
        return envelopes.get(0).toString();
    }
}
