package driver;

import org.openqa.selenium.WebDriver;


public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.create();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        return driver;
    }
    public static void closeDriver() {
            driver.quit();
            driver = null;
    }
}