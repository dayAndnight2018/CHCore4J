package com.chenghua.regex;

import com.chenghua.extendslite.StringUtils;

public class RegexUtils {

    private static final String LETTER_AND_DIGIT_PATTERN = "^[a-z0-9A-Z]+$";

    /**
     * 字符串仅包含字母和数字
     * @param input
     * @return
     */
    public static boolean letterAndDigit(String input){
        if(StringUtils.isBlank(input)){
            return false;
        }
        return input.matches(LETTER_AND_DIGIT_PATTERN);
    }
}
