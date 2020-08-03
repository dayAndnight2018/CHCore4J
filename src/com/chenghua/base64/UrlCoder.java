package com.chenghua.base64;

import com.chenghua.extendslite.StringExtends;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class UrlCoder {

    /**
     * encode a url
     * @param input
     * @param charset
     * @return
     */
    public static String encode(String input, Charset charset){
        if (StringExtends.isBlank(input)) {
            return null;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }

        return URLEncoder.encode(input,charset);
    }

    /**
     * decode a url
     * @param input
     * @param charset
     * @return
     */
    public static String decode(String input, Charset charset){
        if (StringExtends.isBlank(input)) {
            return null;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }

        return URLDecoder.decode(input, charset);
    }
}
