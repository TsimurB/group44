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
        System.out.printf("\nLOG POINT- - - - - -asserting title is '%s' --> %s", expected, checker);
        return checker.contains(expected);
    }

    public boolean checkIfSearchSucceed() {
        String expected = "reddit.com: search results - " + SEARCHQUERY;
        String checker = driver.getTitle();
        System.out.printf("\nLOG POINT- - - - - -asserting title is '%s' --> %s", expected, checker);
        return checker.contains(expected);
    }

}
