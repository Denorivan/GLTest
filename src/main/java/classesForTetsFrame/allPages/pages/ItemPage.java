package classesForTetsFrame.allPages.pages;

import classesForTetsFrame.allPages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.manager.SeleniumManager;
import org.testng.Assert;

import java.time.Duration;

import static classesForTetsFrame.constants.Constant.TimeOutVariable.IMPLICIT_WAIT;

public class ItemPage extends BasePage {
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    private final By addToCartButton = By.xpath("(//input[@value=\"Add to cart\"])[1]");
    private final By checkNotion = By.xpath("//div[@id=\"bar-notification\"]/p");
    private final By amountInShoppingCart = By.xpath("//*[@class=\"cart-qty\"]");

    public ItemPage clickAddToCartButton(){
        waitElementIsVisible(driver.findElement(addToCartButton));
        driver.navigate().refresh();
        driver.findElement(addToCartButton).click();
        return this;
    }

    public ItemPage checkTheItemIsInTheShoppingCart(){
        WebElement element = driver.findElement(checkNotion);
        String actualText = element.getText();
        String expectedText = "The product has been added to your shopping cart";

        WebElement webElement = driver.findElement(amountInShoppingCart);
        String actualAmount = webElement.getText();
        String expectedAmount = "(1)";

        Assert.assertEquals(actualAmount, expectedAmount);
        Assert.assertEquals(actualText, expectedText);


        return this;
    }
}
