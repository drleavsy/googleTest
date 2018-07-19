package testSuit;
import pages.homePage;
import pages.searchResultPage;
import settings.baseTest;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import static junit.framework.TestCase.assertTrue;

public class GoogleTest1 extends baseTest {

    @Test
    public void GoogleSearchAndVerifyTitle()  {
        String word = "automation";
        // get the instance of homePage object from Factory
        homePage homePageObj = PageFactory.initElements(driver, homePage.class);
        // enter word "automation" to search field and click on 'Search' button
        homePageObj.enterTextToSearchField(word);

        // get the instance of new page with results from Page factory
        searchResultPage SearchResObj = PageFactory.initElements(driver, searchResultPage.class);
        // open the 1st link on the search result page
        SearchResObj.clickOnFirstLink();
        // new search result is loaded after clicking the 1st link
        assertTrue(SearchResObj.isWordPresentInTitle(word));
    }

    @Test
    public void GoogleSearchAndVerifyUrlsContent()  {
        String word = "automation";
        // get the instance of homePage object from Factory
        homePage homePageObj = PageFactory.initElements(driver, homePage.class);
        // enter word "automation" to search field in google.com
        homePageObj.enterTextToSearchField(word);

        // count the number of http links with the word "automation"
        int matchLinkCount = 0;
        // verify if the word "automation" is present in each of the 5 result pages
        for(int i = 0; i < 5; i++)
        {
            // get the instance of new page with results from Page factory
            searchResultPage SearchResObj = PageFactory.initElements(driver, searchResultPage.class);
            // get the number of links with the word "automation" from the current page
            matchLinkCount = matchLinkCount + SearchResObj.verifyWordIsPresentInResultPage(word);
            // click 'Next' link in order to open the next page with search results
            SearchResObj.clickNextPageLink();
        }
        // verify that there was found at least one http link with word "automation" in result pages
        assertTrue(matchLinkCount > 0);
    }
}
