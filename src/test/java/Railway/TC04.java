package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends BeforeAfter{
    @Test
    public void TC04(){
        System.out.println("Use is redirected to Book ticket page after logging in");

        String actualMsg = homePage.open().gotoBookTicketPage().gotoLoginPage()
                .loginBookTicket(Constant.USERNAME, Constant.PASSWORD)
                .returnLogin().getBookTicketTitleRedirect();
        String expectedMsg = "Book ticket";

        Assert.assertEquals(actualMsg, expectedMsg, "Message");
    }
}
