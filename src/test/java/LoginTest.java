import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        app.getUser().beLogOut();

    }

    @Test
    public void testLoginPositive() {
        User data = new User()
                .withEmail("abcd@mail.com")
                .withPassword("Abcd1234$");
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm("abcd@mail.com", "Abcd1234$");
        app.getUser().submitLogin();
        app.getUser().pause(3);

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/add']")));

    }

    @AfterMethod
    public void tearDown() {
        //  wd.close();
        //  wd.quit();

    }
}