package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Actions;

public class ResultSearchPage {

    public ResultSearchPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//h1[contains(@class,'product-listing')]")
    private WebElement titleSearchResult;

    public void titleSearchResultIsDisplayed(){
        Actions.elementIsDisplayed(titleSearchResult, "Search Result Title Is Displayed");
    }
}
