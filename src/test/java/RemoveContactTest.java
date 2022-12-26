import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class RemoveContactTest extends TestBase {
    @BeforeClass
    public void preCondition() {
        if (!app.getUser().isLogged()) {
            app.getUser().login(User.builder()
                    .email("abcd@mail.com")
                    .password("Abcd1234$")
                    .build());
        }
       // app.getContact().pause(10);
    }

    @BeforeMethod
    public void addMissingContacts() {
        if (app.getContact().countOfContacts()==0) {
            int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            Contact contact = Contact.builder()
                    .name("Gregory" + i)
                    .lastName("Pek" + i)
                    .phoneNumber("055666777" + i)
                    .contEmail("name" + i + "@mail.com")
                    .address("Haifa, Allenby, " + i)
                    .description("We met on the my offs.")
                    .build();
            app.getContact().openContactForm();
            app.getContact().fillContactForm(contact);
            app.getContact().submitContactForm();
        }
    }

    @Test
    public void removeOneContactPositive() {
        if (app.getContact().countOfContacts() > 0) {
            app.getContact().removeOneContact();
            int result = app.getContact().removeOneContact();
           // Assert.assertEquals(result, -1);
        }
    }

    @Test
    public void removeAllContactsPositive() {
        if (app.getContact().countOfContacts() > 0) {
            app.getContact().removeAllContacts();
            Assert.assertTrue(app.getContact().isElementPresent(By.xpath("//h1[.=' No Contacts here!']")));
        }
    }


}
