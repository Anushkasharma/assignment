package businesshelper;

import file.fileParser;
import pojo.hotelDealDetails;
import util.validationUtil;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

public class bestHotelDealProcessor {
    
    /*There is a very strong assumption made here that hotel name entered by user is a unique key (as far as location is concerned )and so are the names mentioned in csv.
    Example: There could be Hotel Marriot (on actual site there will be a location attached to this which gives it a unique identifier) but here it is assumed Hotel Marriot entered by user
    is the same as one mentioned in csv.
    */

    fileParser parser = new fileParser();
    validationUtil util = new validationUtil();

    public String processBestDeal(String path, String hotelName, Date checkInDate, int durationOfDays) throws IOException, DataFormatException {
        
        performValidation(path, hotelName, checkInDate, durationOfDays);
        
        // Step 1: parse this deal.csv file and get contents in a list
        List<hotelDealDetails> hotelDetailsList = new ArrayList<>();
        String promoTextValue = null;

        try {
            hotelDetailsList = parser.parseDealsFile(path , hotelName);
        } catch (ParseException e) {
            throw new IOException(e.getMessage());
        }

        //Step 2: upon parsing send this list to a main process function which performs business logic.
        promoTextValue = processDeal(hotelDetailsList, hotelName, checkInDate, durationOfDays);

        return promoTextValue;
    }

    private void performValidation(String path, String hotelName, Date checkInDate, int durationOfDays) throws DataFormatException {

        if(path.isEmpty()) {
            throw new DataFormatException("There should be dealsFile provided in order to get the best deal");
        }

        if(hotelName.isEmpty() || hotelName.equals("")) {
            throw new DataFormatException("Hotel Name cannot be empty");
        }

        if(checkInDate == null) {
            throw new DataFormatException("Date provided is incorrect");
        }

        if(durationOfDays == 0 || durationOfDays < 0) {
            throw new DataFormatException("Minimum duration is 1");
        }
    }

    public String processDeal(List<hotelDealDetails> hotelDetailsList, String hotelName, Date checkInDate, int durationOfDays) {
        //Initial Check considering hotelName entered by user is not a type and accurately matches names in the list.

        double maxDiscount = Integer.MAX_VALUE;
        String resultantPromoText = null;
        String userEnteredHotelName = hotelName.toLowerCase();
        Date checkoutDate = validationUtil.calculateCheckOutDate(checkInDate, durationOfDays); //helper method which gives me checkoutDate

        for(hotelDealDetails hotel : hotelDetailsList) {
            String hotelNameFromSheet = hotel.getHotelName().toLowerCase();
            //check if hotel name matches
            if(hotelNameFromSheet.equals(userEnteredHotelName)) {
                //check if duration entered by user matches discount of first entry of that hotel from list.
                if((hotel.getStartDate().before(checkInDate) || hotel.getStartDate().equals(checkInDate)) &&
                        (hotel.getEndDate().after(checkoutDate) || hotel.getEndDate().equals(checkoutDate))) {

                    //check discount provided by each matching hotel and return least.
                    double totalCost = hotel.getNightlyRate()*durationOfDays;
                    double discount = getTotalDiscount(totalCost, hotel.getDealType(), hotel.getDealValue(), durationOfDays);

                    if(discount < maxDiscount) {
                        maxDiscount = discount;
                        if(maxDiscount == totalCost || hotel.getDealType() == 0) {
                            resultantPromoText = "No deals available";
                        }else {
                            resultantPromoText = hotel.getPromoText();
                        }
                    }
                }
            }
        }
        if(maxDiscount == Integer.MAX_VALUE) {
            resultantPromoText = "No deals available";
        }
        return resultantPromoText;
    }

    public double getTotalDiscount(double totalCost, int dealType, int dealValue , int duration) {
        //Assumption 2
        //In assignment given values of deal is in negative(i have considered it same as examples in assignment and have added so it gets subtracted.)
        double finalDiscountedPrice = totalCost;
        if(dealType == 1) {
            double percentageValue = (dealValue)/100.00;
            double discountAmount = totalCost * (percentageValue);
            finalDiscountedPrice = totalCost + discountAmount;      //adding them due to the same reason (deal Value being negative)
        }

        if(dealType == 2) {
            finalDiscountedPrice = totalCost + dealValue;        //adding them due to the same reason (deal Value being negative)
        }

        if(dealType == 3 && duration >= 3) {
            finalDiscountedPrice = totalCost + dealValue;       //adding them due to the same reason (deal Value being negative)
        }

        if(dealType == 0) {
            finalDiscountedPrice = totalCost;
        }

        return finalDiscountedPrice;
    }
}
