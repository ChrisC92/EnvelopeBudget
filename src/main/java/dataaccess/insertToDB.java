package main.java.dataaccess;

import main.java.envelopedata.Envelope;
import main.java.envelopedata.Envelopes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Optional;

public class insertToDB {

    private DatabaseCommands dbCommands;

    public insertToDB(DatabaseCommands dbCommands) {
        this.dbCommands = dbCommands;
    }

    public void saveCurrentToDB(Envelopes envelopes) {

        for(Envelope envelope : envelopes.getList()) {
            dbCommands.insertCurrentEnvelopeToDB(envelope);
        }
    }

    public void saveRecurringToDB(Envelopes envelopes, Date date) {
        for(Envelope envelope : envelopes.getList()) {

            Optional<Integer> optionalID = dbCommands.getEnvelopeID(envelope);

            optionalID.ifPresent(envelopeID -> {
                dbCommands.saveRecurringForMonth(envelope, envelopeID, date);
            });
        }
    }


    private void setAutoCommitFalse(Connection conn) {
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("unable to set auto commit to false");
            System.out.println(e.getMessage());
        }
    }

    private void connectionCommitAndClose(Connection conn) {
        try {
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            System.out.println("connection cannot commit and close: ");
            System.out.println(e.getMessage());
        }

    }

}
