package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RedditHomePage extends BasePage {

    public static final String URL = "https://www.reddit.com/";

    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchBar;

    public RedditHomePage(WebDriver driver) {
        super(driver);
    }

    public RedditHomePage open() {
        driver.get(URL);
        return this;
    }
}
