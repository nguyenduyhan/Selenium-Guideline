package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;

public class LoginPage extends GeneralPage{
    private final By usernameField = By.xpath("//input[@id='username']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By buttonLogin = By.xpath("//input[@value='login']");
//    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    public WebElement getUsername(){
        return Constant.WEBDRIVER.findElement(usernameField);
    }
    public WebElement getPassword(){
        return Constant.WEBDRIVER.findElement(passwordField);
    }
    public WebElement getButtonLogin(){
        return Constant.WEBDRIVER.findElement(buttonLogin);
    }
//    public WebElement getLblLoginErrorMsg(){
//        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
//    }

    public HomePage login(String username, String password){
        this.getUsername().sendKeys(username);
        this.getPassword().sendKeys(password);
        this.getButtonLogin().click();
//        this.getLblLoginErrorMsg().getText();

        return new HomePage();
    }

}
