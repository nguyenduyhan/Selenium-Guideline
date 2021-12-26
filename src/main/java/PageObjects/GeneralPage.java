package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Constant;

public class GeneralPage {
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By welcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By usernameLeftBlank = By.xpath("//label[contains(text(),'You must specify a username.')]");
    private final By invalidPasswordError = By.xpath("//p[contains(text(),'Invalid username or password. Please try again.')]");
    private final By backToHome = By.xpath("//h1[contains(text(),'Welcome to Safe Railway')]");
    private final By bookTicketTitle = By.xpath("//div//h1[contains(text(), 'Book ticket')]");

    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getTabBookTicket(){
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }
    protected WebElement getLblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(welcomeMessage);
    }
    protected WebElement getUsernameBlank(){
        return Constant.WEBDRIVER.findElement(usernameLeftBlank);
    }
    protected WebElement getInvalidPassword(){
        return Constant.WEBDRIVER.findElement(invalidPasswordError);
    }
    protected WebElement getHomeTitle(){return Constant.WEBDRIVER.findElement(backToHome);};
    protected WebElement getBookTitle(){return Constant.WEBDRIVER.findElement(bookTicketTitle);}


    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }
    public String getErrorWelcomeMessage(){
        return this.getUsernameBlank().getText();
    }
    public String getErrorInvalidPassword(){
        return this.getInvalidPassword().getText();
    }
    public String getHomeTitleLogout(){return this.getHomeTitle().getText();};
    public String getBookTicketTitleRedirect(){return this.getBookTitle().getText();}

    public void gotoLoginPage(){
        this.getTabLogin().click();
    }

    public void gotoHome(){
        this.getTabLogout().click();
    }

    public void gotoBookTicketPage(){
        this.getTabBookTicket().click();
    }
}
