package Railway;

import Common.Constant;
import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can not create account with an already in use email")
    public void TC10() {
        System.out.println("Step 1: Navigate to Register Page");
        homePage.open();
        homePage.gotoRegisterPage();

        System.out.println("Step 2: Input used email address");
        registerPage.registerAccount(Constant.NEW_USERNAME, Constant.NEW_PASSWORD,
                Constant.NEW_PASS_CONFIRM, Utilities.generateRandomPID(9));

        System.out.println("Step 3: Verify checkpoint");
        String actualMsg = homePage.getMessageEmailInUsed();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg, expectedMsg);

    }
}
