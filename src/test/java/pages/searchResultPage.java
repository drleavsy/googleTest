package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.basePage;

import java.util.List;

public class searchResultPage extends basePage {

    @FindBy(how = How.CSS, using = "div#foot a[class='pn'][id=\"pnnext\"]")
    @CacheLookup
    private WebElement nextPageLink;

    @FindBy(how = How.CSS, using = "div.g div.rc h3 > a")
    @CacheLookup
    private WebElement firstLinkLoc;


    public searchResultPage(WebDriver driver){
        super(driver);
    }

    public int verifyWordIsPresentInResultPage(String word)
    {
        // count http links which contains the word "automation"
        int countMatches = 0;

        List<WebElement> listOfElementsLinks = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class=\"med\"][id=\"res\"] cite")));

        for (WebElement elem : listOfElementsLinks) {
            if (elem.getText().toLowerCase().contains(word)) {
                // increase match counter if word "automation" was found in domain name
                countMatches++;
            }
        }
        return countMatches;
    }

    public void clickOnFirstLink(){
        //Click on 1st link
        WebElement firstLinkElement =  new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(firstLinkLoc));
        clickElement(firstLinkElement);
        // wait until the new page is loaded after clicking 1st link
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body div")));
    }

    public void clickNextPageLink(){
        //Click on next link
        WebElement nextPageLinkElement =  new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(nextPageLink));
        clickElement(nextPageLinkElement);
    }
}
