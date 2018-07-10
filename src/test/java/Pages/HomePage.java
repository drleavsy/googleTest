package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import settings.BasePage;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class HomePage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "input[name='btnK']")
    @CacheLookup
    private WebElement button_search;

    @FindBy(how = How.CLASS_NAME, using = "input.gsfi")
    @CacheLookup
    private WebElement searchInputField;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void enterTextToSearchField(String inputString){
        //Enter text to search field
        searchInputField.click();
        searchInputField.sendKeys(inputString);
    }

    public void clickOnSearch(){
        //Click on Search button
        button_search.click();
    }

    public boolean isHomePageOpened() {
        String currentURL = getDriver().getCurrentUrl();
        // verify that the webpage was opened by testing URL and title
        assertEquals(currentURL, "https://www.google.com/");
        assertTrue(getDriver().getTitle().contains("Google"));
        return true;
    }

}