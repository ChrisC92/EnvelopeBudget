package main.java.utils.timeutils;

import java.time.LocalDate;

public class CheckDates {


    public static boolean isNewMonth(LocalDate payDate) {
        LocalDate today = LocalDate.now();
        return payDate.getMonth().equals(today.getMonth());
    }




}
