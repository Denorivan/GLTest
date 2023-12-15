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

    private final By fastProcessor = By.xpath("//input[@id=\"product_attribute_74_5_26_82\"]");
    private final By eightGB = By.xpath("//input[@id=\"product_attribute_74_6_27_85\"]");
    private final By firstSoftware = By.xpath("//input[@id=\"product_attribute_74_8_29_88\"]");
    private final By secondSoftware = By.xpath("//input[@id=\"product_attribute_74_8_29_89\"]");
    private final By thordSoftware = By.xpath("//input[@id=\"product_attribute_74_8_29_90\"]");
    private final By shoppingCard = By.xpath("//a[contains(text(),'shopping cart')]");




    public ItemPage clickFastProcessor(){
        driver.findElement(fastProcessor).click();
        return this;
    }
    public ItemPage clickFirstSoftware(){
        driver.findElement(firstSoftware).click();
        return this;
    }
    public ItemPage clickSecondSoftware(){
        driver.findElement(secondSoftware).click();
        return this;
    }
    public ItemPage clickThirdSoftware(){
        driver.findElement(thordSoftware).click();
        return this;
    }

    public ItemPage shoppingCardClick(){
        driver.findElement(shoppingCard).click();
        return this;
    }
    public ItemPage clickEightGB(){
        driver.findElement(eightGB).click();
        return this;
    }

    public ItemPage clickAddToCartButton(){
        waitElementIsVisible(driver.findElement(addToCartButton));
        driver.findElement(addToCartButton).click();
        return this;
    }
    public ItemPage clickAddToCartButtonWithRefresh(){
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
