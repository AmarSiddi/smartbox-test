package com.smartbox.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

/**@author Amarnath
 * PropertiesOperations class used to perform the operations on the .properties file.
 */

public class PropertiesOperations {

    static Properties prop = new Properties();

    public static String getPropertyValue(String key) {

        String propFilePath = System.getProperty("user.dir")+"/src/main/resources/config.properties";
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(propFilePath);
            prop.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String value = prop.get(key).toString();

        if(StringUtils.isEmpty(value)) {
            try {
                throw new Exception("Value is not specified for key: "+key + " in properties file.");
            }catch(Exception ignored) {}
        }

        return value;
    }
}