/*
  This class implements Singleton pattern for webdriver instance to create and pass to page classes.
 */

package driver;

import org.openqa.selenium.WebDriver;



public class WebDriverProvider extends BrowserFactory {
    private static WebDriverProvider webDriverProvider = null;
    private static WebDriver driver;

    //private constructor
    private WebDriverProvider() {
        driver = createDriver();
        System.out.printf("LOG POINT- - - - - - - - - - - - - - - - - -%s driver is in provider class. "
                , System.getProperty("browser"));
    }

    //static method containing unique instance of driver provider
    public static WebDriverProvider getWebDriverProvider() {
        if (webDriverProvider == null) {
            webDriverProvider = new WebDriverProvider();
        }
        return webDriverProvider;
    }

    //public driver instance getter
    public WebDriver getDriver() {
        System.out.println("Getter method ready.");
        return driver;
    }

    //public driver instance closer
    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
