package com.chenghua.base64;

import com.chenghua.extendslite.StringUtils;

import java.io.UnsupportedEncodingException;
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
    public static String encode(String input, Charset charset) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(input)) {
            return null;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }

        return URLEncoder.encode(input, charset.name());
    }

    /**
     * decode a url
     * @param input
     * @param charset
     * @return
     */
    public static String decode(String input, Charset charset) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(input)) {
            return null;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }

        return URLDecoder.decode(input, charset.name());
    }
}
