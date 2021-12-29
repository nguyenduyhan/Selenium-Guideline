package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends TestBase {
    @Test(description = "User login wrong password several time")
    public void TC05(){
        System.out.println("Step 1: Navigate to Home");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("Step 2: Login");
        loginPage.loginMultipleTime(Constant.USERNAME, Constant.INVALID_PASSWORD, 3);

        System.out.println("Step 3: Verify check point");
        String actualMsg = loginPage.getErrorInvalidPassword();
        String expectedMsg = "You have used 4 out of 5 login attempts. " +
                "After all 5 have been used, you will be unable to login for 15 minutes";

        Assert.assertEquals(actualMsg, expectedMsg, "Fail");
    }
}
