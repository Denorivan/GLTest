package classesForTetsFrame.allPages.pages;

import classesForTetsFrame.allPages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DesktopsPage extends BasePage {
    public DesktopsPage(WebDriver driver) {
        super(driver);
    }

    private final By displayPopupButton = By.xpath("//select[@id='products-pagesize']");
    private final By sortByPopupButton = By.xpath("//select[@id=\"products-orderby\"]");
    private final By displayPopup4ValueButton = By.xpath("//option[@value=\"https://demowebshop.tricentis.com/desktops?pagesize=4\"]");
    private final By sortByPopupValueButton = By.xpath("//option[contains(text(), 'Price: High to Low')]");
    private final By firstAddToCartItem = By.xpath("(//input[@value=\"Add to cart\"])[1]");

    public DesktopsPage choose4ElementsWouldBeDisplayedPerPage(){
        driver.findElement(displayPopupButton).click();
        driver.findElement(displayPopup4ValueButton).click();
        return this;
    }

    public DesktopsPage sortElementsByPriceHighToLow(){
        driver.findElement(sortByPopupButton).click();
        driver.findElement(sortByPopupValueButton).click();
        return this;
    }

    public DesktopsPage addToCardMostExpensiveItem(){
        driver.findElement(firstAddToCartItem).click();
        return this;
    }
}
