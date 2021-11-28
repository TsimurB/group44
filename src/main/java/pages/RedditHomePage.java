package pages;

import models.User;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RedditHomePage extends BasePage {

    private final static String HOMEURL = "https://www.reddit.com/";


    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@data-testid='search-results-filter-sort']")
    private WebElement sortResultsButton;

    @FindBy(xpath = "//a[@role='button' and contains (text(),'Log In')]")
    private WebElement loginButton;

    @FindBy(xpath = "//iframe[starts-with(@src, 'https://www.reddit.com/login/')]")
    private WebElement loginFrame;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameTextarea;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordTextarea;

    @FindBy(xpath = "//button[@type='submit' and contains (text(),'Log In')]")
    private WebElement loginSubmitButton;

    @FindBy(xpath = "//button[@id='COIN_PURCHASE_DROPDOWN_ID']")
    private WebElement coinPurchaseButton;

    @FindBy(xpath = "//button[@id='USER_DROPDOWN_ID']")
    private WebElement userMenuDropdown;

    @FindBy(xpath = "//i[contains (@class,'logout')]")
    private WebElement logoutSelection;

    @FindBy(xpath = "//input[@name='createPost']")
    private WebElement createPostTextarea;

    @FindBy(xpath = "//a[@role='button' and contains (text(),'Create Post')]")
    private WebElement createPostButton;


    public RedditHomePage goToHomePage() {
        driver.get(HOMEURL);
        this.logout();
        return this;
    }

    public RedditHomePage useSearchBar() {
        clickIn(searchBar);
        return this;
    }

    public RedditHomePage makeSearchQuery() {
        fillIn(searchBar, "something to find")
                .pressEnter(searchBar);
        return this;
    }

    public RedditHomePage pressLoginButton() {
        clickIn(loginButton);
        return this;
    }

    public RedditHomePage processLogin(User user) {
        switchFrame(loginFrame)
                .fillIn(usernameTextarea, user.getName())
                .fillIn(passwordTextarea, user.getPass())
                .pressEnter(passwordTextarea);
        driver.switchTo().defaultContent();
        return this;
    }

    public RedditHomePage logout() {
        try {
            if (coinPurchaseButton.isDisplayed()) {
                clickIn(userMenuDropdown)
                        .clickIn(logoutSelection);
            }
        } catch (NoSuchElementException e) {
            return this;
        }
        return this;
    }

    public RedditHomePage pressCreatePostButton() {
        clickIn(createPostButton);
        return this;
    }

    public boolean checkIfIsRedditHomePage() {
        String expected = "Reddit - Dive into anything";
        String checker = driver.getTitle();
        return checker.contains(expected);
    }

    public boolean checkIfSearchSucceed() {
        String expected = "Sort";
        String checker = waitForElement(sortResultsButton).getText();
        return checker.contains(expected);
    }

    public boolean checkIfUserIsLoggedIn() {
        String expected = "Create Post";
        String checker = waitForTextOf(createPostButton);
        return checker.contains(expected);
    }

}
