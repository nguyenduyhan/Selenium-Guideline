package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage extends GeneralPage {
    public final By btnCancel = By.xpath("//input[@value='Cancel']");
    public final By btnFilter = By.xpath("//input[@value='Apply Filter']");
    public final By lblMessageError = By.xpath("//div[contains(@class, 'error message')]");

    public WebElement getBtnCancel() {
        return Constant.WEBDRIVER.findElement(btnCancel);
    }
    public WebElement getBtnFilter(){
        return Constant.WEBDRIVER.findElement(btnFilter);
    }
    public WebElement getLblMessageErrorFitler(){
        return Constant.WEBDRIVER.findElement(lblMessageError);
    }

    public String filterMessageError(){
        return this.getLblMessageErrorFitler().getText();
    }

    public void getDepartStationFilter(String option){
        Select select = new Select(Constant.WEBDRIVER.findElement(By.name("FilterDpStation")));
        select.selectByVisibleText(option);
    }
    public void getSatus(String option){
        Select select = new Select(Constant.WEBDRIVER.findElement(By.name("FilterStatus")));
        select.selectByVisibleText(option);
    }

    public void clickCancelButton() {
        this.getBtnCancel().click();
    }
    public void clickBtnFilter(){
        this.getBtnFilter().click();
    }

    public boolean isElementPresent() {
        try {
            if (getBtnCancel().isDisplayed()){
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
