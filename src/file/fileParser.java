package file;

import pojo.hotelDealDetails;
import util.constantsFile;
import util.validationUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fileParser {

    private static final String COMMA_DELIMITER = ",";

    public List<hotelDealDetails> parseDealsFile(String path) throws IOException {
        List<hotelDealDetails> hotelList = new ArrayList<hotelDealDetails>();

        BufferedReader br = null;
        try
        {
            //Reading the csv file
            br = new BufferedReader(new FileReader(path));

            //Create List for holding hotelDealDetails objects
            String line;

            //Read to skip the header
            br.readLine();

            //Reading from the second line
            while ((line = br.readLine()) != null)
            {
                line = line.replaceAll("\"" , "");
                String[] hotelDetailsWithDeal = line.split(COMMA_DELIMITER);

                if(hotelDetailsWithDeal.length > 0 )
                {
                    hotelDealDetails hotelDealDetails = new hotelDealDetails(
                            hotelDetailsWithDeal[0],
                            Integer.parseInt(hotelDetailsWithDeal[1]),
                            hotelDetailsWithDeal[2],
                            Integer.parseInt(hotelDetailsWithDeal[3]),
                            convertDealTypeToConstantDealType(hotelDetailsWithDeal[4]),
                            validationUtil.convertStringToDate(hotelDetailsWithDeal[5]),
                            validationUtil.convertStringToDate(hotelDetailsWithDeal[6]));
                    hotelList.add(hotelDealDetails);
                }
            }
        } catch (FileNotFoundException e) {
            throw new IOException("File was not found at specified path");
        }finally
        {
            try{
                br.close();
            }
            catch(IOException ie) {
                System.out.println("Error occured while closing the BufferedReader");
                ie.printStackTrace();
            }
        }
        return hotelList;
    }


    private static int convertDealTypeToConstantDealType(String dealType) {
        switch(dealType) {
            case constantsFile.percentage_Type_Deal_Constant :
                return 1;

            case constantsFile.rebate_Type_Deal_Constant :
                return 2;

            case constantsFile.rebate3Plus_Type_Deal_Constant :
                return 3;

            default:
                return 0;
        }
    }
}
