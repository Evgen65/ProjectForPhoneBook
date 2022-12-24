import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        app.getUser().beLogOut();
    }

    @Test
    public void testRegistrationPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = User.builder()
                .email("name" + 1+"@mail.com")
                .password("Abcd1234$")
                .build();

        logger.info("registrationPositiveTest with email: " + data.getEmail() + " pasword: " + data.getPassword());

        app.getUser().openLoginRegistrationForm();
        // app.getUser().fillLoginRegistrationForm("name" + i + "mail.com", "Abcd1234$");
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();
        app.getUser().pause(3);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
        //  Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void registrationWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = User.builder()
                .email("name" + 1+"mail.com")
                .password("Abcd1234$")
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm("name" + i + "mail.com", "Abcd1234$");
        app.getUser().submitRegistration();
        app.getUser().pause(3);
        //   Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

    @Test
    public void registrationWrongEmailModel() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = User.builder()
                .email("name" + 1+"mail.com")
                .password("Abcd")
                .build();

        logger.info("registrationNegativeTest with email: " + data.getEmail() + " pasword: " + data.getPassword());

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();
        app.getUser().pause(3);
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        app.getUser().pause(10);
        Assert.assertTrue(app.getUser().isAlertPresent());

    }


    @AfterMethod
    public void postCondition() {
        //  wd.close();
        //  wd.quit();

    }
}



