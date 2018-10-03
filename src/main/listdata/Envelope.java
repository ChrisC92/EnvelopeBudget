package main.listdata;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;

import java.util.List;

public class Envelope {

    private final String name;
    private final ObservableValue<Integer> totalFunds;
    private ObservableValue<Integer> fundsRemaining;
    private EnvelopeCat type;
    private boolean recurring;
    private List<Envelope> pastStats;


    public Envelope() {
        name = "empty";
        totalFunds = new SimpleIntegerProperty(0).asObject();
        type = EnvelopeCat.EMPTY;
    }

    public Envelope(String name, EnvelopeCat type, int totalFunds, boolean recurring) {
        this.name = name;
        this.type = type;
        this.totalFunds = new SimpleIntegerProperty(totalFunds).asObject();
        this.fundsRemaining = new SimpleIntegerProperty(totalFunds).asObject();
        this.recurring = recurring;
    }

    public void deductFunds(int amountSpent) {
        int fundsRemainingInt = fundsRemaining.getValue();
        if ((fundsRemainingInt - amountSpent) >= 0) {
            fundsRemainingInt -= amountSpent;
            fundsRemaining = new SimpleObjectProperty<>(fundsRemainingInt);

        } else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setContentText("Not enough funds");
            error.showAndWait();
        }
    }

    public int getTotalFunds() {
        return totalFunds.getValue();
    }

    public EnvelopeCat getType() {
        return type;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "             " + fundsRemaining + " / " + totalFunds;
    }


    public boolean isempty() {
        return name.equals("empty") && totalFunds.getValue() == 0 && type.equals(EnvelopeCat.EMPTY);
    }

    public int getRemainingFunds() {
        return fundsRemaining.getValue();
    }

    public enum EnvelopeCat {
        GROCERIES, GENERAL, EATINGOUT, TRANSPORT, SAVINGS, CREDITCARD, ENTERTAINMENT, EMPTY
    }
}
