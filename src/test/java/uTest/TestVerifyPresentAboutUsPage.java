package uTest;

import org.junit.Test;
import utils.BaseTest;

public class TestVerifyPresentAboutUsPage extends BaseTest {

    @Test

    public void verifyPresentAboutUsPageByPageHeading(){
        homePage.clickAboutUsButton();
        aboutUsPage.pageHeadingAboutUsIsDisplayed();
    }

}
