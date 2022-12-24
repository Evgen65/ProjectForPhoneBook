import models.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactsTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
           // app.getUser().pause(3);


        } else {
            app.getUser().openLoginRegistrationForm();
            app.getUser().fillLoginRegistrationForm("abcd@mail.com", "Abcd1234$");
            app.getUser().submitLogin();
            app.getUser().pause(3);
        }
    }

    @Test(invocationCount = 3)
    public void addNewContactPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact contact = Contact.builder()
                .name("Gregory" + i)
                .lastName("Pek" + i)
                .phoneNumber("055666777" + i)
                .contEmail("name" + i + "@mail.com")
                .address("Haifa, Allenby, " + i)
                .description("We met on the my offs.")
                .build();
        logger.info("AddContactTestPositive  with Name: " + contact.getName() + " Last Name: " + contact.getLastName() + " Phone Number :"
                + contact.getPhoneNumber() +
                " Contact Email : " + contact
                .getContEmail() + " Address : " + contact.getAddress() + " Description : " + contact.getDescription());

        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();

        Assert.assertTrue(
                app.getUser().getText(By.xpath("" +
                        "//div[@class='contact-item_card__2SOIM'][last()]//h3")).equals(contact.getPhoneNumber())
        );
    }


    @Test
    public void AddContactTestNegativeEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 360;
        Contact contact = Contact.builder()
                .name("Tyron" + i)
                .lastName("Lancaster" + i)
                .phoneNumber("9725115117" + i)
                .contEmail("name" + i + "mail.com")
                .address("Royal Street  Haifa" + i)
                .description("We met on vacation a couple of years ago.")
                .build();

        logger.info("AddContactTestNegative  with Name: " + contact.getName() + " Last Name: " + contact.getLastName() + " Phone Number :"
                + contact.getPhoneNumber() +
                " Contact Email : " + contact
                .getContEmail() + " Address : " + contact.getAddress() + " Description : " + contact.getDescription());
        app.getContact().openContactForm();
        // app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();
        app.getUser().pause(3);
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
