package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC02 extends BeforeAfter{
    @Test
    public void TC02(){
        System.out.println("TC002 - User can not login with blank 'Username' textbox");
        homePage.open();

        loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login("", Constant.PASSWORD).getErrorWelcomeMessage();
        String expectedMsg = "You must specify a username.";

        Assert.assertEquals(actualMsg, expectedMsg, "Message");
    }
}
