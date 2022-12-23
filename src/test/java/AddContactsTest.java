import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddContactsTest extends TestBase {
    WebDriver wd;

    @BeforeClass
    public void preCondition() {
        // test = new LoginTest();
        boolean noLogged = app.getUser().isNoLogged();
        app.getUser().testLoginPositive();
    }

    @Test
    public void AddContactTestPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 360;
        Contacts data = new Contacts()
                .withName("Tyron" + i)
                .withLastName("Lancaster" + i)
                .withPhoneNumber("9725115117" + i)
                .withContEmail("name" + i + "@mail.com")
                .withAddress("Royal Street  Haifa" + i)
                .withDescription("We met on vacation a couple of years ago.");
        logger.info("AddContactTestPositive  with Name: " + data.getName() + " Last Name: " + data.getLastName() + " Phone Number :"
                +data.getPhoneNumber() +
                " Contact Email : "+ data.getContEmail() + " Address : " + data.getAddress() + " Description : " + data.getDescription());
        app.getUser().openAddContactsForm();
        app.getUser().fillContactsForm("Tyron" + i, "Lancaster" + i, "9725115117"+i, "name" + i + "@mail.com", "Royal Street  Haifa" + i, "We met on vacation a couple of years ago.");
        app.getUser().saveAddContactsForm();
        app.getUser().pause(3);
        Assert.assertTrue(
                app.getUser().getText(By.xpath("" +
                        "//div[@class='contact-item_card__2SOIM'][last()]//h3")).equals(data.getPhoneNumber()));

    }
    @Test
    public void AddContactTestPositiveModels() {
        int i = (int) (System.currentTimeMillis() / 1000) % 360;
        Contacts data = new Contacts()
                .withName("Tyron" + i)
                .withLastName("Lancaster" + i)
                .withPhoneNumber("9725115117" + i)
                .withContEmail("name" + i + "@mail.com")
                .withAddress("Royal Street  Haifa" + i)
                .withDescription("We met on vacation a couple of years ago.");

        app.getUser().openAddContactsForm();
        app.getUser().fillContactsForm(data);
        app.getUser().saveAddContactsForm();
        app.getUser().pause(3);
        Assert.assertTrue(
                app.getUser().getText(By.xpath("" +
                        "//div[@class='contact-item_card__2SOIM'][last()]//h3")).equals(data.getPhoneNumber()));

    }

    @Test
    public void AddContactTestNegativeEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 360;
        Contacts data = new Contacts()
                .withName("Tyron" + i)
                .withLastName("Lancaster" + i)
                .withPhoneNumber("9725115117" + i)
                .withContEmail("name" + i + "mail.com")
                .withAddress("Royal Street  Haifa" + i)
                .withDescription("We met on vacation a couple of years ago.");
        logger.info("AddContactTestPositive  with Name: " + data.getName() + " Last Name: " + data.getLastName() + " Phone Number :" +data.getPhoneNumber() +
                " Contact Email :"+ data.getContEmail() + " Address :" + data.getAddress() + " Description :" + data.getDescription());
        app.getUser().openAddContactsForm();
        app.getUser().pause(3);
        app.getUser().fillContactsForm(data);
        app.getUser().saveAddContactsForm();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/contacts']")));
        app.getUser().pause(10);
        Assert.assertTrue(app.getUser().isAlertPresent());

    }


    @AfterClass
    public void tearDown() {
        //  wd.close();
        //  wd.quit();

    }
}
