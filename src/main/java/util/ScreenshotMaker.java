package util;

import driver.WebDriverProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotMaker {

    public static void captureScreenShot() {
        String fileName = new Date().toString().replace(":", "_").replace(" ", "_");
        File src = ((TakesScreenshot) WebDriverProvider.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("target/screenshots/failed_" + fileName + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
