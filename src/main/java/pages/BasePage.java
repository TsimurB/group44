/**
 * An abstract page class to inherit page classes from.
 * Contains driver instance to pass further.
 * Contains set of custom methods to manipulate webelements.
 */

package pages;

import driver.WebDriverProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger();
    private final Integer TIMEOUT = 5;


    public BasePage() {
        try {
            driver = WebDriverProvider.getDriver();
        } catch (Exception e) {
            logger.error("Driver issue!");
        }
        PageFactory.initElements(driver, this);
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
