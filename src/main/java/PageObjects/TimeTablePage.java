package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage{
    public final By linkCheckPrice = By.xpath("//td[text()='Sài Gòn']/following-sibling::td[text()='Phan Thiết']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a");

    public WebElement getLinkCheckPrice(){
        return Constant.WEBDRIVER.findElement(linkCheckPrice);
    }

    public void clickLinkCheckPrice(){
        this.getLinkCheckPrice().click();
    }
}
