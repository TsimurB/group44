import driver.WebDriverProvider;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        WebDriverProvider.closeDriver();
    }

}
