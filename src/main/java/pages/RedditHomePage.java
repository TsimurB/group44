package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.CommonConstants.*;

public class RedditHomePage extends BasePage {

    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchBar;


    public RedditHomePage() {
        PageFactory.initElements(driver, this);
    }

    public RedditHomePage goToHomePage() {
        driver.get(HOMEURL);
        return this;
    }

    public RedditHomePage useSearchBar() {
        clickTo(searchBar);
        return this;
    }

    public RedditHomePage makeSearchQuery() {
        fillIn(searchBar, SEARCHQUERY).pressEnter(searchBar);
        return this;
    }

}
