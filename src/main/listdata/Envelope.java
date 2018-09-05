package main.listdata;

public class Envelope {

    private String name;
    private int totalFunds;
    private int fundsLeft;

    public Envelope() {
    }

    public Envelope(String name) {
        this.name = name;
    }

    public Envelope(String name, int funds) {
        this.name = name;
        totalFunds = funds;
        fundsLeft = funds;
    }

    public Envelope(String name, int funds, int fundsLeft) {
        this.name = name;
        totalFunds = funds;
        fundsLeft = fundsLeft;
    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name + "             " + fundsLeft + " / " + totalFunds;
    }

}
