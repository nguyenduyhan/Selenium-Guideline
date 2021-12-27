package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    @Test(description = "User cannot log into Railway with invalid password")
    public void TC03() {
        System.out.println("Step 1: Navigate to Home");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("Step 2: Login");
        loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);

        System.out.println("Step 3: Verify check point");
        String actualMsg = homePage.getErrorInvalidPassword();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Message");
    }
}
