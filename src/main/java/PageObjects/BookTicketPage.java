package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    public final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    public final By lblBookSuccess = By.xpath("//h1[contains(text(),'Ticket Booked Successfully!')]");
    public String getTitleBookTicket(){
        return Constant.WEBDRIVER.getTitle();
    }
    protected WebElement getTextt(){
        return Constant.WEBDRIVER.findElement(lblBookSuccess);
    }

    public void getDepartDate(){
        Select select = new Select(Constant.WEBDRIVER.findElement(By.name("Date")));
        select.selectByValue("4");
    }
    public void getDepartFrom(){
        Select select = new Select(Constant.WEBDRIVER.findElement(By.name("DepartStation")));
        select.selectByVisibleText("Nha Trang");
    }
    public void getArriveAt(){
        Select select = new Select(Constant.WEBDRIVER.findElement(By.name("ArriveStation")));
        select.selectByIndex(0);
    }
    public void getSeatType(){
        Select select = new Select(Constant.WEBDRIVER.findElement(By.name("SeatType")));
        select.selectByVisibleText("Soft seat with air conditioner");
    }
    public void getTicketAmount(){
        Select select = new Select(Constant.WEBDRIVER.findElement(By.name("TicketAmount")));
        select.selectByValue("1");
    }
    public WebElement getBtnBk(){
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }
    public void getBtnBook(){
        this.getBtnBk().submit();
    }
    public String getMessageBook(){
        return this.getTextt().getText();
    }
}
