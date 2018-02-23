package com.game.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regex Utility class
 */
public class RegexUtil {

    private static Pattern pattern = Pattern.compile("^\\d+,\\d+$");

    /**
     * This utility method checks whether input String is comma separated
     * numbers or not.
     * </p>
     * for example:
     * </p>
     * if input String is "1,2" then result is true.
     * </p>
     * if input string is "xyz" then result is false.
     * </p>
     * if input string is "123" then result is false.
     * </p>
     * if input string is 10,10 then result is true.
     *
     * @param input
     * @return boolean value of the validation result.
     */
    public static boolean matchCommaSeparatedDigits(String input) {

        Matcher matcher = pattern.matcher(input);
        boolean flag = matcher.matches();

        if (!matcher.matches()) {
            System.out.println("Wrong input !!!");
        }

        return flag;
    }
}
