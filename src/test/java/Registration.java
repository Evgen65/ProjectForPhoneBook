import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends TestBase {

    //    WebDriver wd;

   @ BeforeMethod
    public void precondition(){
       if(isLogged()){
           logout();
       }
   }

    private void logout() {
    }


    // }

    @Test
    public void testRegistrationPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mail.com";
        String password = "Abcd1234S";

        openLoginRegistration();
        fillLoginRegistrationForm(email, password);
        submitRegistration();
        pause(5);
        Assert.assertTrue(isElementPresent(By.xpath("//button")));

    }

    @Test
    public void registrationWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mail.com";
        String password = "Abcd1234S";
    }


    @AfterMethod
    public void postCondition() {
      //  wd.close();
        //  wd.quit();

    }
}