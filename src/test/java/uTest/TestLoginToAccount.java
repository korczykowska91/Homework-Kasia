package uTest;

import org.junit.Test;
import utils.BaseTest;

public class TestLoginToAccount extends BaseTest {

    @Test
    public void loginToAccountUsingCorrectAddressEmailAndPassword(){
        homePage.clickSignInButton();
        authenticationPage.clickFiledAddressEmail();
        authenticationPage.enterAddressEmail("test-test@test.com");
        authenticationPage.clickFieldPassword();
        authenticationPage.enterPassword("qualitywizards");
        myAccountPage.checkPageHeadingMyAccountIsPresent();
    }

    @Test
    public void loginToAccountUsingCorrectAddressEmailAndIncorrectPassword(){
        homePage.clickSignInButton();
        authenticationPage.clickFiledAddressEmail();
        authenticationPage.enterAddressEmail("test-test@test.com");
        authenticationPage.clickFieldPassword();
        authenticationPage.enterPassword("quality2020");
        authenticationPage.incorrectPasswordIsDisplayed();
    }
}
