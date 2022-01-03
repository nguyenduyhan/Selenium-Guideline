package Railway;

import Common.Constant;
import Common.Utilities;
import PageObjects.ChangePasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase{
    @Test(description = "User can't change password when 'New Password' and 'Confirm Password' are different")
    public void TC09(){
        System.out.println("Step 1: Navigate to Login Page");
        homePage.open();
        homePage.gotoLoginPage();

        System.out.println("Step 2: Logging in");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 3: Navigate to Change Password page");
        homePage.gotoChangePasswordPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();

        System.out.println("Step 4: Enter information");
        changePasswordPage.changeAccountPassword(Constant.PASSWORD, "a123:\"/{}!@$\\",
                "b456:\"/{}!@$\\");

        System.out.println("Step 5: Verify checkpoint");
        String actualMsg = homePage.getErrorChangePasswordConfirmMsg2();
        String expectedMsg = Constant.ERROR_CHANGEPASSWORD2;
        String actualMsg2 = homePage.getErrorChangePasswordConfirmMsg();
        String expectedMsg2 = Constant.ERROR_CHANGEPASSWORD;

        Assert.assertEquals(actualMsg, expectedMsg);
        Assert.assertEquals(actualMsg2, expectedMsg2);
    }
}
