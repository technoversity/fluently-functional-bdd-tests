package org.fluent.bdd.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.logging.Logger;

public class BrowserCoordinator {

    private static final Logger LOGGER = Logger.getLogger(BrowserCoordinator.class.getName());

    private static WebDriver webDriver;

    public synchronized static WebDriver getCurrentDriver() {
        if (webDriver == null) {
            try {
                webDriver = BrowserFactory.getWebDriver();
            }
            catch (UnreachableBrowserException e) {
                webDriver = BrowserFactory.getWebDriver();
            }
            catch (WebDriverException e) {
                webDriver = BrowserFactory.getWebDriver();
            }
            finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
        }
        return webDriver;
    }

    public static void close() {
        try {
            getCurrentDriver().quit();
            webDriver = null;
            LOGGER.info("closing the browser");
        }
        catch (UnreachableBrowserException e) {
            LOGGER.info("cannot close browser: unreachable browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }

}
