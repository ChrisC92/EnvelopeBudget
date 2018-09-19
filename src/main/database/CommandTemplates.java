package main.database;

import main.listdata.Envelope;

public class CommandTemplates {

    public static String createInsertEnvelopeTable(Envelope envelope) {
        StringBuilder insertStatement = new StringBuilder();
        String sqlStart = "INSERT INTO envelopes (name, type, totalFunds, " +
                "fundsLeft, recurring) VALUES (";

        insertStatement.append(sqlStart);
        insertStatement.append("'");
        insertStatement.append(envelope.getName());
        insertStatement.append("'");
        insertStatement.append(", ");
        insertStatement.append("'");
        insertStatement.append(envelope.getType());
        insertStatement.append("'");
        insertStatement.append(", ");
        insertStatement.append(envelope.getTotalFunds());
        insertStatement.append(", ");
        insertStatement.append(envelope.getSpentFunds());
        insertStatement.append(", ");
        insertStatement.append(envelope.getrecurring());
        insertStatement.append(");");

        return insertStatement.toString();
    }
}
