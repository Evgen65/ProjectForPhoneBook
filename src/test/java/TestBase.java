import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;
     public static String email;
     public static String password;

    @BeforeSuite
    public void preCondition() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/");
    }

    @AfterSuite
    public void tearDown() {
        //  wd.close();
        //  wd.quit();
    }

    public void pause(int time) {
        // wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void clic(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void openLoginRegistration() {
        clic(By.xpath("//a[text()='LOGIN']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);

    }
    //open login form
    public void submitLogin() {
        clic(By.xpath("//button[1]"));
    }
    //open reg form
    public void submitRegistration() {
        clic(By.xpath("//button[2]"));

    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;

}    public boolean isLogged() {
        return isElementPresent(By.xpath("locator"));
    }
    void logout() {
        WebElement signOut = wd.findElement(By.xpath("//button[text='Sign Out']"));
        if(signOut.getText().equals("Sign Out"))
        signOut.click();
    }
}





