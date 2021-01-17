package com.chenghua.encrypt;

import com.chenghua.beans.BeanUtils;
import com.chenghua.exceptions.InvalidInputException;
import com.chenghua.extendslite.StringUtils;

public class EraseUtils {

    /**
     * erase first len characters in input
     *
     * @param input
     * @param len
     * @param c
     * @return
     * @throws InvalidInputException
     */
    public static String eraseLeft(String input, int len, Character c) throws InvalidInputException {
        if (StringUtils.isBlank(input) || len < 0) {
            throw new InvalidInputException();
        }

        len = BeanUtils.defaultValue(len, input.length(), l->l>input.length());
        c = BeanUtils.defaultValue(c, '*');

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(c);
        }
        String temp = StringUtils.subString(input, len, input.length() - len);
        if (StringUtils.isNotBlank(temp)) {
            sb.append(temp);
        }
        return sb.toString();
    }

    /**
     * erase last len characters in input
     *
     * @param input
     * @param len
     * @param c
     * @return
     * @throws InvalidInputException
     */
    public static String eraseRight(String input, int len, Character c) throws InvalidInputException {
        if (StringUtils.isBlank(input) || len < 0) {
            throw new InvalidInputException();
        }

        len = BeanUtils.defaultValue(len, input.length(), l->l>input.length());
        c = BeanUtils.defaultValue(c, '*');
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - len; i < input.length(); i++) {
            sb.append(c);
        }
        String temp = StringUtils.subString(input, 0, input.length() - len);
        if (StringUtils.isNotBlank(temp)) {
            sb.insert(0, temp);
        }
        return sb.toString();
    }

    /**
     * erase given start position and length len characters in input
     *
     * @param input
     * @param start
     * @param len
     * @param c
     * @return
     * @throws InvalidInputException
     */
    public static String erase(String input, int start, int len, Character c) throws InvalidInputException {
        if (StringUtils.isBlank(input) || len < 0) {
            throw new InvalidInputException();
        }
        if (start + len > input.length()) {
            len = input.length() - start;
        }

        c = BeanUtils.defaultValue(c, '*');
        StringBuilder sb = new StringBuilder();
        char[] array = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (i >= start && i <= start + len - 1) {
                sb.append(c);
                continue;
            }
            sb.append(array[i]);
        }
        return sb.toString();
    }

    /**
     * erase center 4 numbers in a cellphone number
     *
     * @param input
     * @param c
     * @return
     * @throws InvalidInputException
     */
    public static String erasePhoneNumber(String input, Character c) throws InvalidInputException {
        if (StringUtils.isBlank(input) || input.length() != 11) {
            throw new InvalidInputException();
        }

        c = BeanUtils.defaultValue(c, '*');
        return erase(input, 3, 4, null);
    }


    public static String eraseIdentityCardNumber(String input, Character c) throws InvalidInputException {
        if (StringUtils.isBlank(input) || input.length() != 18) {
            throw new InvalidInputException();
        }

        c = BeanUtils.defaultValue(c, '*');
        return erase(input, 6, 8, null);
    }
}
