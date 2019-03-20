package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class ProductAddedLayoverPage extends BasePage {

    @FindBy(xpath = "//span[contains(@title,'Continue shopping')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//span[@title='Close window']")
    private WebElement closeShoppingCartLayer;

    @FindBy(className = "ajax_cart_product_txt")
    private WebElement cartProductText;

    @FindBy(xpath = "//div[contains(@class,'layer_cart_product col-xs-12 col-md-6')]//h2[1]")
    private WebElement productAddedConfirmationMessage;


    public ProductAddedLayoverPage(WebDriver driver){
        super(driver);
    }

    public boolean isCurrent(){
        return areVisible(continueShoppingButton);
    }

    public boolean isValid(){
        return areVisible(continueShoppingButton, proceedToCheckoutButton, closeShoppingCartLayer, cartProductText, productAddedConfirmationMessage);
    }

    public String getProductAddedConfirmationMessage(){
        return productAddedConfirmationMessage.getText();
    }

    public void returnToShopping(){
        this.continueShoppingButton.click();
    }

    public void continueToCheckout(){
        this.proceedToCheckoutButton.click();
    }

}
