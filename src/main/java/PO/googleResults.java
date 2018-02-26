package PO;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googleResults {
	
	private WebDriver driver;
	
    @FindBy(id="resultStats")
    WebElement resultCount;

    WebElement results;

    public googleResults(WebDriver driver){
    	this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String getResultStatus(){

    	try {
    		resultCount.isDisplayed();
            return resultCount.getText();
        } catch(NoSuchElementException e) {
            return "result count not displayed";
        }
    }

    public void openLink(){
    	results = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/h3/a"));
    	results.click();
    }
}
