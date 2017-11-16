import businesshelper.bestHotelDealProcessor;
import util.validationUtil;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.DataFormatException;


public class main {
        static bestHotelDealProcessor bestHotelDealProcessor = new bestHotelDealProcessor();

    public static void main(String[] args) throws Exception {
        String bestDealAvailable;

        //Get input from user
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter path:");
        String path = reader.next();
        reader.nextLine();

        System.out.println("Enter hotel Name:");
        String hotelName = reader.nextLine();
        reader.nextLine();

        System.out.println("Enter check in Date in the format : MM/DD/YYYY:");
        String checkInDateString = reader.next();
        reader.nextLine();

        System.out.println("Enter duration of your stay:");
        int duration = reader.nextInt();
        reader.nextLine();

        //sample path
       // String samplePath = "./src/sampleFile/sampleDealFile.csv";

        Date checkInDate;
        try {
            checkInDate = validationUtil.convertStringToDate(checkInDateString);
        }catch (ParseException e) {
            System.out.println("Date entered is not correct");
            throw new Exception(e.getMessage());
        }

        //validations on these inputs are taken care at business layer.
        try {
            //businesshelper call to get best deal.
            bestDealAvailable = bestHotelDealProcessor.processBestDeal(path, hotelName, checkInDate, duration);
        } catch (DataFormatException e) {
            throw new Exception(e.getMessage());
        }catch (IOException e) {
            throw new Exception(e.getMessage());
        }

        System.out.println("Best deal : "+ bestDealAvailable);
        reader.close();
    }
}
