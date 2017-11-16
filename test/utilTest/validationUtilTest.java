package utilTest;

import org.junit.Assert;
import org.junit.Test;
import util.validationUtil;

import java.text.ParseException;
import java.util.Date;

public class validationUtilTest {

    public validationUtil validationUtilObject = new validationUtil();
    @Test
    public void testCalculateCheckOutDate() throws ParseException {
        Date checkInDate = validationUtil.convertStringToDate("03/01/2016");
        int duration = 2;

        Date checkoutDate = validationUtilObject.calculateCheckOutDate(checkInDate, duration);

        Assert.assertEquals(validationUtil.convertStringToDate("03/03/2016" ), checkoutDate);
    }

    @Test
    public void testCalculateCheckOutDateWithMonthChange() throws ParseException {
        Date checkInDate = validationUtil.convertStringToDate("11/30/2017");
        int duration = 2;

        Date checkoutDate = validationUtilObject.calculateCheckOutDate(checkInDate, duration);

        Assert.assertEquals(validationUtil.convertStringToDate("12/02/2017" ), checkoutDate);
    }
}
