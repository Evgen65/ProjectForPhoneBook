import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
//    WebDriver wd;
//
//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
//
//    }

    @Test
    public void testLoginPositive() {
//        //open login/reg form
//        WebElement loginBtn = wd.findElement(By.xpath("//a[text()='LOGIN']"));
//        loginBtn.click();
//        //fill login/reg form
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abcd@mail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Abcd1234S");
//        // click on Login button
//        wd.findElement(By.xpath("//button[1]")).click();
//        // Assert
//pause(3);
//       Assert.assertTrue( wd.findElement(By.xpath("//a[@href='/add']"))!= null);
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mail.com";
        String password = "Abcd1234S";

        openLoginRegistration();
        fillLoginRegistrationForm(email, password);
        submitLogin();
        pause(5);
        Assert.assertTrue(isElementPresent(By.xpath("//button")));



    }
    @AfterMethod
    public void tearDown() {
      //  wd.close();
      //  wd.quit();

    }


}
