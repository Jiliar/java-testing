package co.com.jsolutions.util;

public class ManualStringUtilTest {

    public static void main(String[] args) {

        //First Scenario, Test is OK: with assertEquals
        assertEquals(ManualStringUtil.repeat("hello", 3), "hellohellohello");

        //Second Scenario, Test is FAIL: with assertEquals
        assertEquals(ManualStringUtil.repeat("hello", 1), "hellohellohello");

        //Third Scenario, Test is FAIL: with Exceptions
        String result3 = ManualStringUtil.repeat("hello", 1);
        if(!result3.equals("hellohellohello")){
            //System.out.println("FAIL");
            throw new RuntimeException("Error");
        }
    }

    private static void assertEquals(String actual, String expected){
        if(!actual.equals(expected)){
            throw new RuntimeException(actual + " is not equals to "+expected);
        }else{
            System.out.println("Test OK: "+actual + " is equals to "+expected);
        }
    }
}