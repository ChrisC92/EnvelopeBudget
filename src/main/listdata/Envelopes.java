package main.listdata;

import javafx.collections.ObservableList;

public class Envelopes {

    private ObservableList<Envelope> envelopes;


    public Envelopes(ObservableList<Envelope> envelopes) {
        this.envelopes = envelopes;
    }

    public ObservableList<Envelope> getList() {
        return envelopes;
    }

    public Envelope getFromIndex(int index) {
        return envelopes.get(index);
    }

    public void add(Envelope envelope) {
        envelopes.add(envelope);
    }

    public String printFirst() {
        return envelopes.get(0).toString();
    }
}
