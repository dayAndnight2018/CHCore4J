package com.chenghua.base64;
import com.chenghua.extendslite.StringExtends;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

    /**
     * encode String to base64
     *
     * @param input
     * @param charset default utf-8
     * @return
     */
    public static String encode(String input, Charset charset) {
        if (StringExtends.isBlank(input)) {
            return null;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        byte[] bytes = input.getBytes(charset);
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * decode from base64 strings
     * @param input
     * @param charset default utf-8
     * @return
     */
    public static String decode(String input, Charset charset) {
        if (StringExtends.isBlank(input)) {
            return null;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        byte[] bytes = input.getBytes(charset);
        byte[] after = Base64.getDecoder().decode(bytes);
        return  new String(after,charset);
    }
}
