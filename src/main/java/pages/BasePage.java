/**
 * An abstract page class to inherit page classes from.
 * Contains driver instance to pass further.
 * Contains set of custom methods to manipulate webelements.
 */

package pages;

import driver.WebDriverProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static util.CommonConstants.*;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage() {
        try {
            driver = WebDriverProvider.getWebDriverProvider().getDriver();
            System.out.println("LOG POINT- - - - - - - - - - - - - - - - - - - - - - - WebDriver OK");
        } catch (Exception e) {
            System.out.println("Driver issue!");
        }
    }

    public BasePage clickTo(WebElement element) {
        WebElement clicker = new WebDriverWait(driver, GLOBALTIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
        clicker.click();
        return this;
    }

    public BasePage pressEnter(WebElement element) {
        WebElement clicker = new WebDriverWait(driver, GLOBALTIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
        clicker.sendKeys(Keys.ENTER);
        return this;
    }

    public String waitForTextOf(WebElement element) {
        return new WebDriverWait(driver, GLOBALTIMEOUT)
                .until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public BasePage fillIn(WebElement element, String textToFillIn) {
        WebElement typeIn = new WebDriverWait(driver, GLOBALTIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
        clickTo(element);
        typeIn.sendKeys(textToFillIn);
        return this;
    }

}
