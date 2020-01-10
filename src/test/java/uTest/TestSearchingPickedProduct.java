package uTest;

import org.junit.Test;
import utils.BaseTest;

public class TestSearchingPickedProduct extends BaseTest {

    @Test
    public void searchingByProposedList(){
        homePage.clickSearchInput();
        homePage.typeSearchInput();
        homePage.proposedListisDisplayed();
        homePage.clickPickedProduct();
        printedSummerDressPage.titlePickedProductIsDisplayed();
    }

    @Test
    public void searchingByClickingButtonSearch(){
        homePage.clickSearchInput();
        homePage.typeSearchInput();
        homePage.clickSearchButton();
        resultSearchPage.titleSearchResultIsDisplayed();
    }
}
