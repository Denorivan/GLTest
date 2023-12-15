package tests.secondTest;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static classesForTetsFrame.constants.Constant.UrlVariable.BUILD_COMPUTER_PAGE;
import static classesForTetsFrame.constants.Constant.UrlVariable.MAIN_PAGE;

public class SecondTest extends BaseTest {


    @Test
    public void firstTestInTask(){
        basePage.open(BUILD_COMPUTER_PAGE);

        itemPage

                .clickFastProcessor()
                .clickEightGB()

                .clickFirstSoftware()
                .clickSecondSoftware()
                .clickThirdSoftware()

                .clickAddToCartButton()
                .checkTheItemIsInTheShoppingCart()
                .shoppingCardClick();

        soppingCartPage
                .checkTheItemIsThereAndThePriceIsCorrect()
                .chooseRemoveClick()
                .updateCartClick()
                .checkIsShoppingCartIsEmpty();

    }
}
