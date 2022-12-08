import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddContactsTest extends TestBase {
    WebDriver wd;
  // LoginTest test;

    @BeforeClass
    public void preCondition() {
       // test = new LoginTest();
        boolean noLogged = app.getUser().isNoLogged();
        app.getUser().testLoginPositive();
    }

    @Test
    public void AddContactTestPositive() {
        int i=(int)(System.currentTimeMillis()/1000)%360;
        Contacts data=new Contacts()
        .withName("Tyron"+i)
                .withLastName("Lancaster"+i)
                .withPhoneNumber("9725115117"+i)
                .withContEmail("name"+i+"@mail.com")
                .withAddress("Royal Street  Haifa"+i)
                .withDescription("We met on vacation a couple of years ago.");

               app.getUser().openAddContactsForm();
        app.getUser().fillContactsForm("Tyron"+i, "Lancaster"+i, "name"+i+"@mail.com", "9725115117"+i, "Royal Street  Haifa"+i,"We met on vacation a couple of years ago.");
        app.getUser().saveAddContactsForm();
        app.getUser().pause(3);
        Assert.assertTrue(
                app.getUser().getText(By.xpath("" +
                        "//div[@class='contact-item_card__2SOIM'][last()]//h3")).equals("9725115117"+i));

    }

    @Test
    public void AddContactTestNegativeEmail() {
        String name = "Tyron";
        String lastName = "Lancaster";
        String phoneNumber = "97251151175";
        String contEmail = "name45mail.com";
        String address = "Royal Street 112 second floor Haifa";
        String description = "We met on vacation a couple of years ago.";
        app.getUser().openAddContactsForm();
        app.getUser().pause(3);
        app.getUser().fillContactsForm(name, lastName, phoneNumber, contEmail, address, description);
        app.getUser().saveAddContactsForm();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/contacts']")));

    }


    @AfterClass
        public void tearDown() {
            //  wd.close();
            //  wd.quit();

        }
    }
