package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final int TIMEOUT = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
        PageFactory.initElements(driver, this);
        waitForPageToLoad();
    }

    public abstract void waitForPageToLoad();

    protected void waitForElementToAppear(final WebElement element){
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToDisappear(final By locator) {
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}