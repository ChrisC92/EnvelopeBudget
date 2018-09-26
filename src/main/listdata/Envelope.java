package main.listdata;

import javafx.scene.control.Alert;

import java.util.List;

public class Envelope {

    private String name;
    private int totalFunds;
    private int fundsRemaining;
    private EnvelopeCat type;
    private boolean recurring;
    private List<Envelope> pastStats;


    public Envelope() {
        name = "empty";
        totalFunds = 0;
        type = EnvelopeCat.EMPTY;
    }

    public Envelope(String name, EnvelopeCat type, int totalFunds, boolean recurring) {
        this.name = name;
        this.type = type;
        this.totalFunds = totalFunds;
        this.fundsRemaining = totalFunds;
        this.recurring = recurring;
    }

    public void deductFunds(int amountSpent) {

        if ((fundsRemaining - amountSpent) >= 0) {
            fundsRemaining -= amountSpent;
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setContentText("Not enough funds");
            error.showAndWait();
        }
    }

    public int getTotalFunds() {
        return totalFunds;
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
        return name.equals("empty") && totalFunds == 0 && type.equals(EnvelopeCat.EMPTY);
    }

    public int getRemainingFunds() {
        return fundsRemaining;
    }

    public enum EnvelopeCat {
        GROCERIES, GENERAL, EATINGOUT, TRANSPORT, SAVINGS, CREDITCARD, ENTERTAINMENT, EMPTY
    }
}
