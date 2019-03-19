package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static helpers.Utilities.getPropertyFromAppProp;

public class ShoppingCardTest extends BaseTest {

    private LoginPage loginPage = null;
    private ShoppingCartPage shoppingCartPage = null;
    private MyAccountPage myAccountPage = null;
    private HeaderPage headerPage = null;

    @BeforeMethod
    void beforeMethod(){
        this.loginPage = new LoginPage(getDriver());
        this.shoppingCartPage = new ShoppingCartPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
        this.headerPage = new HeaderPage(getDriver());
    }

    @Test
    public void accessShoppingCartPage(){
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(getPropertyFromAppProp("email"), getPropertyFromAppProp("password"));

        this.myAccountPage.verify();
        this.headerPage.verify();
        this.headerPage.clickShoppingCart();

        this.headerPage.verify();
        this.shoppingCartPage.verify();
    }

}
