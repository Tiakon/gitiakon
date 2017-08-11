package com.tiakon.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Hoictas on 2017/8/9.
 */
public class PropertiesUtil {
    public static String getValue(String key) throws IOException {
        Properties prop = new Properties();
        InputStream resourceAsStream = JDBCUtil.class
                .getResourceAsStream("/com/tiakon/conf/jdbc.properties");
        prop.load(resourceAsStream);
        String property = prop.getProperty(key);
        return property;
    }
}
