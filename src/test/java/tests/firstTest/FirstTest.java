package tests.firstTest;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static classesForTetsFrame.constants.Constant.UrlVariable.MAIN_PAGE;

public class FirstTest extends BaseTest {


    @Test
    public void firstTestInTask(){
        basePage.open(MAIN_PAGE);

        mainPage
                .clickOnComputerButton();

        computersPage
                .clickOnDesktopIconsButton();

        desktopsPage
                .choose4ElementsWouldBeDisplayedPerPage()
                .sortElementsByPriceHighToLow()
                .addToCardMostExpensiveItem();

        itemPage
                .clickAddToCartButton()
                .checkTheItemIsInTheShoppingCart();

    }
}
