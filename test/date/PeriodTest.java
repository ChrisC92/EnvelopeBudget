package date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest {


    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1992, Month.NOVEMBER, 8);

        Period period = Period.between(birthday, today);

        long chrono = ChronoUnit.DAYS.between(birthday, today);

        System.out.println("You are: " + period.getYears() + " years, " +
                period.getMonths() + " months, " + period.getDays() + " days old." +
                "(" + chrono + "days old)");
    }
}
