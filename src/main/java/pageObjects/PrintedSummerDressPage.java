package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Actions;

public class PrintedSummerDressPage {

    public PrintedSummerDressPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='breadcrumb clearfix']")
    private WebElement titlePickedProduct;

    public void titlePickedProductIsDisplayed(){
        Actions.elementIsDisplayed(titlePickedProduct, "Title of Picked Product");
    }
}
