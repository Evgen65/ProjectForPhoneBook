import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class RemoveContactTest extends TestBase {
    @BeforeClass(alwaysRun = true)
    public void preCondition() {
        if (!app.getUser().isLogged()) {
            app.getUser().login(User.builder()
                    .email("abcd@mail.com")
                    .password("Abcd1234$")
                    .build());
        }
        app.getContact().pause(2000);
    }

    @BeforeMethod(alwaysRun = true)
    public void addContactsBeforeRemove() {
        for (int i = 0; i < 3; i++) {
            int a = (int) (System.currentTimeMillis() / 1000) % 3600;
            Contact contact = Contact.builder()
                    .name("Gregory" + a)
                    .lastName("Pek" + a)
                    .phoneNumber(a + "6777" + a)
                    .contEmail("name" + a + "@mail.com")
                    .address("Haifa, Allenby, " + a)
                    .description("We met on the my offs.")
                    .build();
            app.getContact().openContactForm();
            app.getContact().fillContactForm(contact);
            app.getContact().submitContactForm();
            app.getContact().pause(1500);
        }
    }

    @Test(groups = {"positivegroup", "smokegroup"})
    public void removeOneContactPositive() {
        if (app.getContact().countOfContacts() > 0) {
            int result = app.getContact().removeOneContact();
            Assert.assertEquals(result, -1);
            app.getUser().pause(1500);
        }
    }

    @Test(groups = {"positivegroup", "smokegroup"})
    public void removeAllContactsPositive() {
        if (app.getContact().countOfContacts() > 0) {
            app.getContact().removeAllContacts();
            Assert.assertTrue(app.getContact().isElementPresent(By.xpath("//h1[.=' No Contacts here!']")));
        }
    }
}
