package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {
    @Test(description = "Use is redirected to Book ticket page after logging in" )
    public void TC04(){
        System.out.println("Step 1: Navigate to Book ticket page");
        homePage.open();
        homePage.gotoBookTicketPage();

        System.out.println("Step 2: Login");
        loginPage.loginToBookTicket(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 3: Verify check point");
        String actualMsg = loginPage.getBookTicketTitleRedirect();
        String expectedMsg = Constant.TITLEBOOKTICKET;

        Assert.assertEquals(actualMsg, expectedMsg, "Message");
    }
}
