import businesshelper.bestHotelDealProcessor;
import util.validationUtil;


import java.util.Date;


public class Main {
        static bestHotelDealProcessor bestHotelDealProcessor = new bestHotelDealProcessor();

    public static void main(String[] args) throws Exception {

        String samplePath = "";
        Date checkinDate = validationUtil.convertStringToDate("03/01/2016");
        int durationOfDays = 1;
        try {
            bestHotelDealProcessor.processBestDeal(samplePath, "Hotel Foobar" , checkinDate, durationOfDays);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
