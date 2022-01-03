package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 extends TestBase{
    @Test(description = "'Ticket price' page displays with ticket details after clicking on 'check price' link in 'Train timetable' page")
    public void TC15(){
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("2. Login with a valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on 'Timetable' tab");
        homePage.gotoTimeTablePage();

        System.out.println("4. Click on 'check price' link of the route from 'Sài Gòn' to 'Phan Thiết'");
        timeTablePage.clickLinkCheckPrice();

        String actualMsg = ticketPricePage.getTitlePrice().getText();
        String expectedMsg = "Ticket Price";

        String[] actualMsg2 = {ticketPricePage.getSeatTypeHS().getText(),ticketPricePage.getSeatTypeSS().getText(),
        ticketPricePage.getSeatTypeSSC().getText(), ticketPricePage.getSeatTypeHB().getText(),
                ticketPricePage.getSeatTypeSB().getText(), ticketPricePage.getSeatTypeSBC().getText()
        };
        String[] expectedMsg2 = {"HS", "SS", "SSC", "HB", "SB", "SBC"};

        Assert.assertEquals(actualMsg, expectedMsg);
        Assert.assertEquals(actualMsg2, expectedMsg2);
    }
}
