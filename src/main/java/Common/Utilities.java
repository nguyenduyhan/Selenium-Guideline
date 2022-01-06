package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utilities {
    private final static java.text.SimpleDateFormat DATE_FORMAT = new java.text.SimpleDateFormat("M/dd/yyyy");
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static String generateRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString().toLowerCase();
        return saltStr;
    }

    public static String generateRandomEmail(){
        return generateRandomString() + System.currentTimeMillis() + "@example.com";
    }

    public static String generateRandomPassword(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
                + "jklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static String generateRandomPID(int len) {
        String chars = "0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            stringBuilder.append(chars.charAt(random.nextInt(chars.length())));
        }
        return stringBuilder.toString();
    }

    public static String getTrainDate(){
        LocalDate today = LocalDate.now();
        LocalDate nextday = today.plusWeeks(1);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String firstTemp = nextday.format(dateFormat);
        String[] secondTemp = firstTemp.split("/");
        int month = Integer.parseInt(secondTemp[0]);
        int day = Integer.parseInt(secondTemp[1]);
        int year = Integer.parseInt(secondTemp[2]);
        String dpDay = month + "/" + day + "/" + year;
        return dpDay;
    }

    public static void waitDriver(By e){
        WebDriverWait webDriverWait = new WebDriverWait(Constant.WEBDRIVER, 10);

    }

    public static void main(String[] args) {
        System.out.println(getProjectPath());
        System.out.println(generateRandomEmail() + " length is: " + generateRandomEmail().length());
        System.out.println(generateRandomPassword(10));
        System.out.println(generateRandomPID(9));
        System.out.println(getTrainDate());
    }
}
