import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    //    WebDriver wd;

    @BeforeMethod
    public void preCondition() {
        app.getUser().beLogOut();
    }

    @Test
    public void testRegistrationPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = new User()
                .withEmail("name" + i + "@mail.com")
                .withPassword("Abcd1234$");
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
        User data = new User()
                .withEmail("name" + i + "mail.com")
                .withPassword("Abcd1234$");
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
        User data = new User()
                .withEmail("name" + i + "mail.com")
                .withPassword("Abcd1234$");
        app.getUser().openLoginRegistrationForm();
        //  app.getUser().fillLoginRegistrationForm("name" + i + "mail.com", "Abcd1234$");
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();
        app.getUser().pause(3);
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
    }
    @AfterMethod
    public void postCondition() {
        //  wd.close();
        //  wd.quit();

    }
}



