import businesshelper.bestHotelDealProcessor;
import util.validationUtil;


import java.util.Date;


public class main {
        static bestHotelDealProcessor bestHotelDealProcessor = new bestHotelDealProcessor();

    public static void main(String[] args) throws Exception {

        String dealAvailable;

        //sample input
        String samplePath = "./src/sampleFile/sampleDealFile.csv";
        Date checkinDate = validationUtil.convertStringToDate("03/01/2016");
        int durationOfDays = 6;
        try {
            //businesshelper call to get best deal.
            dealAvailable = bestHotelDealProcessor.processBestDeal(samplePath, "Hotel Foobar" , checkinDate, durationOfDays);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        System.out.println("Best deal : "+ dealAvailable);
    }
}
