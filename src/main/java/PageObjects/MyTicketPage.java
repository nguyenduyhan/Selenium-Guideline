package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    public final By btnCancel = By.xpath("//input[@value='Cancel']");

    public WebElement getButtonCancel() {
        return Constant.WEBDRIVER.findElement(btnCancel);
    }

    public void clickCancelButton() {
        this.getButtonCancel().click();
    }

    public boolean isElementPresent() {
        try {
            if (getButtonCancel().isDisplayed()){
                return false;
            } else {
                return true;
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return true;
    }
}
