import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RedditHomePage;

public class SmokeTests extends BaseTest {

    private final RedditHomePage redditHomePage = new RedditHomePage();


    @Test
    public void canNavigateToRedditHomePageTest() {
        redditHomePage
                .goToHomePage();
        Assert.assertTrue(redditHomePage.checkIfIsRedditHomePage(), "This is not a reddit.com !");
    }

    @Test
    public void canUseSearchBarForCustomQueries() {
        redditHomePage
                .goToHomePage()
                .useSearchBar()
                .makeSearchQuery();
        Assert.assertTrue(redditHomePage.checkIfSearchSucceed(), "Search failed!");
    }

}
