package org.fluent.bdd.utils;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Configuration {

    private static final Logger LOGGER = Logger.getLogger(Configuration.class.getName());

    private static final String DEFAULT_PROPERTIES = "application.properties";

    private static final String ACTIVE_PROFILE = "active.profile";

    private static final Properties properties = new Properties();

    private static String baseUrl;

    private static String browserType;

    static {
        try {
            if (System.getProperty(ACTIVE_PROFILE) != null && System.getProperty(ACTIVE_PROFILE).trim().length() > 0) {
                LOGGER.info("Active profile is " + System.getProperty(ACTIVE_PROFILE).trim() + ". Loading " + System.getProperty(ACTIVE_PROFILE).trim() +
                        ".properties");
                properties.load(Configuration.class.getClassLoader()
                        .getResourceAsStream("application-" + System.getProperty(ACTIVE_PROFILE).trim() + ".properties"));
            }
            else {
                LOGGER.info("Loading " + DEFAULT_PROPERTIES);
                properties.load(Configuration.class.getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        initialise();
    }

    private static void initialise() {
        baseUrl = properties.getProperty("base.url");
        browserType = properties.getProperty("browser.type");
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getBrowserType() {
        return browserType;
    }
}
