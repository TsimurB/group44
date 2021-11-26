import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RedditHomePage;

public class SmokeTests extends BaseTest {

	@Test
	public void shouldOpenRedditHomepage() {
		new RedditHomePage(driver).open();
		Assert.assertEquals(RedditHomePage.URL, driver.getCurrentUrl(),
						"Actual URL doesn't match the Reddit URL");
	}
}
