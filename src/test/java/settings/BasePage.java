package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    //Click Method
    protected void clickElement (WebElement element) {
        element.click();
    }

    //Write Text
    protected void writeText (WebElement element, String text) {
        element.sendKeys(text);
    }

    public boolean isWordPresentInTitle(String word){
        return driver.getTitle().toLowerCase().contains(word);
    }
}
