package driver;

import exceptions.WrongBrowserException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    private static final String BROWSER = System.getProperty("browser");

    public static WebDriver create() {
        switch (BROWSER) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsf = new FirefoxOptions();
                optionsf.addPreference("dom.push.enabled", false);
                return new FirefoxDriver(optionsf);
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                return new ChromeDriver(options);
            default:
                throw new WrongBrowserException("Unknown parameter: " + BROWSER);
        }
    }
}