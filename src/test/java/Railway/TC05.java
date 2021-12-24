package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends BeforeAfter{
    @Test
    public void TC05(){
        System.out.println("User login wrong password several time");
        homePage.open();
        for (int i = 0; i <= 3; i++){
            loginPage = homePage.gotoLoginPage();
            loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);

        }
        String actualMsg = loginPage.getErrorInvalidPassword();
        String expectedMsg = "You have used 4 out of 5 login attempts. " +
                "After all 5 have been used, you will be unable to login for 15 minutes";

        Assert.assertEquals(actualMsg, expectedMsg, "Message");
    }
}
