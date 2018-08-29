package main.listdata;

import javafx.scene.control.ListCell;

public class DisplayEnvelope extends ListCell<Envelope> {

    public DisplayEnvelope() { }

    @Override
    protected void updateItem(Envelope envelope, boolean empty) {
        super.updateItem(envelope, empty);

        if(envelope == null) {
            System.out.println("this is null");
            setText(null);
        } else {
            System.out.println(envelope.getName());
            setText(envelope.getName());
        }
    }
}
