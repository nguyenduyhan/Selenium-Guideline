package Railway;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can not create account while password and PID fields are empty")
    public void TC11() {
        System.out.println("Step 1: Navigate to Register page");
        homePage.open();
        homePage.gotoRegisterPage();

        System.out.println("Step 2: Input information as document");
        registerPage.registerAccount(Utilities.generateRandomEmail(), "", "", "");

        System.out.println("Step 3: Verify checkpoint");
        String actualMsg1 = homePage.getAboveMsgError();
        String actualMsg2 = homePage.getSideErrorMsgPs();
        String actualMsg3 = homePage.getSideErrorMsgPid();

        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";
        String expectedMsg2 = "Invalid password length";
        String expectedMsg3 = "Invalid ID length";

        Assert.assertEquals(actualMsg1, expectedMsg1);
        Assert.assertEquals(actualMsg2, expectedMsg2);
        Assert.assertEquals(actualMsg3, expectedMsg3);

    }
}
