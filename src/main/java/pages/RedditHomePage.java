package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;
import static util.CommonConstants.*;

public class RedditHomePage extends BasePage {

    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@data-testid='search-results-filter-sort']")
    private WebElement sortResultsButton;


    public RedditHomePage() {
        PageFactory.initElements(driver, this);
    }

    public RedditHomePage goToHomePage() {
        driver.get(HOMEURL);
        System.out.println("LOG POINT- - - - - - - - - - - - - - - - - -navigate to: " + HOMEURL);
        return this;
    }

    public RedditHomePage useSearchBar() {
        clickTo(searchBar);
        System.out.println("LOG POINT- - - - - - - - - - - - - - - - - -use search bar");
        return this;
    }

    public RedditHomePage makeSearchQuery() {
        fillIn(searchBar, SEARCHQUERY).pressEnter(searchBar);
        System.out.println("LOG POINT- - - - - - - - - - - - - - - - - search for: " + SEARCHQUERY);
        return this;
    }

    public boolean checkIfIsRedditHomePage() {
        String expected = "Reddit - Dive into anything";
        String checker = driver.getTitle();
        System.out.printf("LOG POINT- - - - - -asserting title is '%s' --> %s\n\n", expected, checker);
        return checker.contains(expected);
    }

    public boolean checkIfSearchSucceed() {
        String expected = "Sort";
        String checker = waitForTextOf(sortResultsButton);
        System.out.printf("LOG POINT- - - - -asserting '%s' button is present --> button name is: %s\n\n", expected, checker);
        return checker.contains(expected);
    }

}
