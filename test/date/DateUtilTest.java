package date;


import main.java.utils.timeutils.CheckDates;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilTest {

    @Test
    public void testIsNewMonth() {
        LocalDate today = LocalDate.now();
        LocalDate previousMonth = today.minusMonths(1);

        Assert.assertEquals(false, CheckDates.isNewMonth(today));
        Assert.assertEquals(true, CheckDates.isNewMonth(previousMonth));
    }
}
