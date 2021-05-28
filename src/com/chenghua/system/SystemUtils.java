package com.chenghua.system;

import java.nio.file.FileSystems;

public class SystemUtils {

    public static final String SEPARATOR = FileSystems.getDefault().getSeparator();

    public static void println(Object content){
        System.out.println(content);
    }
}
