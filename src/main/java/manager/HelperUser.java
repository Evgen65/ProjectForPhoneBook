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

        return isElementPresent(By.xpath
                ("//button[text='Sign Out']"));
    }

    public void logout() {
        // WebElement signOut = wd.findElement(By.xpath("//button[text='Sign Out']"));
        click(By.xpath("//button[text='Sign Out']"));
    }


    public void openLoginRegistrationForm() {
        click(By.xpath
                ("//a[text()='LOGIN']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);

    }
}








