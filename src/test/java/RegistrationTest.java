import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class RegistrationTest extends TestBase {


        //    WebDriver wd;

        @ BeforeMethod
        public void preCondition(){
            if(app.getUser().isLogged()){
               app.getUser().logout();
            }
        }

        @Test
        public void testRegistrationPositive() {
            int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            String email = "name" + i + "@mail.com";
            String password = "Abcd1234$";
            app.getUser().openLoginRegistrationForm();
            app.getUser().fillLoginRegistrationForm(email, password);
            app.getUser().submitRegistration();
            app.getUser().pause(3);



        }

        @Test
        public void registrationWrongEmail() {
            int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            String email = "name" + i + "mail.com";
            String password = "Abcd1234$";

            app.getUser().openLoginRegistrationForm();
            app.getUser().fillLoginRegistrationForm(email, password);
            app.getUser().submitRegistration();
            app.getUser().pause(3);
            Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));

        }


        @AfterMethod
        public void postCondition() {
            //  wd.close();
            //  wd.quit();

        }
    }



