import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {
    // WebDriver wd;
    public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

//        public void pause(int time) {
//            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        }

//        public void click(By locator) {
//            wd.findElement(locator).click();
//        }

//        public void type(By locator, String text) {
//            WebElement element = wd.findElement(locator);
//            element.click();
//            element.clear();
//            element.sendKeys(text);
//        }

//        public void openLoginRegistration() {
//            click(By.xpath("//a[text()='LOGIN']"));
//        }

//        public void fillLoginRegistrationForm(String email, String password) {
//            type(By.xpath("//input[1]"), email);
//            type(By.xpath("//input[2]"), password);
//
//        }
//        public void submitLogin() {
//            click(By.xpath("//button[1]"));
//        }
    //open reg form
//        public void submitRegistration() {
//            click(By.xpath("//button[2]"));

    //       }

//        public boolean isElementPresent(By locator) {
//            return wd.findElements(locator).size() > 0;
//
    //     }
//       public boolean isLogged() {
//
//            return isElementPresent(By.xpath("l//button[text='Sign Out']"));
//        }
//        void logout() {
//           // WebElement signOut = wd.findElement(By.xpath("//button[text='Sign Out']"));
//            click(By.xpath("//button[text='Sign Out']"));
//        }
}

