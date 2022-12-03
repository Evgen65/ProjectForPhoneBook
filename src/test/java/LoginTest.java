import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest<T> extends TestBase {

  @BeforeMethod
  public void preCondition(){
   app.getUser().beLogOut();
  }

  @Test
  public void testLoginPositive() {
   String email = "abcd@mail.com";
   String password = "Abcd1234$";

      app.getUser().openLoginRegistrationForm();
      app.getUser().fillLoginRegistrationForm(email, password);
      app.getUser().submitLogin();
      app.getUser().pause(3);
      Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/add']")));
     // app.getUser().testLoginPositive();
  }
  @AfterMethod
  public void tearDown() {
   //  wd.close();
   //  wd.quit();

  }
 }