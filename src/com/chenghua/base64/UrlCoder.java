package com.chenghua.base64;

import com.chenghua.beans.BeanUtils;
import com.chenghua.extendslite.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class UrlCoder {

    private static final Charset CHARSET_UTF8 = StandardCharsets.UTF_8;

    /**
     * encode a url
     *
     * @param input
     * @param charset
     * @return
     */
    public static String encode(String input, Charset charset) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(input)) {
            return null;
        }
        charset = BeanUtils.defaultValue(charset, CHARSET_UTF8);
        return URLEncoder.encode(input, charset.name());
    }

    /**
     * decode a url
     *
     * @param input
     * @param charset
     * @return
     */
    public static String decode(String input, Charset charset) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(input)) {
            return null;
        }
        charset = BeanUtils.defaultValue(charset, CHARSET_UTF8);
        return URLDecoder.decode(input, charset.name());
    }
}
