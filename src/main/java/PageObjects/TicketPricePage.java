package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage{
    public final By getTitle = By.xpath("//h1[contains(text(),'Ticket Price')]");
    public final By tblStHS = By.xpath("//td[contains(text(),'HS')]");
    public final By tblStSS = By.xpath("//td[contains(text(),'SS')]");
    public final By tblStSSC = By.xpath("//td[contains(text(),'SSC')]");
    public final By tblStHB = By.xpath("//td[contains(text(),'HB')]");
    public final By tblStSB = By.xpath("//td[contains(text(),'SB')]");
    public final By tblStSBC = By.xpath("//td[contains(text(),'SBC')]");

    String tblPriceHS = "//td[contains(text(),'%s')]";
    String tblPriceSS = "//td[contains(text(),'%s')]";
    String tblPriceSSC = "//td[contains(text(),'%s')]";
    String tblPriceHB = "//td[contains(text(),'%s')]";
    String tblPriceSB = "//td[contains(text(),'%s')]";
    String tblPriceSBC = "//td[contains(text(),'%s')]";

    public WebElement getSeatTypeHS(){
        return Constant.WEBDRIVER.findElement(tblStHS);
    }
    public WebElement getSeatTypeSS(){
        return Constant.WEBDRIVER.findElement(tblStSS);
    }
    public WebElement getSeatTypeSSC(){
        return Constant.WEBDRIVER.findElement(tblStSSC);
    }
    public WebElement getSeatTypeHB(){
        return Constant.WEBDRIVER.findElement(tblStHB);
    }
    public WebElement getSeatTypeSB(){
        return Constant.WEBDRIVER.findElement(tblStSB);
    }
    public WebElement getSeatTypeSBC(){
        return Constant.WEBDRIVER.findElement(tblStSBC);
    }
    public WebElement getTitlePrice(){
        return Constant.WEBDRIVER.findElement(getTitle);
    }

    public WebElement getHSPrice(String price){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(tblPriceHS, price)));
    }
    public WebElement getSSPrice(String price){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(tblPriceSS, price)));
    }
    public WebElement getSSCPrice(String price){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(tblPriceSSC, price)));
    }
    public WebElement getHBPrice(String price){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(tblPriceHB, price)));
    }
    public WebElement getSBPrice(String price){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(tblPriceSB, price)));
    }
    public WebElement getSBCPrice(String price){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(tblPriceSBC, price)));
    }
}
