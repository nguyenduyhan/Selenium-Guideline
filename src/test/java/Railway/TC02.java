package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC02 extends TestBase {
    @Test(description = "TC02 - User can not login with blank 'Username' textbox")
    public void TC02(){
        homePage.open();

        homePage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);
        String actualMsg = homePage.getErrorWelcomeMessage();
        String expectedMsg = "You must specify a username.";

        Assert.assertEquals(actualMsg, expectedMsg, "Message");
    }
}
