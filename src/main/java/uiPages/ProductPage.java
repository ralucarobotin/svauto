package uiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helpers.WebElementHelper;
import org.openqa.selenium.support.ui.Select;

import static helpers.WebElementHelper.areVisible;

public class ProductPage extends BasePage {

    private static final String URL_PATH = "/product/%s";

    @FindBy(className = "product-essential__description")
    private WebElement productDescriptionField;

    @FindBy(className = "product-essential__specification")
    private WebElement productSpecificationField;

    @FindBy(xpath = "//*[@id=\'pa_color\']/option[2]")
    private WebElement attributeColor;

    @FindBy(xpath = "//*[@id=\'pa_size\']/option[2]")
    private WebElement attributeSize;
/**
    @FindBy(id = "pa_color")
    private WebElement attributeColor;

    @FindBy(id = "pa_size")
    private WebElement attributeSize;
*/
    @FindBy(className = "woocommerce-message")
    private WebElement addedmessage;

    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    private WebElement addToCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        super.isCurrent();
        return areVisible(productDescriptionField, productSpecificationField);
    }

    @Override
    protected boolean isValid() {
        super.isValid();
        return areVisible(productDescriptionField, productSpecificationField);
    }

    /**
    Select color = new Select(attributeColor);
    color.selectByIndex(2);

    Select size = new Select(attributeSize);
    size.selectByIndex(2);
     */

    public void attributeSelector() {
        attributeColor.click();
        attributeSize.click();
    }

    public void addToCart() {
        waitForElementToAppear(addToCart);
        addToCart.click();
    }

    public void openProductUrl(String product){
        openUrl(String.format(BASE_URL + URL_PATH, product));
    }

    public boolean isAddedMessage() {
        return WebElementHelper.isElementDisplayed(addedmessage);
    }
}
