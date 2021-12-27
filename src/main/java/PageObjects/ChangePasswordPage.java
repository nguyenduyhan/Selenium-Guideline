package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {
    private final By currentPassword = By.id("currentPassword");
    private final By newPassword = By.id("newPassword");
    private final By confirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//input[@value='Change Password']");

    public WebElement getCurrentPassword() {
        return Constant.WEBDRIVER.findElement(currentPassword);
    }

    public WebElement getNewPassword() {
        return Constant.WEBDRIVER.findElement(newPassword);
    }

    public WebElement getPasswordConfirm() {
        return Constant.WEBDRIVER.findElement(confirmPassword);
    }

    public WebElement getBtnChangePs() {
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }

    public void changeAccountPassword(String currentpassword, String newpassword, String confirmpassword) {
        this.getCurrentPassword().sendKeys(currentpassword);
        this.getNewPassword().sendKeys(newpassword);
        this.getPasswordConfirm().sendKeys(confirmpassword);
        this.getBtnChangePs().click();
    }
}
