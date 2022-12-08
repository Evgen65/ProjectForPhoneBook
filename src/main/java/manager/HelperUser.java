package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));

    }

    public boolean isLogged() {

        return isElementPresent(By.xpath("//button[text='Sign Out']"));
    }

    public boolean isNoLogged() {
        isElementPresent(By.xpath("//button[text='Sign Out']"));
        return false;
    }

    public void logout() {
        // WebElement signOut = wd.findElement(By.xpath("//button[text='Sign Out']"));
        click(By.xpath("//button[text='Sign Out']"));
    }


    public void openLoginRegistrationForm() {
        click(By.xpath("//a[text()='LOGIN']"));
    }

    public void openAddContactsForm() {
        click(By.xpath("//a[@href='/add']"));

    }

    public void saveAddContactsForm() {
        click(By.xpath("(//button)[2]"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);

    }

    public void fillContactsForm(String name, String lastName, String phoneNumber, String contEmail, String address, String description) {
        type(By.xpath("//input[@placeholder='Name']"), name);
        type(By.xpath("//input[@placeholder='Last Name']"), lastName);
        type(By.xpath("//input[@placeholder='Phone']"), phoneNumber);
        type(By.xpath("//input[@placeholder='email']"), contEmail);
        type(By.xpath("//input[@placeholder='Address']"), address);
        type(By.xpath("//input[@placeholder='description']"), description);
    }

    public void testLoginPositive() {
        String email = "abcd@mail.com";
        String password = "Abcd1234$";

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLogin();
        pause(3);
    }

    public void beLogOut() {
        if (isLogged()) {
            logout();
        }
    }

    public String getText(By locator) {
        return wd.findElement(locator).getText();
    }

}









