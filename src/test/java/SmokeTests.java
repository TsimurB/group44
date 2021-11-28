import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RedditHomePage;
import pages.RedditPostCreationPage;
import service.UserCreator;
import steps.StepsFacade;

public class SmokeTests extends BaseTest {

    private final RedditHomePage redditHomePage = new RedditHomePage();
    private final RedditPostCreationPage redditPostCreationPage = new RedditPostCreationPage();
    private final StepsFacade stepsFacade = new StepsFacade();


    @Test
    public void canNavigateToRedditHomePageTest() {
        redditHomePage
                .goToHomePage();
        Assert.assertTrue(redditHomePage.checkIfIsRedditHomePage(), "This is not a reddit.com !");
    }

    @Test
    public void canUseSearchBarForCustomQueriesTest() {
        redditHomePage
                .goToHomePage()
                .useSearchBar()
                .makeSearchQuery();
        Assert.assertTrue(redditHomePage.checkIfSearchSucceed(), "Search failed!");
    }

    @Test(priority = 1)
    public void canLoginWithValidCredentialsTest() {
        User validTestUser = UserCreator.withNameAndPass();
        redditHomePage
                .goToHomePage()
                .pressLoginButton()
                .processLogin(validTestUser);
        Assert.assertTrue(redditHomePage.checkIfUserIsLoggedIn(), "Login failed!");
    }

    @Test(priority = 2)
    public void canPostDraftsTest() {
        User validTestUser = UserCreator.withNameAndPass();
        stepsFacade
                .completePrerequisitesForPosting(validTestUser)
                .createDraft();
        Assert.assertFalse(redditPostCreationPage.checkIfDraftCounterIntact(), "No draft is added!");
    }
}
