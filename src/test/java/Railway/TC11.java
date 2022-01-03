package Railway;

import Common.Constant;
import Common.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {
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

        String expectedMsg1 = Constant.ERROR_MESSAGE;
        String expectedMsg2 = Constant.ERROR_PASSWORD_MSG;
        String expectedMsg3 = Constant.ERROR_PID_MESSAGE;

        Assert.assertEquals(actualMsg1, expectedMsg1);
        Assert.assertEquals(actualMsg2, expectedMsg2);
        Assert.assertEquals(actualMsg3, expectedMsg3);

    }
}
