package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyTicketPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC103 extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    String FILTER_ERROR = "Sorry, can't find any results that match your filters.\n" +
            "Please change the filters and try again.";

    @Test(dataProvider = "data-provider")
    public void FTTC103(String departFrom, String arriveAt, String seatType, String ticketAmount, String statusFilter){
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("2. Login with a valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on 'Book ticket' tab");
        loginPage.gotoBookTicketPage();

        System.out.println("4. Book more than 6 tickets");
        bookTicketPage.bookMultiple(Utilities.getTrainDate(), departFrom, arriveAt, seatType, ticketAmount, 5);

        System.out.println("4. Click on 'My Ticket' tab");
        homePage.gotoMyTicketPage();

        System.out.println("5. Select 'Paid' for 'Status'");
        myTicketPage.getSatus(statusFilter);

        System.out.println("6. Click 'Apply filter' button");
        myTicketPage.clickBtnFilter();

        String actualMsg = myTicketPage.filterMessageError();
        String expectedMsg = FILTER_ERROR;

        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        String filePath = Utilities.getProjectPath() + "\\src\\main\\java\\DataObject\\Data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataFTTC103 = jsonObject.getAsJsonObject("FTTC103");
        String departFrom = dataFTTC103.get("DepartFrom").getAsString();
        String arriveAt = dataFTTC103.get("ArriveAt").getAsString();
        String seatType = dataFTTC103.get("SeatType").getAsString();
        String ticketAmount = dataFTTC103.get("TicketAmount").getAsString();
        String statusFilter = dataFTTC103.get("StatusFilter").getAsString();

        Object[][] object = new Object[][]{
                {departFrom, arriveAt, seatType, ticketAmount, statusFilter}
        };
        return object;
    }
}
