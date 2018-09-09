package main.listdata;

public class Envelope {

    private String name;
    private int totalFunds;
    private int fundsLeft;
    private EnvelopeCat type;
    private boolean recurring;


    public Envelope() {
        name = "empty";
        totalFunds = 0;
        type = EnvelopeCat.EMPTY;
    }

    public Envelope(String name, EnvelopeCat type, int totalFunds, boolean recurring) {
        this.name = name;
        this.type = type;
        this.totalFunds = totalFunds;
        this.fundsLeft = totalFunds;
        this.recurring = recurring;
    }



    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name + "             " + fundsLeft + " / " + totalFunds;
    }


    public boolean isempty() {
        return name.equals("empty") && totalFunds==0 && type.equals(EnvelopeCat.EMPTY);
    }

    public enum EnvelopeCat {
        GROCERIES, GENERAL, EATINGOUT, TRANSPORT, SAVINGS, CREDITCARD, ENTERTAINMENT, EMPTY
    }
}
