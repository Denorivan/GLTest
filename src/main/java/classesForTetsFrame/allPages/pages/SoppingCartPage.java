package classesForTetsFrame.allPages.pages;

import classesForTetsFrame.allPages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SoppingCartPage extends BasePage{
    public SoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private final By totalPrice = By.xpath("//span[@class=\"product-subtotal\"]");
    private final By chooseRemove = By.xpath("//input[@name=\"removefromcart\"]");
    private final By updateCart = By.xpath("//input[@name=\"updatecart\"]");
    private final By orderSummaryContent = By.xpath("//div[@class=\"order-summary-content\"]");


    public SoppingCartPage chooseRemoveClick(){
        driver.findElement(chooseRemove).click();

        return this;
    }
    public SoppingCartPage updateCartClick(){
        driver.findElement(updateCart).click();
        return this;
    }

    public SoppingCartPage checkIsShoppingCartIsEmpty(){
        WebElement element = driver.findElement(orderSummaryContent);
        String actualText = element.getText();
        Assert.assertTrue(actualText.contains("Your Shopping Cart is empty!"));
        return this;
    }

    public SoppingCartPage checkTheItemIsThereAndThePriceIsCorrect (){
        WebElement element = driver.findElement(totalPrice);
        String actualText = element.getText();
        String expectedText = "2105.00";
        Assert.assertEquals(actualText, expectedText);

        return this;
    }
}
