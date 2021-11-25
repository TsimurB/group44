package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BrowserFactory {
    private static WebDriver driver;

    public WebDriver createDriver() {
        String browser = System.getProperty("browser");

        if (browser != null) {
            switch (browser) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    System.out.println("LOG POINT- - - - - - - - - - - - - - - - - -using FIREFOX due to user choice");
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    System.out.println("LOG POINT- - - - - - - - - - - - - - - - - -using EDGE due to user choice");
                }
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    System.out.println("LOG POINT- - - - - - - - - - - - - - - - - -using CHROME due to user choice");
                }
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("LOG POINT- - - - - - - - - - - - - - - - - -USING CHROME as default (no user choice)");
        }
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        System.out.println("LOG POINT- - - - - - - - - - - - - - - - - -" + browser + " driver was created in factory class. passed to driver provider class...");
        return driver;
    }
}
