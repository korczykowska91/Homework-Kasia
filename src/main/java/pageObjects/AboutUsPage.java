package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Actions;

public class AboutUsPage{

    public AboutUsPage(WebDriver driver){ PageFactory.initElements(driver, this);}

    @FindBy (xpath = "//h1[@class='page-heading bottom-indent']")
    private WebElement pageHeadingAboutUs;

    public void pageHeadingAboutUsIsDisplayed(){
        Actions.elementIsDisplayed(pageHeadingAboutUs, "Page Heading About Us");
    }
}
