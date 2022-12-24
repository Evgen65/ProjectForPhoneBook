import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (!app.getUser().isLogged()) {
            app.getUser().login(User.builder()
                    .email("abcd@mail.com")
                    .password("Abcd1234$")
                    .build());
        }
    }

    @Test
    public void removeOneContactPositive() {
        if (app.getContact().countOfContacts() > 0) {
            app.getContact().removeOneContact();
            int result = app.getContact().removeOneContact();
            Assert.assertEquals(result,-1);
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
