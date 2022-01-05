package Railway;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User is redirected to Home page after logging out")
    public void TC06(){
        System.out.println("Step 1: Navigate to Home");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("Step 2: Login");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 3: Verify check point");
        homePage.gotoHome();
        String actualMsg = homePage.getHomeTitleLogout();
        String expectedMsg = "Welcome to Safe Railway";

        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
