package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC101 extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String BOOKED_SUCCESSFULLY = "Ticket Booked Successfully!";

    @Test(description = "User can book tickets at a time", dataProvider = "data-provider")
    public void FTTC101(String departFrom, String arriveAt, String seatType, String ticketAmount){
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("2. Login with a valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on 'Book ticket' tab");
        loginPage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("4. Select a 'Depart date' from the list");
        bookTicketPage.getDepartDate(Utilities.getTrainDate());

        System.out.println("5. Select 'Depart From' ");
        bookTicketPage.getDepartFrom(departFrom);

        System.out.println("6. Select 'Arrive At'");
        bookTicketPage.getArriveAt(arriveAt);

        System.out.println("7. Select type of seat");
        bookTicketPage.getSeatType(seatType);

        System.out.println("8. Select amount of ticket");
        bookTicketPage.getTicketAmount(ticketAmount);
        bookTicketPage.getBtnBook();

        String actualMsg = bookTicketPage.getMessageBook();
        String expectedMsg = BOOKED_SUCCESSFULLY;

        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        String filePath = Utilities.getProjectPath() + "\\src\\main\\java\\DataObject\\Data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataFTTC101 = jsonObject.getAsJsonObject("FTTC101");
        String departFrom = dataFTTC101.get("DepartFrom").getAsString();
        String arriveAt = dataFTTC101.get("ArriveAt").getAsString();
        String seatType = dataFTTC101.get("SeatType").getAsString();
        String ticketAmount = dataFTTC101.get("TicketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departFrom, arriveAt, seatType, ticketAmount}
        };
        return object;
    }
}
