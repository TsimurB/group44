import driver.WebDriverProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import util.ScreenshotMaker;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger();

    @BeforeSuite(alwaysRun = true)
    public void markStart() {
        logger.info("start suite");
    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        WebDriverProvider.closeDriver();
        logger.info("end suite");
    }

    @AfterMethod
    public void failedTeardown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotMaker.captureScreenShot();
            WebDriverProvider.closeDriver();
            logger.error("test fails. screenshot was placed at target/screenshots/");
        }
        logger.info("end testcase");
    }
}
