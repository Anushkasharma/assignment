package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class validationUtil {

    /**
     * Method converts the string date into Util.Date format
     *
     * @param dateString
     * @return
     */
    public static Date convertStringToDate(String dateString) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        Date dateValue = null;

        try {
            dateValue = new Date(sdf.parse(dateString).getTime());

            // TO Capture if the year from sheet are only two digits
            Date dateConstant = new Date(sdf.parse("01/01/1900").getTime());
            if(!dateValue.after(dateConstant)){
                return null;
            }

        } catch (ParseException e) {
            throw new ParseException("Date cannot be parsed.", 1);
        }
        return dateValue;
    }

    /**
     * Add duration to checkInDate.
     *
     * @param updateDate
     * @param noOfDays
     * @return Date
     */
    public static Date calculateCheckOutDate(java.util.Date updateDate, int noOfDays) {

        Calendar cal  = Calendar.getInstance();
        cal.setTime(updateDate);
        cal.add(Calendar.DATE, noOfDays);
        java.util.Date date = cal.getTime();
        return new java.sql.Date(date.getTime());
    }
}
