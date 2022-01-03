package Railway;

import Common.Utilities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class SetData extends TestBase{
    @DataProvider(name = "dp")
    public Object[][] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader(Utilities.getProjectPath() + "\\src\\main\\java\\DataObject\\Data.json");
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray array = (JSONArray) jsonObject.get("TC14");

        String arr[] = new String[array.size()];
        for (int i = 0; i < array.size(); i++){
            JSONObject tc14 = (JSONObject) array.get(i);
            String departDate = (String) tc14.get("DepartDate");
            String departFrom = (String) tc14.get("DepartFrom");
            String arriveAt = (String) tc14.get("ArriveAt");
            String seatType = (String) tc14.get("SeatType");
            String ticketAmount = (String) tc14.get("TicketAmount");

            System.out.println(departDate);
            System.out.println(departFrom);
            System.out.println(arriveAt);
            System.out.println(seatType);
            System.out.println(ticketAmount);

            arr[i] = departDate+","+departFrom+","+arriveAt+","+seatType+","+ticketAmount;
        }
        return new String[][]{arr};
    }

    @DataProvider(name = "dp2")
    public Object[][] readJson2() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader(Utilities.getProjectPath() + "\\src\\main\\java\\DataObject\\Data_TC17.json");
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray array = (JSONArray) jsonObject.get("TC17");

        String arr[] = new String[array.size()];
        for (int i = 0; i < array.size(); i++){
            JSONObject tc14 = (JSONObject) array.get(i);
            String departDate = (String) tc14.get("DepartDate");
            String departFrom = (String) tc14.get("DepartFrom");
            String arriveAt = (String) tc14.get("ArriveAt");
            String seatType = (String) tc14.get("SeatType");
            String ticketAmount = (String) tc14.get("TicketAmount");

            System.out.println(departDate);
            System.out.println(departFrom);
            System.out.println(arriveAt);
            System.out.println(seatType);
            System.out.println(ticketAmount);

            arr[i] = departDate+","+departFrom+","+arriveAt+","+seatType+","+ticketAmount;
        }
        return new String[][]{arr};
    }
}
