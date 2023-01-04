package co.com.jsolutions.util;

public class ManualStringUtil {

    public static String repeat(String str, int times){
        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }

}
