package main.java.listdata;

import com.sun.jdi.DoubleValue;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;

import java.util.List;

public class Envelope {

    private final String name;
    private final ObservableValue<Double> totalFunds;
    private ObservableValue<Double> fundsRemaining;
    private EnvelopeCat type;
    private boolean recurring;
    private List<Envelope> pastStats;


    public Envelope() {
        name = "empty";
        totalFunds = new SimpleDoubleProperty(0).asObject();
        type = EnvelopeCat.EMPTY;
    }

    public Envelope(String name, EnvelopeCat type, double totalFunds, boolean recurring) {
        this.name = name;
        this.type = type;
        this.totalFunds = new SimpleDoubleProperty(totalFunds).asObject();
        this.fundsRemaining = new SimpleDoubleProperty(totalFunds).asObject();
        this.recurring = recurring;
    }

    public void deductFunds(double amountSpent) {
        double fundsRemainingInt = fundsRemaining.getValue();
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

    public double getTotalFunds() {
        return totalFunds.getValue();
    }

    public double getRemainingFunds() {
        return fundsRemaining.getValue();
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

    public enum EnvelopeCat {
        GROCERIES, GENERAL, EATINGOUT, TRANSPORT, SAVINGS, CREDITCARD, ENTERTAINMENT, EMPTY
    }
}
