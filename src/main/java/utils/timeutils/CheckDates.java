package main.java.utils.timeutils;

import java.time.LocalDate;

public class CheckDates {

    public static boolean isNewMonth(LocalDate date) {
        LocalDate todayDate = LocalDate.now();
        return !date.getMonth().equals(todayDate.getMonth());
    }

    public static boolean isSameMonth(LocalDate date) {
        LocalDate todayDate = LocalDate.now();
        return date.getMonth().equals(todayDate.getMonth());
    }




}
