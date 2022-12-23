package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends  HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }
    public void  openContactForm(){

    }
    public void fillContactForm(Contact contact){
        type(By.xpath("//input[@placeholder='Name']"),contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhoneNumber());
        type(By.xpath("//input[@placeholder='email']"), contact.getContEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
         type(By.xpath("//input[@placeholder='description']"), contact.getDescription());
       // type(By.xpath("//input[@placeholder='description']"), null);

    }
    public void submitContactForm(){

    }

}
