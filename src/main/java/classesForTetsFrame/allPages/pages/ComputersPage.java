package classesForTetsFrame.allPages.pages;

import classesForTetsFrame.allPages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputersPage extends BasePage {
    public ComputersPage(WebDriver driver) {
        super(driver);
    }

    public final By desktopsButton = By.xpath("//h2/a[@title='Show products in category Desktops']");

    public ComputersPage clickOnDesktopIconsButton(){
        driver.findElement(desktopsButton).click();
        return this;
    }
}
