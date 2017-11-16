package businesshelperTest;

import businesshelper.bestHotelDealProcessor;
import org.junit.Assert;
import org.junit.Test;
import pojo.hotelDealDetails;
import util.validationUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class bestHotelDealProcessorTest {

    bestHotelDealProcessor hotelDealProcessor = new bestHotelDealProcessor();
    private static final double DELTA = 1e-15;


    @Test
    public void testProcessBestDeal_ForDatesForWhichNoDealsAreThere() throws Exception {
    String path = "./src/sampleFile/sampleDealFile.csv";
    String hotelName = "Hotel FooBar";
    Date startDate = validationUtil.convertStringToDate("03/01/2015");
    int durationOfStay = 1;

        String promoTextValue = hotelDealProcessor.processBestDeal(path, hotelName, startDate, durationOfStay);

        Assert.assertEquals("No deals available", promoTextValue);
    }



    @Test
    public void testProcess_Success() {
        List<hotelDealDetails> hoteDealDetailsList = new ArrayList<>();

        hotelDealDetails hotel1 = new hotelDealDetails("Hotel Foobar",250,"$50 off your stay 3 nights or more",Integer.parseInt("-50"),3,validationUtil.convertStringToDate("3/1/2016"),validationUtil.convertStringToDate("3/31/2016"));
        hotelDealDetails hotel2 = new hotelDealDetails("Hotel Foobar",250,"5% off your stay",Integer.parseInt("-5"),1,validationUtil.convertStringToDate("3/1/2016"),validationUtil.convertStringToDate("3/15/2016"));

        hoteDealDetailsList.add(hotel1);
        hoteDealDetailsList.add(hotel2);

        String result = hotelDealProcessor.processDeal(hoteDealDetailsList, "Hotel Foobar", validationUtil.convertStringToDate("03/01/2016") , 2);

        Assert.assertEquals("5% off your stay" , result);
    }



    @Test
    public void testDiscountedPriceValue() {
        int dealType = 1;
        int dealValue = -5;
        int totalCost = 250*3;
        int duration = 1;

        double totalDiscount = hotelDealProcessor.getTotalDiscount(totalCost, dealType, dealValue , duration);
        Assert.assertEquals(712.5, totalDiscount , DELTA);
    }


    @Test
    public void testProcessBestDeal_ForDatesWithIncorrectDealType_InExcel() throws Exception {
        String path = "./src/sampleFile/sampleDealFile.csv";
        String hotelName = "Hotel FooFun";
        Date startDate = validationUtil.convertStringToDate("03/01/2015");
        int durationOfStay = 1;

        String promoTextValue = hotelDealProcessor.processBestDeal(path, hotelName, startDate, durationOfStay);

        Assert.assertEquals("No deals available", promoTextValue);
    }

}
