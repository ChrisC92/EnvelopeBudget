package main.java.listdata;

import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Alert;

public class Envelope {

    private final String name;
    private final SimpleDoubleProperty totalFunds;
    private SimpleDoubleProperty fundsRemaining;
    private EnvelopeCat type;
    private boolean recurring;
    private List<Envelope> pastStats;


    public Envelope() {
        name = "empty";
        totalFunds = new SimpleDoubleProperty(0);
        type = EnvelopeCat.EMPTY;
    }

    public Envelope(String name, EnvelopeCat type, double totalFunds, boolean recurring) {
        this.name = name;
        this.type = type;
        this.totalFunds = new SimpleDoubleProperty(totalFunds);
        this.fundsRemaining = new SimpleDoubleProperty(totalFunds);
        this.recurring = recurring;
    }

    public void deductFunds(double amountSpent) {
        double fundsRemainingInt = fundsRemaining.get();
        if ((fundsRemainingInt - amountSpent) >= 0) {
            fundsRemainingInt -= amountSpent;
            setRemainingFunds(fundsRemainingInt);
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setContentText("Not enough funds");
            error.showAndWait();
        }
    }

    public double getTotalFunds() {
        return totalFunds.get();
    }

    public SimpleDoubleProperty totalFundsProperty() {
        return totalFunds;
    }

    public  double getRemainingFunds() {
        return fundsRemaining.get();
    }

    public void setRemainingFunds(double value) {
        fundsRemaining.set(value);
    }

    public SimpleDoubleProperty remainingFundsProperty() {
        return fundsRemaining;
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

    public String getRecurringAsString() {
        if(recurring) {
            return "true";
        }
        return "false";
    }

    public enum EnvelopeCat {
        GROCERIES, GENERAL, EATINGOUT, TRANSPORT, SAVINGS, CREDITCARD, ENTERTAINMENT, EMPTY
    }
}