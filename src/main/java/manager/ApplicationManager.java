package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);

   // WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperContact contact;
    String browser;


    public void init() {
        //wd = new ChromeDriver();
        if(browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info(("Test on FIREFOX"));
        }else if(browser.equals(BrowserType.CHROME)){
            wd=new EventFiringWebDriver(new ChromeDriver());
            logger.info("Test on CHROME");
        }
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.register(new MyListener());
        wd.navigate().to("https://telranedu.web.app/");
        wd.manage().window().maximize();
        user = new HelperUser(wd);
        contact = new HelperContact(wd);
    }
    public void stop() {
        //  wd.close();
        //  wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }

    public HelperContact getContact() {
        return contact;
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
}
