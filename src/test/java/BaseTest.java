import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
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
        DriverSingleton.closeDriver();
        logger.info("end suite");
    }

    @AfterMethod
    public void failedTeardown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotMaker.captureScreenShot();
            DriverSingleton.closeDriver();
            logger.error("test fails. screenshot was placed at target/screenshots/");
        }
    }
}
