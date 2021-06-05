package com.chenghua.ios;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertyUtils {

    /**
     * 加载配置文件为Properties
     * @param path 配置名称
     * @return 配置信息
     * @throws IOException 找不到文件
     */
    public static Properties loadProperties(String path) throws IOException {
        Properties props = new Properties();
        try (InputStream inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream(path)){
            props.load(inputStream);
        }
        return props;
    }

    /**
     * 加载图像
     * @param path 图像名称
     * @return 图像
     * @throws IOException 找不到文件
     */
    public static Image loadImage(String path) throws IOException {
        URL url = PropertyUtils.class.getClassLoader().getResource(path);
        return ImageIO.read(url);
    }
}
