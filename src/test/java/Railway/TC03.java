package Railway;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends BeforeAfter{
    @Test
    public void TC03(){
        System.out.println("User cannot log into Railway with invalid password");
        homePage.open();

        loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD).getErrorInvalidPassword();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Message");
    }
}
