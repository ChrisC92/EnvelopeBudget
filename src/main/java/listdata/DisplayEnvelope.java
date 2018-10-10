package main.java.listdata;

import javafx.scene.control.ListCell;

public class DisplayEnvelope extends ListCell<Envelope> {

    public DisplayEnvelope() { }

    @Override
    protected void updateItem(Envelope envelope, boolean empty) {
        super.updateItem(envelope, empty);

        if(empty) {
            setText(null);
        } else {
            setText(envelope.toString());
        }
    }
}
