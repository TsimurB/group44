/*
  This class implements Singleton pattern for webdriver instance to create and pass to page classes.
 */

package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverProvider {
    private static WebDriverProvider webDriverProvider = null;
    private static WebDriver driver;

    //private constructor
    private WebDriverProvider() {
        String browser = System.getProperty("browser");

        if (browser != null) {
            switch (browser) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    System.out.println("LOG POINT- - - - - - - - - - - - - - - - - - - - - - - using FIREFOX");
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    System.out.println("LOG POINT- - - - - - - - - - - - - - - - - - - - - - - - -using EDGE");
                }
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    System.out.println("LOG POINT- - - - - - - - - - - - - - - - - - - - - - - -using CHROME");
                }
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
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
        return driver;
    }

    //public driver instance closer
    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
