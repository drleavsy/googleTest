package settings;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public WebDriver driver;

//    public BaseTest(){
//        System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized", "--disable-cache");
//
//        driver = new ChromeDriver(options);
//    }

    @BeforeClass
    public void testSetUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-cache");

        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.google.com/");
    }

    @AfterClass
    public void testTearDown(){
        driver.close();
    }

}
