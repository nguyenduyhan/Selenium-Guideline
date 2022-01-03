package Railway;

import Common.Constant;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16 extends TestBase{
    @Test(description = "User can cancel a ticket")
    public void TC16() {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("2. Login with a valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on 'My Ticket' tab");
        homePage.gotoMyTicketPage();

        System.out.println("4. Click 'Cancel'");
        myTicketPage.clickCancelButton();

        System.out.println("6. Click on 'Ok' button on Confirmation message 'Are you sure?'");
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();

        Assert.assertTrue(myTicketPage.isElementPresent());
    }
}
