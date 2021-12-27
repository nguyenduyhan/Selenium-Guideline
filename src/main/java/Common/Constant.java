package Common;

import org.openqa.selenium.*;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.railway.somee.com";
    public static final String USERNAME = "thanhle@logigear.com";
    public static final String PASSWORD = "12345678";
    public static final String INVALID_PASSWORD = "87654321";
    public static final String TITLEBOOKTICKET = "Book ticket";

    public static final String NEWUSERNAME = "email21@gmail.com";
    public static final String NEWPS = "10030110Pl";
    public static final String NEWPSCF = "10030110Pl";
    public static final String PID = "192025233";
    public static final String REGISTER_CONFIRM = "Registration Confirmed! You can now log in to the site.";
    public static final String ALREADY_USED_EMAIL = "This email address is already in use.";
    //msg create account with empty password and pid
    public static final String ERROR_MESSAGE = "There're errors in the form. Please correct the errors and try again.";
    public static final String ERROR_PASSWORD_MSG = "Invalid password length";
    public static final String ERROR_PASSWORD_MSG_CONFIRM = "The two passwords do not match";
    public static final String ERROR_PID_MESSAGE = "Invalid ID length";
    //change password confirm msg
    public static final String ERROR_CHANGEPASSWORD = "The password confirmation does not match the new password.";
    //not activated account
    public static final String ACCOUNT_NOT_ACTIVE = "Invalid username or password. Please try again.";
}
