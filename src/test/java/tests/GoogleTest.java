package tests;

import settings.DriverManager;
import settings.RunDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class GoogleTest {

    @Before
    public void startBrowser() {
        DriverManager.initWebDriver();
    }

    @Test
    public void openGoogleAndSearch() {
        WebDriver driver = RunDriver.getWebDriver();
        driver.get("https://www.google.com/");
        String currentURL = driver.getCurrentUrl();
        // verify that the webpage was opened: URL and title
        assertEquals(currentURL, "https://www.google.com/");
        assertTrue(driver.getTitle().contains("Google"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement googleSearchInputElem= wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input.gsfi")));

//        WebElement googleSearchInputElem = driver.findElement(By.cssSelector("input.gsfi"));
    }

    @After
    public void tearDown() {
        DriverManager.shutDownDriver();
    }
}
