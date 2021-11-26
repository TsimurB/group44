/**
 * This class implements Singleton pattern for webdriver instance to create and pass to page classes.
 */

package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverProvider {
    private static WebDriver driver;
    private static String browser = System.getProperty("browser");
    private static final Logger logger = LogManager.getLogger();


    private WebDriverProvider() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();
                    logger.info("Use Chrome driver");
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();
                    logger.info("Use Firefox driver");
                    break;

                default:
                    throw new IllegalArgumentException("Unknown parameter: " + browser);
            }
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
