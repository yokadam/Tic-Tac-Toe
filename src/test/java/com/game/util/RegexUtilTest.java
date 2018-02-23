package com.game.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link RegexUtil} class.
 *
 * @author yogesh.kadam
 */
public class RegexUtilTest {

    @Test
    public void testCommaSeperatedDigits_validCommaSeperatedDigitString_returnTrue() {
        assertTrue(RegexUtil.matchCommaSeparatedDigits("1,2"));
    }

    @Test
    public void testCommaSeperatedDigits_invalidStringcontainingWords_returnFalse() {
        assertFalse(RegexUtil.matchCommaSeparatedDigits("xyz"));
    }

    @Test
    public void testCommaSeperatedDigits_invalidStringcontainingAphanumerics_returnFalse() {
        assertFalse(RegexUtil.matchCommaSeparatedDigits("x1,?"));
    }

    @Test
    public void testCommaSeperatedDigits_validCommaSeperatedDoubleDigitString_returnFalse() {
        assertTrue(RegexUtil.matchCommaSeparatedDigits("10,10"));
    }
}
