package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class ProductTest extends BaseTest{

    private LoginPage loginPage = null;
    private ShoppingCartPage shoppingCartPage = null;
    private MyAccountPage myAccountPage = null;
    private HeaderPage headerPage = null;
    private ProductPage productPage = null;
    private ProductAddedLayoverPage productAddedLayoverPage = null;

    @BeforeMethod
    void beforeMethod(){
        this.loginPage = new LoginPage(getDriver());
        this.shoppingCartPage = new ShoppingCartPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
        this.headerPage = new HeaderPage(getDriver());
        this.productPage = new ProductPage(getDriver());
        this.productAddedLayoverPage = new ProductAddedLayoverPage(getDriver());
    }

    @Test
    public void accessProductPage(){
        this.productPage.open();
        this.productPage.verify();
    }

    @Test
    public void addProductToCart(){
        this.productPage.open();
        this.productPage.verify();
        this.productPage.addProductToCart();

        this.productAddedLayoverPage.verify();
        Assert.assertEquals(this.productAddedLayoverPage.getProductAddedConfirmationMessage(), "Product successfully added to your shopping cart");
    }

    @Test
    public void addProductToCartReturnToShopping(){
        this.productPage.open();
        this.productPage.verify();
        this.productPage.addProductToCart();
        this.productAddedLayoverPage.verify();

        this.productAddedLayoverPage.returnToShopping();
        this.productPage.verify();
    }

    @Test
    public void addProductToCartContinueToCheckout(){
        this.productPage.open();
        this.productPage.verify();
        this.productPage.addProductToCart();
        this.productAddedLayoverPage.verify();

        this.productAddedLayoverPage.continueToCheckout();
        this.shoppingCartPage.verify();
    }
}
