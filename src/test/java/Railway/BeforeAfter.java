package Railway;

import Constant.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BeforeAfter {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", "D:\\lggear\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

}
