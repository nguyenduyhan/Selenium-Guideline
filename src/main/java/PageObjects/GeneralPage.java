package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Constant;

public class GeneralPage {
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By welcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By usernameLeftBlank = By.xpath("//label[contains(text(),'You must specify a username.')]");
    private final By invalidPasswordError = By.xpath("//p[contains(text(),'Invalid username or password. Please try again.')]");
    private final By backToHome = By.xpath("//h1[contains(text(),'Welcome to Safe Railway')]");
    private final By bookTicketTitle = By.xpath("//div//h1[contains(text(), 'Book ticket')]");
    private final By registerSuccessMsg = By.xpath("//p[contains(text(),'Registration Confirmed! You can now log in to the ')]");
    private final By inUsedEmailAddress = By.xpath("//p[contains(text(),'This email address is already in use.')]");
    //create account with password and pid empty
    private final By msgError = By.xpath("//p[contains(text(),\"There're errors in the form. Please correct the er\")]");
    private final By lblPsMsgError = By.xpath("//label[contains(text(),'Invalid password length')]");
    private final By lblPsConfirmMsgError = By.xpath("//label[contains(text(),'The two passwords do not match')]");
    private final By lblPidMsgError = By.xpath("//label[contains(text(),'Invalid ID length')]");
    //change password
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By lblConfirmPasswordError = By.xpath("//label[contains(text(),'The password confirmation does not match the new p')]");
    private final By lblConfirmPasswordError2 = By.xpath("//p[contains(text(),'Password change failed. Please correct the errors ')]");
    //tc16 - cancel ticket
    private final By tabManageTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    //tc15
    private final By tabTimeTable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
    private final By tabTicketPrice = By.xpath("//div[@id='menu']//a[@href='/Page/TrainPriceListPage.cshtml']");

    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(welcomeMessage);
    }

    protected WebElement getUsernameBlank() {
        return Constant.WEBDRIVER.findElement(usernameLeftBlank);
    }

    protected WebElement getInvalidPassword() {
        return Constant.WEBDRIVER.findElement(invalidPasswordError);
    }

    protected WebElement getHomeTitle() {
        return Constant.WEBDRIVER.findElement(backToHome);
    }

    protected WebElement getBookTitle() {
        return Constant.WEBDRIVER.findElement(bookTicketTitle);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getRegisterMessageSuccess() {
        return Constant.WEBDRIVER.findElement(registerSuccessMsg);
    }

    protected WebElement lblEmailAddressInUsedMsg() {
        return Constant.WEBDRIVER.findElement(inUsedEmailAddress);
    }

    //create account with password and pid are empty
    protected WebElement getMessageError() {
        return Constant.WEBDRIVER.findElement(msgError);
    }

    protected WebElement getLblPsMsgError() {
        return Constant.WEBDRIVER.findElement(lblPsMsgError);
    }

    protected WebElement getLblPsConfirmMsgError() {
        return Constant.WEBDRIVER.findElement(lblPsConfirmMsgError);
    }

    protected WebElement getLblPidMsgError() {
        return Constant.WEBDRIVER.findElement(lblPidMsgError);
    }

    //Change password
    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getLblChangePasswordConfirm() {
        return Constant.WEBDRIVER.findElement(lblConfirmPasswordError);
    }

    protected WebElement getLblChangePasswordConfirmAbove() {
        return Constant.WEBDRIVER.findElement(lblConfirmPasswordError2);
    }

    //tc16
    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabManageTicket);
    }
    //tc15
    protected WebElement getTabTimeTable(){
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }
    protected WebElement getTabTicketPrice(){
        return Constant.WEBDRIVER.findElement(tabTicketPrice);
    }

    //Method
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public String getErrorWelcomeMessage() {
        return this.getUsernameBlank().getText();
    }

    public String getErrorInvalidPassword() {
        return this.getInvalidPassword().getText();
    }

    public String getHomeTitleLogout() {
        return this.getHomeTitle().getText();
    }

    public String getBookTicketTitleRedirect() {
        return this.getBookTitle().getText();
    }

    public String getRegisterSuccessMessage() {
        return this.getRegisterMessageSuccess().getText();
    }

    public String getMessageEmailInUsed() {
        return this.lblEmailAddressInUsedMsg().getText();
    }

    //create account with password and pid are empty
    public String getAboveMsgError() {
        return this.getMessageError().getText();
    }

    public String getSideErrorMsgPs() {
        return this.getLblPsMsgError().getText();
    }

    public String getSideErrorMsgPid() {
        return this.getLblPidMsgError().getText();
    }

    //Confirm password field
    public String getErrorChangePasswordConfirmMsg() {
        return this.getLblChangePasswordConfirm().getText();
    }

    public String getErrorChangePasswordConfirmMsg2() {
        return this.getLblChangePasswordConfirmAbove().getText();
    }
    //end tc09

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void gotoHome() {
        this.getTabLogout().click();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    //change password
    public void gotoChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    //tc16
    public void gotoMyTicketPage() {
        this.getTabMyTicket().click();
    }

    //tc15
    public void gotoTimeTablePage(){
        this.getTabTimeTable().click();
    }
}
