import manager.DataProviderAddContact;
import models.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactsTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getUser().isLogged()) {
            // app.getUser().pause(3);
        } else {
            app.getUser().openLoginRegistrationForm();
            app.getUser().fillLoginRegistrationForm("abcd@mail.com", "Abcd1234$");
            app.getUser().submitLogin();
            app.getUser().pause(2500);
        }
    }

    @Test(invocationCount = 1, groups = {"positivegroup", "smokegroup"}, dataProvider = "addContactDto", dataProviderClass = DataProviderAddContact.class)
    public void addNewContactPositiveTest(Contact contact) {
        logger.info("AddContactTestPositive  with Name: " + contact.getName()
                + " Last Name: " + contact.getLastName() + " Phone Number :"
                + contact.getPhoneNumber() +
                " Contact Email : " + contact
                .getContEmail() + " Address : " + contact.getAddress() + " Description : " + contact.getDescription());
        app.getContact().countOfContacts();
        int countBefore = app.getContact().countOfContacts();
        logger.info("Number of contacts before is " + countBefore);
        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().pause(1000);
        app.getContact().submitContactForm();
        app.getContact().pause(2000);
        int countAfter = app.getContact().countOfContacts();
        logger.info("Number of contacts after is " + countAfter);
        Assert.assertTrue(
                app.getUser().getText(By.xpath("" +
                        "//div[contains(@class,'contact-page_leftdiv__yhyke')]")).contains(contact.getPhoneNumber())
        );

    }
    @Test(invocationCount = 1, groups = {"positivegroup", "smokegroup"}, dataProvider = "myDPFile", dataProviderClass = DataProviderAddContact.class)
    public void addNewContactPositiveTestFile(Contact contact) {
        logger.info("AddContactTestPositive  with Name: " + contact.getName()
                + " Last Name: " + contact.getLastName() + " Phone Number :"
                + contact.getPhoneNumber() +
                " Contact Email : " + contact
                .getContEmail() + " Address : " + contact.getAddress() + " Description : " + contact.getDescription());
        app.getContact().countOfContacts();
        int countBefore = app.getContact().countOfContacts();
        logger.info("Number of contacts before is " + countBefore);
        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().pause(1000);
        app.getContact().submitContactForm();
        app.getContact().pause(2000);
        int countAfter = app.getContact().countOfContacts();
        logger.info("Number of contacts after is " + countAfter);
        Assert.assertTrue(
                app.getUser().getText(By.xpath("" +
                        "//div[contains(@class,'contact-page_leftdiv__yhyke')]")).contains(contact.getPhoneNumber())
        );
    }
    @Test
    public void AddContactTestNegativeEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 360;
        Contact contact = Contact.builder()
                .name("Tyron" + i)
                .lastName("Lancaster" + i)
                .phoneNumber(i + "15117" + i)
                .contEmail("name" + i + "mail.com")
                .address("Royal Street  Haifa" + i)
                .description("We met on vacation a couple of years ago.")
                .build();

        logger.info("AddContactTestNegative  with Name: " + contact.getName() + " Last Name: "
                + contact.getLastName() + " Phone Number :"
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
