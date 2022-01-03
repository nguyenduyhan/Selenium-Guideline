package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase {
    @Test(description = "TC01 - User can login with valid account")
    public void TC01() {
        System.out.println("Step 1: Navigate to Home");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("Step 2: Login");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 3: Verify check point");
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
