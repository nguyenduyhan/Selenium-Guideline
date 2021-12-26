package Common;

public class Utilities {
    public static String getProjectPath(){
        return System.getProperty("user.dir");
    }

    public static void main(String []args){
        System.out.println(getProjectPath());
    }
}
