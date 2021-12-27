package Common;

import java.util.Random;

public class Utilities {
    public static String getProjectPath(){
        return System.getProperty("user.dir");
    }

    public static String generateRandomEmail(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 9) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString().toLowerCase();
        return saltStr;
    }

    public static String generateRandomPassword(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
                +"jklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static String generateRandomPID(int len){
        String chars = "0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(len);
        for (int i = 0; i < len; i++){
            stringBuilder.append(chars.charAt(random.nextInt(chars.length())));
        }
        return stringBuilder.toString();
    }

    public static void main(String []args){
        System.out.println(getProjectPath());
        System.out.println(generateRandomEmail() + "@email.com");
        System.out.println(generateRandomPassword(10));
        System.out.println(generateRandomPID(9));
    }
}
