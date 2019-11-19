package ui;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import uiPages.LoginPage;
import uiPages.ProductPage;

import static helpers.Utilities.getPropertyFromAppProp;

public class submittingAnOrder extends BaseTest {
    /**
     * 1. Add to cart some items
     * 2. Place the order
     * 3. Complete the checkout
     * 4. Submit the order
     */

    @BeforeTest
    public void BeforeMethod() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.login(getPropertyFromAppProp("emailValid"), getPropertyFromAppProp("passwordValid"));
    }





}
