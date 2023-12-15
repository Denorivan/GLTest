package tests.base;

import classesForTetsFrame.allPages.base.BasePage;
import classesForTetsFrame.allPages.pages.*;
import classesForTetsFrame.common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import static classesForTetsFrame.common.Config.CLEAR_STORAGE;
import static classesForTetsFrame.common.Config.CLOSE_BROWSER;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);

    protected MainPage mainPage = new MainPage(driver);

    protected ComputersPage computersPage = new ComputersPage(driver);

    protected DesktopsPage desktopsPage = new DesktopsPage(driver);

    protected ItemPage itemPage = new ItemPage(driver);

    protected SoppingCartPage soppingCartPage = new SoppingCartPage(driver);

    @AfterTest
    public void clearCookLocalStorage(){
        if (CLEAR_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite
    public void close(){
        if (CLOSE_BROWSER){
            driver.close();
            driver.quit();
        }
    }
}
