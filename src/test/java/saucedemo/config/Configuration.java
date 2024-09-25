package saucedemo.config;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static final Properties TEST_PROPERTIES = loadProperties();

    private Configuration() {}

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream propInputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("properties/default.properties")) {
            properties.load(propInputStream);
        } catch (IOException e) {
            throw new AssertionError(String.format("Error while fetching properties file: %s", e));
        }
        return properties;
    }

    public static String get(String propertyName) {
        String value = getSystemProperty(propertyName);
        if (StringUtils.isBlank(value)) {
            value = getFromPropertyFile(propertyName);
        }
        return value;
    }

    private static String getSystemProperty(final String key) {
        return System.getProperty(key);
    }

    private static String getFromPropertyFile(final String key) {
        return TEST_PROPERTIES.getProperty(key);
    }
}
