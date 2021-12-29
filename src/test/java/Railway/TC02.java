package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC02 extends TestBase {
    @Test(description = "TC02 - User can not login with blank 'Username' textbox")
    public void TC02() {
        System.out.println("Step 1: Navigate to Home");
        homePage.open();

        System.out.println("Step 2: Logging in");
        homePage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);

        System.out.println("Step 3: Verify checkpoint");
        String actualMsg = homePage.getErrorWelcomeMessage();
        String expectedMsg = "You must specify a username.";

        Assert.assertEquals(actualMsg, expectedMsg, "Fail");
    }
}
