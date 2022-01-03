package Railway;

import Common.Constant;
import PageObjects.BookTicketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC17 extends TestBase{
    @Test(description = "User can't book more than 10 tickets", dataProviderClass = SetData.class, dataProvider = "dp2")
    public void TC17 (String data) throws InterruptedException {
        String[] dataInfo = data.split(",");
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("2. Login with a valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on 'Book ticket' tab");
        loginPage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("4. Select a \"Depart date\" from the list");
        bookTicketPage.getDepartDate(dataInfo[0]);

        System.out.println("5. Select 'Depart From' ");
        bookTicketPage.getDepartFrom(dataInfo[1]);
        Thread.sleep(1000);

        System.out.println("6. Select 'Arrive At'");
        bookTicketPage.getArriveAt(dataInfo[2]);

        System.out.println("7. Select type of seat");
        bookTicketPage.getSeatType(dataInfo[3]);

        System.out.println("8. Select amount of ticket");
        bookTicketPage.getTicketAmount(dataInfo[4]);
        bookTicketPage.getBtnBook();

        String actualMsg1 = bookTicketPage.getErrorMessageTop();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";

        String actualMsg2 = bookTicketPage.getErrorMessageSide();
        String expectedMsg2 = "You have booked 10 tickets. You can book no more.";

        Assert.assertEquals(actualMsg1, expectedMsg1);
        Assert.assertEquals(actualMsg2, expectedMsg2);
    }
}
