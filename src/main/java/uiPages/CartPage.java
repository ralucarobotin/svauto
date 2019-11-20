package uiPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    private static final String URL_PATH = "/cart";

    @FindBy(css = "a.checkout-button:nth-child(1)")
    protected WebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) { super(driver); }

    public void open(){
        openUrl(BASE_URL + URL_PATH);
    }

    public void proceedToCheckout() {
        waitForElementToAppear(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }
}
