package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Constant;

public class LoginPage extends GeneralPage {
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By btnLogin = By.xpath("//input[@value='Login']");

    public WebElement getUsername() {
        return Constant.WEBDRIVER.findElement(usernameField);
    }

    public WebElement getPassword() {
        return Constant.WEBDRIVER.findElement(passwordField);
    }

    public WebElement getButtonLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public void login(String username, String password) {
        this.getUsername().sendKeys(username);
        this.getPassword().sendKeys(password);
        this.getButtonLogin().click();
    }

    public void loginMultipleTime(String username, String password, int loginTime) {
        for (int i = 0; i <= loginTime; i++) {
            this.getUsername().sendKeys(username);
            this.getPassword().sendKeys(password);
            this.getButtonLogin().click();
        }
    }

    public void loginToBookTicket(String username, String password) {
        this.getUsername().sendKeys(username);
        this.getPassword().sendKeys(password);
        this.getButtonLogin().click();

    }
}
