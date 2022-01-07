package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage{
    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();

    public final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    public final By lblBookSuccess = By.xpath("//h1[contains(text(),'Ticket Booked Successfully!')]");
    public final By lblMsgErrorTop = By.xpath("//p[contains(text(), \"There're errors in the form. Please correct the errors and try again.\")]");
    public final By lblMsgErrorSide = By.xpath("//label[contains(text(),'You have booked 10 tickets. You can book no more.')]");

    protected WebElement getMsgBookSuccess(){
        return Constant.WEBDRIVER.findElement(lblBookSuccess);
    }
    protected WebElement getMsgError(){
        return Constant.WEBDRIVER.findElement(lblMsgErrorTop);
    }
    protected WebElement getLblMsgError(){
        return Constant.WEBDRIVER.findElement(lblMsgErrorSide);
    }

    public void getDepartDate(String option){
        Select select = new Select(Constant.WEBDRIVER.findElement(By.name("Date")));
        select.selectByVisibleText(option);
    }
    public void getDepartFrom(String option){
        Select select = new Select(Constant.WEBDRIVER.findElement(By.name("DepartStation")));
        select.selectByVisibleText(option);
    }
    public void getArriveAt(String option){
        Select select = new Select(Constant.WEBDRIVER.findElement(By.name("ArriveStation")));
        select.selectByVisibleText(option);
    }
    public void getSeatType(String option){
        Select select = new Select(Constant.WEBDRIVER.findElement(By.name("SeatType")));
        select.selectByVisibleText(option);
    }
    public void getTicketAmount(String option){
        Select select = new Select(Constant.WEBDRIVER.findElement(By.name("TicketAmount")));
        select.selectByVisibleText(option);
    }
    public WebElement getBtnBk(){
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }
    public void getBtnBook(){
        this.getBtnBk().submit();
    }
    public String getMessageBook(){
        return this.getMsgBookSuccess().getText();
    }
    //tc17
    public String getErrorMessageTop(){
        return this.getMsgError().getText();
    }
    public String getErrorMessageSide(){
        return this.getLblMsgError().getText();
    }

    public void bookMultiple(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount, int times){
        for (int i = 0; i < times; i++){
            this.getDepartDate(departDate);
            this.getDepartFrom(departFrom);
            this.getArriveAt(arriveAt);
            this.getSeatType(seatType);
            this.getTicketAmount(ticketAmount);
            this.getBtnBook();
            homePage.gotoBookTicketPage();
        }
    }
}
