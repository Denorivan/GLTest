package classesForTetsFrame.allPages.pages;

import classesForTetsFrame.allPages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By computersButton = By.xpath("(//a[@href='/computers'])[1]");

    public MainPage clickOnComputerButton(){
        driver.findElement(computersButton).click();
        return this;
    }

}
