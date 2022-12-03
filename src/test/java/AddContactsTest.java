import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactsTest extends TestBase {
WebDriver wd;
    @BeforeMethod
    public void preCondition() {
        boolean noLogged = app.getUser().isNoLogged();
        app.getUser().testLoginPositive();
    }
    @Test
    public void AddContactTest() {
            String name="Tyron";
            String lastName="Lancaster";
            String phoneNumber= "19719414175";
            String contEmail= "name45@mail.com";
            String address="Royal Street 112 second floor Haifa";
            String description="We met on vacation a couple of years ago.";
            app.getUser().openAddContactsForm();
            app.getUser().fillContactsForm(name,lastName,phoneNumber,contEmail,address,description);
            app.getUser().saveAddContactsForm();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/contacts']")));
    }
}