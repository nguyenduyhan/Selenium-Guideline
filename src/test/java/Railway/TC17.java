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

public class TC17 extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can't book more than 10 tickets", dataProvider = "data-provider")
    public void TC17 (String departFrom, String arriveAt, String seatType, String ticketAmount) throws InterruptedException {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("2. Login with a valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on 'Book ticket' tab");
        loginPage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("4. Select a \"Depart date\" from the list");
        bookTicketPage.getDepartDate(Utilities.getTrainDate());

        System.out.println("5. Select 'Depart From' ");
        bookTicketPage.getDepartFrom(departFrom);
        Thread.sleep(1000);

        System.out.println("6. Select 'Arrive At'");
        bookTicketPage.getArriveAt(arriveAt);

        System.out.println("7. Select type of seat");
        bookTicketPage.getSeatType(seatType);

        System.out.println("8. Select amount of ticket");
        bookTicketPage.getTicketAmount(ticketAmount);
        bookTicketPage.getBtnBook();

        String actualMsg1 = bookTicketPage.getErrorMessageTop();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";

        String actualMsg2 = bookTicketPage.getErrorMessageSide();
        String expectedMsg2 = "You have booked 10 tickets. You can book no more.";

        Assert.assertEquals(actualMsg1, expectedMsg1);
        Assert.assertEquals(actualMsg2, expectedMsg2);
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        String filePath = Utilities.getProjectPath() + "\\src\\main\\java\\DataObject\\Data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject("TC17");
        String departFrom = dataTC17.get("DepartFrom").getAsString();
        String arriveAt = dataTC17.get("ArriveAt").getAsString();
        String seatType = dataTC17.get("SeatType").getAsString();
        String ticketAmount = dataTC17.get("TicketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departFrom, arriveAt, seatType, ticketAmount}
        };
        return object;
    }
}
