package uiPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class CartPage extends BasePage {

    private static final String URL_PATH = "/cart";

    @FindBy(css = "a.checkout-button:nth-child(1)")
    protected WebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) { super(driver); }

    @Override
    protected boolean isCurrent() {
        super.isCurrent();
        return areVisible(proceedToCheckoutButton);
    }

    @Override
    protected boolean isValid() {
        super.isValid();
        return areVisible(proceedToCheckoutButton);
    }

    public void open(){
        openUrl(BASE_URL + URL_PATH);
    }

    public void proceedToCheckout() {
        waitForElementToAppear(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }
}
