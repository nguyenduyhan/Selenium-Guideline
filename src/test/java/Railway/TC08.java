package Railway;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08(){
        System.out.println("Step 1: Navigate to Login page");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("Step 2: Logging in");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 3: Verify checkpoint");
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
