package ui;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import uiPages.*;

import static helpers.Utilities.*;

public class submittingAnOrder extends BaseTest {
    /**
     * 1. Add to cart some items
     * 2. Place the order
     * 3. Complete the checkout
     * 4. Submit the order
     */

    private LoginPage loginPage = null;
    private ProductPage productPage = null;
    private CartPage cartPage = null;
    private CheckoutPage checkoutPage = null;

    @BeforeMethod
    public void BeforeMethod() {
        loginPage = new LoginPage(getDriver());
        productPage = new ProductPage(getDriver());
        cartPage = new CartPage(getDriver());
        checkoutPage = new CheckoutPage(getDriver());
    }

    @Test
    public void submittingAnOrder() {
        // open page and login
        loginPage.open();
        loginPage.login(getPropertyFromAppProp("emailValid"), getPropertyFromAppProp("passwordValid"));
        // add the products to cart
        for (int i = 1; i <= 3; i++) {
            productPage.openProductUrl(getPropertyFromProductsProp("product" + i));
            productPage.selectColor();
            productPage.selectSize();
            productPage.clickAddToCart();
        }
        // go to the cart and proceed to checkout
        cartPage.open();
        cartPage.proceedToCheckout();
        checkoutPage.fillInFirstName(getPropertyFromBillingProp("firstName"));
        checkoutPage.fillInLastName(getPropertyFromBillingProp("lastName"));
        checkoutPage.fillInBillingAddress(getPropertyFromBillingProp("billingAddress"));
        checkoutPage.fillInCity(getPropertyFromBillingProp("city"));
//        checkoutPage.fillInCounty(getPropertyFromBillingProp("county"));
        checkoutPage.fillInPostcode(getPropertyFromBillingProp("postcode"));
        checkoutPage.fillInPhone(getPropertyFromBillingProp("phone"));
        checkoutPage.checkInTerms();
        checkoutPage.placeOrder();

    }





}
