import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
   @BeforeMethod
    public void precondition(){
   if(isLogged()){
           logout();
     }
   }
    @Test
    public void testLoginPositive() {
       String email = "abcd@mail.com";
        String password = "Abcd1234$";
       // email=Registration.email;
      //  password=Registration.password;

        openLoginRegistration();
        fillLoginRegistrationForm(email, password);
        submitLogin();
        pause(10);
        Assert.assertNotNull(wd.findElement(By.xpath("//a[@href='/add']")));
    }
    @AfterMethod
    public void tearDown() {
      //  wd.close();
      //  wd.quit();

    }
}
