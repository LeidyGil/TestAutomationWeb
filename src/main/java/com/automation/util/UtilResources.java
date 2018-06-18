package com.automation.util;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author cbuelvasc
 */
public class UtilResources {

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private static Properties properties;

    public void getPropertiesInstance() {
        properties = new Properties();
        InputStream input = null;
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            System.out.println(properties.toString());
        } catch (IOException e) {
            LOGGER.error("Error load properties", e);
        } finally {
            if (null != input) {
                try {
                    input.close();
                } catch (IOException e) {
                    LOGGER.error("Error load properties", e);
                }
            }
        }
    }

    public static Properties getProperties() {
        new UtilResources().getPropertiesInstance();
        return UtilResources.properties;
    }

    public static String getProperty(String property) {
        getProperties();
        return properties.getProperty(property);
    }
}
