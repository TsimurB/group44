package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static final String BROWSER = System.getProperty("browser");

	public static WebDriver create() {
		switch (BROWSER) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				return new FirefoxDriver();

			case "chrome":
				/* falls through */
			default:
				WebDriverManager.chromedriver().setup();
				return new ChromeDriver();
		}
	}
}
