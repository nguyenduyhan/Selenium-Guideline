package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    private final By usernameField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("confirmPassword");
    private final By pidField = By.id("pid");
    private final By registerButton = By.xpath("//input[@value='Register']");

    public WebElement getNewUsername() {
        return Constant.WEBDRIVER.findElement(usernameField);
    }

    public WebElement getNewPassword() {
        return Constant.WEBDRIVER.findElement(passwordField);
    }

    public WebElement getPasswordConfirm() {
        return Constant.WEBDRIVER.findElement(confirmPasswordField);
    }

    public WebElement getPidNumber() {
        return Constant.WEBDRIVER.findElement(pidField);
    }

    public WebElement getRegisterBtn() {
        return Constant.WEBDRIVER.findElement(registerButton);
    }

    public void registerAccount(String username, String password, String confirmPassword, String pid) {
        this.getNewUsername().sendKeys(username);
        this.getNewPassword().sendKeys(password);
        this.getPasswordConfirm().sendKeys(confirmPassword);
        this.getPidNumber().sendKeys(pid);
        this.getRegisterBtn().submit();
    }
}
