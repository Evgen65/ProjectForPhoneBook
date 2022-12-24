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
        User data = User.builder()
                .email("abcd@mail.com")
                .password("Abcd1234$")
                .build();
        logger.info("TestloginPositive  with email: " + data.getEmail() + " pasword: " + data.getPassword());
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitLogin();
        app.getUser().pause(3);

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/add']")));

    }

    @Test
    public void testLoginNegativeEmail() {
        User data = User.builder()
                .email("abcdmail.com")
                .password("Abcd1234$")
                .build();

        logger.info("TestloginNegative  with email: " + data.getEmail() + " password: " + data.getPassword());
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitLogin();
        app.getUser().pause(3);
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

    @Test
    public void testLoginNegativePassword() {
        User data = User.builder()
                .email("abcd@mail.com")
                .password("Abcd")
                .build();
        logger.info("TestloginNegative  with email: " + data.getEmail() + " password: " + data.getPassword());
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitLogin();
        app.getUser().pause(3);
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @AfterMethod
    public void tearDown() {
        //  wd.close();
        //  wd.quit();

    }
}