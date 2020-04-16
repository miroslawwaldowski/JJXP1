package pl.Java_JSON_XML.JJXP1;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeselCheckTest {

    Logger logger = Logger.getLogger(PeselCheck.class);

    @Test
    public void testCorrectPesel() {
        Assert.assertTrue(PeselCheck.check("85091704176"));
    }
    @Test
    public void testWrongPesel() {
        Assert.assertFalse(PeselCheck.check("85090000000"));
    }
}