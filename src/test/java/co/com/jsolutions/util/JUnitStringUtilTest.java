package co.com.jsolutions.util;

import org.junit.Assert;
import org.junit.Test;

public class JUnitStringUtilTest {

    @Test
    public void testRepeatManyTimes() {
        Assert.assertEquals("hellohellohello", JUnitStringUtil.repeat("hello", 3));
    }

    @Test
    public void testRepeatOnce() {
        Assert.assertNotEquals("hellohellohello", JUnitStringUtil.repeat("hello", 1));
    }

    @Test
    public void testRepeatZeroTimes() {
        Assert.assertEquals("", JUnitStringUtil.repeat("hello", 0));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRepeatNegativeNumber() {
        JUnitStringUtil.repeat("hello", -1);
    }


}