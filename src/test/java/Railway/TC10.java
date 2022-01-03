package Railway;

import Common.Constant;
import Common.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase {
    @Test(description = "User can not create account with an already in use email")
    public void TC10() {
        System.out.println("Step 1: Navigate to Register Page");
        homePage.open();
        homePage.gotoRegisterPage();

        System.out.println("Step 2: Input used email address");
        registerPage.registerAccount(Constant.NEWUSERNAME, Constant.NEWPS,
                Constant.NEWPSCF, Utilities.generateRandomPID(9));

        System.out.println("Step 3: Verify checkpoint");
        String actualMsg = homePage.getMessageEmailInUsed();
        String expectedMsg = Constant.ALREADY_USED_EMAIL;

        Assert.assertEquals(actualMsg, expectedMsg);

    }
}
