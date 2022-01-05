package Railway;

import Common.Constant;
import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can create new account")
    public void TC07(){
        System.out.println("Step 1: Navigate to Register Page");
        homePage.open();
        homePage.gotoRegisterPage();

        System.out.println("Step 2: Enter valid information");
        registerPage.registerAccount(Utilities.generateRandomEmail(),
                Constant.NEW_PASSWORD, Constant.NEW_PASS_CONFIRM, Utilities.generateRandomPID(9));

        System.out.println("Step 3: Verify checkpoint");
        String actualMsg = homePage.getRegisterSuccessMessage();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";

        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
