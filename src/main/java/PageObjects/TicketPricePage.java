package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage{
    public final By getTitle = By.xpath("//h1[contains(text(),'Ticket Price')]");
    public final By stHS = By.xpath("//td[contains(text(),'HS')]");
    public final By stSS = By.xpath("//td[contains(text(),'SS')]");
    public final By stSSC = By.xpath("//td[contains(text(),'SSC')]");
    public final By stHB = By.xpath("//td[contains(text(),'HB')]");
    public final By stSB = By.xpath("//td[contains(text(),'SB')]");
    public final By stSBC = By.xpath("//td[contains(text(),'SBC')]");

    public WebElement getSeatTypeHS(){
        return Constant.WEBDRIVER.findElement(stHS);
    }
    public WebElement getSeatTypeSS(){
        return Constant.WEBDRIVER.findElement(stSS);
    }
    public WebElement getSeatTypeSSC(){
        return Constant.WEBDRIVER.findElement(stSSC);
    }
    public WebElement getSeatTypeHB(){
        return Constant.WEBDRIVER.findElement(stHB);
    }
    public WebElement getSeatTypeSB(){
        return Constant.WEBDRIVER.findElement(stSB);
    }
    public WebElement getSeatTypeSBC(){
        return Constant.WEBDRIVER.findElement(stSBC);
    }
    public WebElement getTitlePrice(){
        return Constant.WEBDRIVER.findElement(getTitle);
    }
}
