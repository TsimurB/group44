import org.testng.annotations.Test;
import pages.RedditHomePage;

public class SmokeTests extends BaseTest {

    private final RedditHomePage redditHomePage = new RedditHomePage();


    @Test
    public void canNavigateToRedditHomePageTest() {
        redditHomePage.goToHomePage();
    }

    @Test
    public void canUseSearchBarForCustomQueries() {
        redditHomePage
                .goToHomePage()
                .useSearchBar()
                .makeSearchQuery();
    }

}
