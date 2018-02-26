package Tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PO.googleResults;
import PO.googleSearch;
import org.junit.Test;


public class tests {

    WebDriver driver;

    @Before
    public void setup(){
        //use FF Driver
        System.setProperty("webdriver.gecko.driver","Driver/geckodriver_3");
        driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void TestSearchGoogleForSelenium(){

        googleSearch gs = new googleSearch(driver);
        gs.enterSearchVal("Selenium");
        gs.clickButton();

        googleResults gr = new googleResults(driver);
        gr.ValidateResultStatus();
        gr.OpenLink();

    }

    @Test
    public void TestSearchGoogleFroRelayr(){

        googleSearch gs = new googleSearch(driver);
        gs.enterSearchVal("relayr");
        gs.clickButton();

        googleResults gr = new googleResults(driver);
        gr.ValidateResultStatus();
        gr.OpenLink();
    }

    @After
    public void teardown(){
    	
    	driver.close();
    }
}
