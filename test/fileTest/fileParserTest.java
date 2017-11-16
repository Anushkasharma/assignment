package fileTest;

import file.fileParser;
import org.junit.Assert;
import org.junit.Test;
import pojo.hotelDealDetails;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by anushka on 11/16/17.
 */
public class fileParserTest {

    fileParser parser = new fileParser();

    @Test
    public void testFileParser() throws IOException, ParseException {
        String hotelName = "Hotel FooBar";
        List<hotelDealDetails> listOfHotels = parser.parseDealsFile("./src/sampleFile/sampleDealFile.csv" , hotelName);

        Assert.assertEquals(3, listOfHotels.size());
    }
}
