package Railway;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import Constant.Constant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    //common method
    HomePage homePage = new HomePage();
    LoginPage loginPage;

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

    @Test
    public void TC01(){
        System.out.println("TC001 - User can login with valid account");
        homePage.open();

        loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Message");
    }

    @Test
    public void TC02(){
        System.out.println("TC002 - User can not login with blank 'Username' textbox");
        homePage.open();

        loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login("", Constant.PASSWORD).getErrorWelcomeMessage();
        String expectedMsg = "You must specify a username.";

        Assert.assertEquals(actualMsg, expectedMsg, "Message");
    }

    @Test
    public void TC03(){
        System.out.println("User cannot log into Railway with invalid password");
        homePage.open();

        loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD).getErrorInvalidPassword();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Message");
    }

    @Test
    public void TC04(){
        System.out.println("Use is redirected to Book ticket page after logging in");

        String actualMsg = homePage.open().gotoBookTicketPage().gotoLoginPage()
                .loginBookTicket(Constant.USERNAME, Constant.PASSWORD)
                .gotoBookTicketPage().getBookTicketTitleRedirect();
        String expectedMsg = "Book ticket";

        Assert.assertEquals(actualMsg, expectedMsg, "Message");

    }

    @Test
    public void TC05(){
        System.out.println("User login wrong password several time");
        homePage.open();
        for (int i = 0; i <= 3; i++){
            loginPage = homePage.gotoLoginPage();
            loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);

        }
        String actualMsg = loginPage.getErrorInvalidPassword();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes";

        Assert.assertEquals(actualMsg, expectedMsg, "Message");



    }

    @Test
    public void TC06(){
        System.out.println("User is redirected to Home page after logging out");
        homePage.open();

        loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = loginPage.gotoHome().getHomeTitleLogout();
//        loginPage.gotoHome();
        String expectedMsg = "Welcome to Safe Railway";

        Assert.assertEquals(actualMsg, expectedMsg, "Message");

    }

}
