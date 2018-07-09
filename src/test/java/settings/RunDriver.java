package settings;

import org.openqa.selenium.WebDriver;

public class RunDriver {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    static void setWebDriver(WebDriver webDriver) {
        RunDriver.webDriver = webDriver;
    }
}