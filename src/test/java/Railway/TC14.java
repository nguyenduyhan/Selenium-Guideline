package Railway;

import Common.Constant;
import PageObjects.BookTicketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase{
    //demo
    @Test(description = "User can book many tickets at a time")
    public void TC14(){
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login("hanplayboi99@gmail.com", "16021999");
        loginPage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.getDepartDate();
        bookTicketPage.getDepartFrom();
        bookTicketPage.getArriveAt();
        bookTicketPage.getSeatType();
        bookTicketPage.getTicketAmount();
        bookTicketPage.getBtnBook();
        String actualMsg = bookTicketPage.getMessageBook();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "Fail");
    }
}
