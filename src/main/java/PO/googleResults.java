package PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googleResults {

    private WebDriver driver;

    @FindBy(id="resultStats")
    WebElement resultStatus;

    @FindBy(linkText="Relayr")
    WebElement results;

    public googleResults(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean ValidateResultStatus(){

        if ((Integer.parseInt(resultStatus.getText().split(" ")[1].replace(",", ""))) > 0)
            return true;
        else
            return false;
    }

    public void OpenLink(){
    	results.click();

    }
}
