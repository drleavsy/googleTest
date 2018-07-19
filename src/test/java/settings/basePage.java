package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class basePage {

    protected WebDriver driver;
    // Constructor
    public basePage(WebDriver driver){
        this.driver = driver;
    }

    // Click webelement
    protected void clickElement (WebElement element) {
        element.click();
    }

    // Write Text to webelement
    protected void writeText (WebElement element, String text) {
        element.sendKeys(text);
    }
    // Get title text from webpage and compare with input string
    public boolean isWordPresentInTitle(String word){
        return driver.getTitle().toLowerCase().contains(word);
    }
}
