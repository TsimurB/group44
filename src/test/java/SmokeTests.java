import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RedditHomePage;


public class SmokeTests extends BaseTest {

    private final RedditHomePage redditHomePage = new RedditHomePage();


    @Test
    public void canNavigateToRedditHomePageTest() {
        System.out.println("LOG POINT- - - - - - - - - - -Test 1: canNavigateToRedditHomePageTest");
        redditHomePage
                .goToHomePage();
        Assert.assertTrue(redditHomePage.checkIfIsRedditHomePage(), "This is not a reddit.com !");
    }

    @Test
    public void canUseSearchBarForCustomQueriesTest() {
        System.out.println("LOG POINT- - - - - - - - - - -Test 2: canUseSearchBarForCustomQueriesTest");
        redditHomePage
                .goToHomePage()
                .useSearchBar()
                .makeSearchQuery();
        Assert.assertTrue(redditHomePage.checkIfSearchSucceed(), "Search failed!");
    }

}
