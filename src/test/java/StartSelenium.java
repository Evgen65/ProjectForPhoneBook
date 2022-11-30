import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sound.sampled.AudioSystem;
import java.sql.SQLOutput;
import java.util.List;

public class StartSelenium extends TestBase {
    WebDriver wd;

    @BeforeMethod
    public void preCondition() {
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");

    }
    @Test
    public void testName() {
        System.out.println("test started");
        WebElement element = wd.findElement(By.tagName("a"));
        System.out.println(element.getLocation());

        List<WebElement> elements = wd.findElements(By.tagName("div"));
        System.out.println(elements.size());
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.partialLinkText("HO"));
        WebElement root = wd.findElement(By.id("root"));



        List<WebElement> button = wd.findElements(By.tagName("button"));


    }
    @Test
    public void testLogin() {
        //open login/reg form
        WebElement loginBtn = wd.findElement(By.xpath("//a[text()='LOGIN']"));
        loginBtn.click();
        //fill login/reg form

        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("abcd@mail.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Abcd1234S");

        wd.findElement(By.xpath("//button[1]")).click();

pause(3);
       Assert.assertTrue( wd.findElement(By.xpath("//a[@href='/add']"))!= null);



    }
    @AfterMethod
    public void postCondition() {
      //  wd.close();
      //  wd.quit();

    }


}
