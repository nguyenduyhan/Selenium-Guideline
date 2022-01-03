package Railway;

import Common.Constant;
import Common.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    @Test(description = "User can create new account")
    public void TC07(){
        System.out.println("Step 1: Navigate to Register Page");
        homePage.open();
        homePage.gotoRegisterPage();

        System.out.println("Step 2: Enter valid information");
        registerPage.registerAccount(Utilities.generateRandomEmail() + "@example.com",
                Constant.NEWPS, Constant.NEWPSCF, Utilities.generateRandomPID(9));

        System.out.println("Step 3: Verify checkpoint");
        String actualMsg = homePage.getRegisterSuccessMessage();
        String expectedMsg = Constant.REGISTER_CONFIRM;

        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
