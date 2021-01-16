package com.chenghua.regex;

import com.chenghua.extendslite.StringUtils;

public class RegexUtils {

    private static final String LETTER_AND_DIGIT_PATTERN = "^[a-z0-9A-Z]+$";
    private static final String DIGIT_PATTERN = "^[0-9]+$";
    private static final String LETTER_PATTERN = "^[a-zA-Z]+$";

    /**
     * 字符串仅包含字母和数字
     * @param input
     * @return
     */
    public static boolean letterOrDigit(String input){
        if(StringUtils.isBlank(input)){
            return false;
        }
        return input.matches(LETTER_AND_DIGIT_PATTERN);
    }

    public static boolean digit(String input){
        if(StringUtils.isBlank(input)){
            return false;
        }
        return input.matches(DIGIT_PATTERN);
    }

    public static boolean letter(String input){
        if(StringUtils.isBlank(input)){
            return false;
        }
        return input.matches(LETTER_PATTERN);
    }
}
