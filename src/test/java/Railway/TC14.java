package Railway;

import Common.Constant;
import PageObjects.BookTicketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase {
    @Test(description = "User can book many tickets at a time", dataProviderClass = SetData.class, dataProvider = "dp")
    public void TC14 (String data) throws InterruptedException {
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

        String actualMsg = bookTicketPage.getMessageBook();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
