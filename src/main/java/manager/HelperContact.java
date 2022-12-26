package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    Logger logger = LoggerFactory.getLogger(HelperContact.class);

    public void openContactForm() {
        click(By.cssSelector("a[href='/add']"));
    }

    public void fillContactForm(Contact contact) {

        type(By.xpath("//input[1]"), contact.getName());
        type(By.xpath("//input[2]"), contact.getLastName());
        type(By.xpath("//input[3]"), contact.getPhoneNumber());
        type(By.xpath("//input[4]"), contact.getContEmail());
        type(By.xpath("//input[5]"), contact.getAddress());
        type(By.xpath("//input[6]"), contact.getDescription());

    }

    public void submitContactForm() {
        click(By.xpath("//div[@class='add_form__2rsm2']//button"));
    }

    public void isContactCreated() {
    }

    public int removeOneContact() {
        int countBefore = countOfContacts();
        logger.info("Number of contacts before is " + countBefore);
        String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
        logger.info("The deleted number is " + phone);
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
        pause(6500);
        int countAfter = countOfContacts();
        logger.info("Number of contacts after is " + countAfter);
        return countAfter-countBefore;

    }

    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
        int countBefore = countOfContacts();
        logger.info("Number of contacts before is " + countBefore);
        List<WebElement> contact = wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        Iterator<WebElement> contacts = contact.stream().iterator();
        while (contacts.hasNext()) {
            contacts.next().click();

            click(By.xpath("//button[.='Remove']"));
            int countAfter = countOfContacts();
            pause(1500);
            logger.info("Number of contacts after is " + countAfter);
        }
    }


}