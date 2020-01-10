package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Actions;

public class HomePage {

    public HomePage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login")
    private WebElement signInButton;

    @FindBy (id = "search_query_top")
    private WebElement searchInput;

    @FindBy (className = "ac_results")
    private WebElement proposedlist;

    @FindBy (xpath = "//div[@class='ac_results']//li[1]")
    private WebElement pickedProductOnTheList;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    public void clickSignInButton(){

        Actions.click(signInButton,"SignIn Button");
    }
    public void clickSearchInput () {
        Actions.click(searchInput,"Search Input");
    }
    public void typeSearchInput(){
        Actions.type(searchInput, "dress", "Search Text Input");
    }
    public void proposedListisDisplayed (){
        Actions.elementIsDisplayed(proposedlist, "Proposed List Is Displayed");
    }
    public void clickPickedProduct(){
        Actions.click(pickedProductOnTheList, "Click The Picked Product");
    }
    public void clickSearchButton(){
        Actions.click(searchButton, "Click search button");
    }
}
