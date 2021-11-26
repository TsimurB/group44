package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RedditHomePage extends BasePage {

    private final static String HOMEURL = "https://www.reddit.com/";


    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@data-testid='search-results-filter-sort']")
    private WebElement sortResultsButton;


    public RedditHomePage goToHomePage() {
        driver.get(HOMEURL);
        return this;
    }

    public RedditHomePage useSearchBar() {
        clickIn(searchBar);
        return this;
    }

    public RedditHomePage makeSearchQuery() {
        fillIn(searchBar, "something to find").pressEnter(searchBar);
        return this;
    }

    public boolean checkIfIsRedditHomePage() {
        String expected = "Reddit - Dive into anything";
        String checker = driver.getTitle();
        return checker.contains(expected);
    }

    public boolean checkIfSearchSucceed() {
        String expected = "Sort";
        String checker = waitForTextOf(sortResultsButton);
        return checker.contains(expected);
    }

}
