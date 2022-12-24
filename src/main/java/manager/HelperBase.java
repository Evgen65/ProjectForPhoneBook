package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void pause(int time) {
            wd.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

    }

    public String getText(By locator) {
        return wd.findElement(locator).getText();
    }

    public void returnToHome() {
        wd.navigate().to
                ("https://telranedu.web.app/home");
    }

    public void takeScreenShot(String link) {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(link);

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


