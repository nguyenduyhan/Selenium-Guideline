package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;

public class GeneralPage {
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By welcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By usernameLeftBlank = By.xpath("//label[contains(text(),'You must specify a username.')]");
    private final By invalidPasswordError = By.xpath("//p[contains(text(),'Invalid username or password. Please try again.')]");

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


    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }
    public String getErrorWelcomeMessage(){
        return this.getUsernameBlank().getText();
    }
    public String getErrorInvalidPassword(){
        return this.getInvalidPassword().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public LoginPage returnLogin(){
        this.getTabBookTicket().click();
        return new LoginPage();
    }

    public HomePage gotoHome(){
        this.getTabLogout().click();
        return new HomePage();
    }

    public BookTicketPage gotoBookTicketPage(){
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }








}
