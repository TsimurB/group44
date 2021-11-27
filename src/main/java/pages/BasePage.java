/**
 * An abstract page class to inherit page classes from.
 * Contains driver instance to pass further.
 * Contains set of custom methods to manipulate webelements.
 */

package pages;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    protected WebDriver driver;
    protected JavascriptExecutor js;
    private static final Logger logger = LogManager.getLogger();
    private final Integer TIMEOUT = 5;


    public BasePage() {
        try {
            driver = DriverSingleton.getDriver();
            js = (JavascriptExecutor) driver;
        } catch (Exception e) {
            logger.error("Driver issue!");
        }
        PageFactory.initElements(driver, this);
    }

    public BasePage scrollToView(WebElement element) {
        (js).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public BasePage switchFrame(WebElement element) {
        scrollToView(element);
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        return this;
    }

    public BasePage clickIn(WebElement element) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
        return this;
    }

    public BasePage pressEnter(WebElement element) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element))
                .sendKeys(Keys.ENTER);
        return this;
    }

    public BasePage fillIn(WebElement element, String textToFillIn) {
        WebElement typeIn = new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
        clickIn(element);
        typeIn.sendKeys(textToFillIn);
        return this;
    }

    public String waitForTextOf(WebElement element) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element)).getText();
    }

}
