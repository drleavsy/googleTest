package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.BasePage;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class SearchResultPage extends BasePage {

    protected WebElement firstLinkElement;
    protected WebElement nextPageLinkElement;

    private String linksLoc = "h3 > a";
    private String allCiteLinks = "div.g div.s cite";
    private String nextPageLink = "div#foot a.pn";
    private String currPage = "table#nav td.cur";
    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public boolean verifyWordIsPresentOnPage(String word)
    {
        // get all web elements of the http links on the result page
        List<WebElement> listOfElements = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(allCiteLinks)));
        // get all web elements of page numbers
        WebElement currPageElem = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(currPage)));

        boolean result;
        // go through each link and verify if it contains the 'automation' word, if yes then print it out
        System.out.println("Current page" + currPageElem.getText());

        for (WebElement elem: listOfElements) {
            result = elem.getText().toLowerCase().contains(word);
            if(result){
                System.out.println(elem.getText());
            }
            else{
                return false;
            }
        }
        return true;
    }

    public void clickOnFirstLink(){
        //Click on 1st link
        firstLinkElement =  new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(linksLoc)));
        clickElement(firstLinkElement);
    }

    public void clickNextPageLink(){
        //Click on next link
        nextPageLinkElement =  new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(nextPageLink)));
        clickElement(nextPageLinkElement);
    }
}
