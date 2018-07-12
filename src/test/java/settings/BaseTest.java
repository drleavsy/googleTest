package settings;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void testSetUp(){
        // Set path for chrome driver
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
        // Define chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-cache");
        // Create instance of chrome driver with defined options
        driver = new ChromeDriver(options);

        //All test and page classes will use this wait by default
        wait = new WebDriverWait(driver,10);

        driver.navigate().to("https://www.google.com/");
    }

    @After
    public void  testTearDown(){
        driver.close();
    }

}
