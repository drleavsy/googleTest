package testSuit;

import Pages.HomePage;

import Pages.SearchResultPage;
import settings.BaseTest;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class GoogleTest1 extends BaseTest{

    @Test
    public void GoogleSearchAndVerifyTitle()  {
        // get the instance of HomePage object from Factory
        HomePage HomePageObj = PageFactory.initElements(driver, HomePage.class);
        // check if proper page was opened
        assertTrue(HomePageObj.isHomePageOpened());
        // enter word to search
        String word = "automation";
        HomePageObj.enterTextToSearchField(word);
        // click on 'Search' button
        HomePageObj.clickEnter();

        // new search result is loaded after clicking the 1st link
        SearchResultPage SearchResObj = PageFactory.initElements(driver, SearchResultPage.class);
        // open the 1st link on the search result page
        SearchResObj.clickOnFirstLink();
        assertTrue(SearchResObj.isWordPresentInTitle(word));
    }

    @Test
    public void GoogleSearchAndVerifyUrlsContent()  {
        // get the instance of HomePage object from Factory
        HomePage HomePageObj = PageFactory.initElements(driver, HomePage.class);
        // check if proper page was opened
        assertTrue(HomePageObj.isHomePageOpened());
        // enter word to search
        String word = "automation";
        HomePageObj.enterTextToSearchField(word);
        // click on 'Search' button
        HomePageObj.clickEnter();

        // new search result is loaded after clicking the 1st link
        SearchResultPage SearchResObj = PageFactory.initElements(driver, SearchResultPage.class);
        // verify if the word "automation" is present in each of 5 result pages
        for(int i = 0; i < 5; i++) {
            // verify the current page with results
            assertTrue(SearchResObj.verifyWordIsPresentOnPage(word));
            //click on next button
            SearchResObj.clickNextPageLink();
        }
    }

}
