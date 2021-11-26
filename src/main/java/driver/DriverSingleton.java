package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

	private static WebDriver driver;
	private static final String BROWSER = System.getProperty("browser");

	private DriverSingleton() {}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (BROWSER) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					break;

				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					break;

				default:
					throw new IllegalArgumentException("Unknown parameter: " + BROWSER);
			}
		}
		return driver;
	}

	public static void closeDriver() {
		driver.quit();
		driver = null;
	}
}
