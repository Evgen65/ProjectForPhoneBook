import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddContactsTest extends TestBase {
WebDriver wd;
LoginTest test;
    @BeforeMethod
    public void preCondition() {
        test=new LoginTest();
        boolean noLogged = app.getUser().isNoLogged();
        test.testLoginPositive();
    }
    @Test
    public void AddContactTestPositive() {
            String name="Tyron";
            String lastName="Lancaster";
            String phoneNumber= "97251151175";
            String contEmail= "name45@mail.com";
            String address="Royal Street 112 second floor Haifa";
            String description="We met on vacation a couple of years ago.";
            app.getUser().openAddContactsForm();
            app.getUser().fillContactsForm(name,lastName,phoneNumber,contEmail,address,description);
            app.getUser().saveAddContactsForm();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/contacts']")));
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
        app.getUser().fillContactsForm(name, lastName, phoneNumber, contEmail, address, description);
        app.getUser().saveAddContactsForm();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/contacts']")));

    }
    @Test
    public void AddContactTestNegativePhone() {
        String name = "Tyron";
        String lastName = "Lancaster";
        String phoneNumber = "9725115";
        String contEmail = "name45@mail.com";
        String address = "Royal Street 112 second floor Haifa";
        String description = "We met on vacation a couple of years ago.";
        app.getUser().openAddContactsForm();
        app.getUser().fillContactsForm(name, lastName, phoneNumber, contEmail, address, description);
        app.getUser().saveAddContactsForm();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/contacts']")));
    }
}