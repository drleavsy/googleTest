package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import settings.BasePage;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class HomePage extends BasePage {

    @FindBy(how = How.CSS, using = "input[name='btnK']")
    @CacheLookup
    private WebElement button_search;

    @FindBy(how = How.CSS, using = "input.gsfi")
    @CacheLookup
    private WebElement searchInputField;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void enterTextToSearchField(String inputString){
        //Enter text to search field
        clickElement(searchInputField);
        writeText(searchInputField, inputString);
    }

    public void clickOnSearch(){
        //Click on Search button
        clickElement(button_search);
    }

    public void clickEnter() {
        searchInputField.sendKeys(Keys.RETURN);
    }

    public boolean isHomePageOpened() {
        String currentURL = driver.getCurrentUrl();
        // verify that the webpage was opened by testing URL and title
        assertEquals(currentURL, "https://www.google.com/");
        assertTrue(isWordPresentInTitle("google"));
        return true;
    }

}