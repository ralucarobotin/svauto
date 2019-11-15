package uiPages;

import helpers.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class WishlistPage extends BasePage {

    private static final String URL_PATH = "/wishlist/";

    @FindBy(className = "page-title")
    private WebElement pageTitle;

    @FindBy(className = "woocommerce")
    private WebElement wishlistTable;

    @FindBy(className = "product-remove")
    private WebElement tableColumnRemove;

    @FindBy(className = "product-thumbnail")
    private WebElement tableColumnThumbnail;

    @FindBy(xpath = "//td[@class='product-name']")
    private WebElement tableColumnName;

    @FindBy(className = "product-price")
    private WebElement tableColumnPrice;

    @FindBy(className = "product-stock-status")
    private WebElement tableColumnStock;

    @FindBy(className = "product-add-to-cart")
    private WebElement tableColumnAddToCart;

    @FindBy(className = "remove_from_wishlist")
    private WebElement removeButton;

    @FindBy(className = "product_type_variable")
    private WebElement selectOptionsButton;

    @FindBy(className = "woocommerce-message")
    private WebElement removedmessage;

    @FindBy(xpath = "//tr[@id='yith-wcwl-row-1365']//td[@class='product-name']")
    private WebElement firstProductName;

    @FindBy(xpath = "//tr[@id='yith-wcwl-row-1497']//td[@class='product-name']")
    private WebElement secondProductName;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(pageTitle);
    }

    @Override
    public boolean isValid() {
        return areVisible(pageTitle);
    }

    public void clickRemoveButton() {
        Actions action = new Actions(driver);
        action.moveToElement(removeButton).perform();
        removeButton.click();
    }

    public void clickSelectOptionsButton() {
        selectOptionsButton.isDisplayed();
        waitForElementToAppear(selectOptionsButton);
        selectOptionsButton.click();
    }

    public void scrollToTable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", wishlistTable);
    }

    public void openWishlistUrl(){
        openUrl(String.format(BASE_URL + URL_PATH));
    }

    public String getWishlistProducts() { return WebElementHelper.getElementText(tableColumnName); }

    public String getFirstWishlistProduct() { return WebElementHelper.getElementText(firstProductName); }

    public String getSecondWishlistProduct() { return WebElementHelper.getElementText(secondProductName); }

    public boolean isRemovedMessageDisplayed() {
        waitForElementToAppear(removedmessage);
        return WebElementHelper.isElementDisplayed(removedmessage);
    }
}
