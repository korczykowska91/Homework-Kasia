package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Actions;

public class AuthenticationPage {

    public AuthenticationPage(WebDriver driver){ PageFactory.initElements(driver, this);}

    @FindBy (id= "email")
    private WebElement fieldaddressemail;

    @FindBy (id="passwd")
    private WebElement fieldpassword;

    @FindBy (xpath = "//p[@class='submit']//span[1]")
    private WebElement signinbuttontologin;

    @FindBy (xpath = "//body[@id='authentication']/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]")
    private WebElement incorrectpasswordinfo;

    public void clickFiledAddressEmail (){
        Actions.click(fieldaddressemail, " Field Address Email");
    }

    public void enterAddressEmail (String addressemail){
        Actions.type(fieldaddressemail, addressemail, "Address Email Text Input");
    }
    public void clickFieldPassword(){
        Actions.click(fieldpassword, "Field Password");
    }
    public void enterPassword (String password){
        Actions.type(fieldpassword, password, "Password Text Input");
    }
    public void clickSignInButtonToLogin(){
        Actions.click(signinbuttontologin, "SingIn Button To Login");
    }
    public void incorrectPasswordIsDisplayed(){
        incorrectpasswordinfo.isDisplayed();
    }
}
