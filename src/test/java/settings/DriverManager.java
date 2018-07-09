package settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\d.stoliar\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        RunDriver.setWebDriver(driver);
    }
    public static void shutDownDriver() {
        RunDriver.getWebDriver().quit();
    }
}
