package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.TicketPricePage;
import PageObjects.TimeTablePage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC15 extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TimeTablePage timeTablePage = new TimeTablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();

    @Test(description = "'Ticket price' page displays with ticket details after clicking on 'check price' link in 'Train timetable' page",
    dataProvider = "data-provider"
    )
    public void TC15(String hardSeat, String softSeat, String softSeatAir, String hardBed, String softBed, String softBedAir){
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("2. Login with a valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on 'Timetable' tab");
        homePage.gotoTimeTablePage();

        System.out.println("4. Click on 'check price' link of the route from 'Sài Gòn' to 'Phan Thiết'");
        timeTablePage.clickLinkCheckPrice("Sài Gòn", "Phan Thiết");

        String actualMsg = ticketPricePage.getTitlePrice().getText();
        String expectedMsg = "Ticket Price";

        String[] actualMsg2 = {
                ticketPricePage.getSeatTypeHS().getText(),
                ticketPricePage.getSeatTypeSS().getText(),
                ticketPricePage.getSeatTypeSSC().getText(),
                ticketPricePage.getSeatTypeHB().getText(),
                ticketPricePage.getSeatTypeSB().getText(),
                ticketPricePage.getSeatTypeSBC().getText()
        };
        String[] expectedMsg2 = {"HS", "SS", "SSC", "HB", "SB", "SBC"};

        String[] actualMsg3 = {
                ticketPricePage.getHSPrice(hardSeat).getText(),
                ticketPricePage.getSSPrice(softSeat).getText(),
                ticketPricePage.getSSCPrice(softSeatAir).getText(),
                ticketPricePage.getHBPrice(hardBed).getText(),
                ticketPricePage.getSBPrice(softBed).getText(),
                ticketPricePage.getSBCPrice(softBedAir).getText()
        };
        String[] expectedMsg3 = {"90000", "115000", "140000", "190000", "240000", "290000"};

        Assert.assertEquals(actualMsg, expectedMsg);
        Assert.assertEquals(actualMsg2, expectedMsg2);
        Assert.assertEquals(actualMsg3, expectedMsg3);
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        String filePath = Utilities.getProjectPath() + "\\src\\main\\java\\DataObject\\Data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC15 = jsonObject.getAsJsonObject("TC15");
        String hardSeat = dataTC15.get("HSPrice").getAsString();
        String softSeat = dataTC15.get("SSPrice").getAsString();
        String softSeatAir = dataTC15.get("SSCPrice").getAsString();
        String hardBed = dataTC15.get("HBPrice").getAsString();
        String softBed = dataTC15.get("SBPrice").getAsString();
        String softBedAir = dataTC15.get("SBCPrice").getAsString();

        Object[][] object = new Object[][]{
                {hardSeat, softSeat, softSeatAir, hardBed, softBed, softBedAir}
        };
        return object;
    }
}
