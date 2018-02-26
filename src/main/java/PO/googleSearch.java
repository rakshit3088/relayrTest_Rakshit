package PO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googleSearch {
	
    @FindBy(name="btnK")
    WebElement searchButton;

    @FindBy(name="q")
    WebElement SearchTextBox;

    public googleSearch(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickButton(){
        searchButton.click();
    }

    public void enterSearchVal(String SearchVal){
        SearchTextBox.sendKeys(SearchVal);
    }
}
