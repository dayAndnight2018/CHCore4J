package com.chenghua.base64;

import com.chenghua.beans.BeanUtils;
import com.chenghua.extendslite.StringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

    private static final Charset CHARSET_UTF8 = StandardCharsets.UTF_8;

    /**
     * encode String to base64
     *
     * @param input
     * @param charset default utf-8
     * @return
     */
    public static String encode(String input, Charset charset) {
        if (StringUtils.isBlank(input)) {
            return StringUtils.EMPTY;
        }
        charset = BeanUtils.defaultValue(charset, CHARSET_UTF8);
        return Base64.getEncoder().encodeToString(input.getBytes(charset));
    }

    /**
     * decode from base64 strings
     *
     * @param input
     * @param charset default utf-8
     * @return
     */
    public static String decode(String input, Charset charset) {
        if (StringUtils.isBlank(input)) {
            return StringUtils.EMPTY;
        }
        charset = BeanUtils.defaultValue(charset, CHARSET_UTF8);
        byte[] bytes = Base64.getDecoder().decode(input.getBytes(charset));
        return new String(bytes, charset);
    }
}
