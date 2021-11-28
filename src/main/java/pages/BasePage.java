package pages;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
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

    public WebElement waitForElement(WebElement element) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public WebDriverWait waiter() {
        return new WebDriverWait(driver, TIMEOUT);
    }

    public BasePage waitForTextChange(String xPath, String checker) {
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
                wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(xPath), checker));
                return this;
    }

}
