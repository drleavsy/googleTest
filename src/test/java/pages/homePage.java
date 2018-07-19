package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import settings.basePage;

public class homePage extends basePage {

    @FindBy(how = How.CSS, using = "input[name='btnK']")
    @CacheLookup
    private WebElement button_search;

    @FindBy(how = How.CSS, using = "input.gsfi")
    @CacheLookup
    private WebElement searchInputField;

    public homePage(WebDriver driver){
        super(driver);
    }

    public void enterTextToSearchField(String inputString){
        // Click on the search field
        clickElement(searchInputField);
        // Send keyboard keys to search field
        writeText(searchInputField, inputString);
        // Press Enter which presses the 'Search' button
        searchInputField.sendKeys(Keys.RETURN);
    }
}