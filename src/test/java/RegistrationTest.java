import manager.NGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

//@Listeners(NGListener.class)

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void preCondition() {

        app.getUser().beLogOut();
    }

    @Test(invocationCount = 1)
    public void testRegistrationPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = User.builder()
                .email(+i+"@mail.com")
                .password("Abcd" +i+"$")
                .build();

     //   logger.info("registrationPositiveTest with email: " + data.getEmail() + " pasword: " + data.getPassword());

        app.getUser().openLoginRegistrationForm();
        // app.getUser().fillLoginRegistrationForm("name" + i + "mail.com", "Abcd1234$");
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

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
        app.getUser().returnToHome();

    }

    @Test
    public void registrationWrongExistUser() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = User.builder()
                .email("abcd@mail.com")
                .password("Abcd1234")
                .build();

     //   logger.info("registrationNegativeTest with email: " + data.getEmail() + " pasword: " + data.getPassword());

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();
        app.getUser().pause(3);
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        app.getUser().pause(10);
        Assert.assertTrue(app.getUser().isAlertPresent());
        app.getUser().returnToHome();

    }


    @AfterMethod
    public void postCondition() {
        //  wd.close();
        //  wd.quit();

    }
}



