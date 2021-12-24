package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC01 extends BeforeAfter{
    @Test
    public void TC01(){
        System.out.println("TC001 - User can login with valid account");
        homePage.open();

        loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Message");
    }
}
