package testSuit;

import Pages.HomePage;

import settings.BaseTest;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class GoogleTest1 extends BaseTest{

    @Test
    public void openGoogleAndSearch()  {

//        WebDriver driver = new HomePage(driver);

        HomePage HomePageObj = PageFactory.initElements(driver, HomePage.class);
        // check if proper page was opened
        assertTrue(HomePageObj.isHomePageOpened());
        // enter word to search
        String word = "automation";
        HomePageObj.enterTextToSearchField(word);
        // click on 'Search' button
        HomePageObj.clickOnSearch();
    }

}
