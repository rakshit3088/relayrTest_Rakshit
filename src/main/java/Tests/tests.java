package Tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

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
    public void TestSearchGoogleAndVerifyNoOfResultsIsGtZero(){
    	
    	 int resCount=0;
        googleSearch gs = new googleSearch(driver);
        gs.enterSearchVal("relayr");
        gs.clickButton();

        googleResults gr = new googleResults(driver);
        String ResultStatus = gr.getResultStatus();
        
        if (ResultStatus.contains("not displayed")){
        	System.out.println(ResultStatus);
        	fail();
        }
        else {
        	resCount = Integer.parseInt(ResultStatus.split(" ")[1].replace(",", ""));
        	assertNotEquals(resCount,0);
        	assertTrue("Result Count", resCount > 0);
        }
    }
    
    @Test
    public void TestVerifyUserIsAbleToClickResultLinks(){
    	
        googleSearch gs = new googleSearch(driver);
        gs.enterSearchVal("rela33yr");
        gs.clickButton();

        googleResults gr = new googleResults(driver);
        String ResultStatus = gr.getResultStatus();
        
        if (ResultStatus.contains("not displayed")){
        	System.out.println(ResultStatus);
        	fail();
        }
        else {
        	gr.openLink();
        	assertThat(driver.getTitle(),containsString("relayr | Industrial IoT middleware platform | enabling business outcomes"));
        }
    }
    

    @After
    public void teardown(){
    	
    	driver.close();
    }
}
