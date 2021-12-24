package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends BeforeAfter{
    @Test
    public void TC06(){
        System.out.println("User is redirected to Home page after logging out");
        homePage.open();

        loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = loginPage.gotoHome().getHomeTitleLogout();
        String expectedMsg = "Welcome to Safe Railway";

        Assert.assertEquals(actualMsg, expectedMsg, "Message");
    }
}
