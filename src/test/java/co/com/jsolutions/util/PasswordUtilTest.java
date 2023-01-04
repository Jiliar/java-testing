package co.com.jsolutions.util;

import org.junit.Test;

import static co.com.jsolutions.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.assertEquals;

public class PasswordUtilTest {

    @Test
    public void testWeakWhenHasLessThanEightLetters(){
        assertEquals(WEAK, PasswordUtil.accessPassword("1234567"));
    }

    @Test
    public void testWeakWhenHasOnlyLetters(){
        assertEquals(WEAK, PasswordUtil.accessPassword("abcdefgh"));
    }

    @Test
    public void testMediumWhenHasLettersAndNumbers(){
        assertEquals(MEDIUM, PasswordUtil.accessPassword("abcd1234"));
    }

    @Test
    public void testStrongWhenHasLettersAndNumbersAndSymbols(){
        assertEquals(STRONG, PasswordUtil.accessPassword("abc123*_"));
    }

}