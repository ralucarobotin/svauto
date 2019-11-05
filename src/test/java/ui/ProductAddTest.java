package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uiPages.LoginPage;
import uiPages.ProductPage;

import static helpers.Utilities.getPropertyFromAppProp;

public class ProductAddTest extends BaseTest {

    private ProductPage productPage = null;

    private String specificProduct;

    public ProductAddTest() {
        this.specificProduct = getPropertyFromAppProp("product1");
    }

    @BeforeMethod
    void beforeMethod() {
        this.productPage = new ProductPage(getDriver());
    }

    @Test
    public void addProductToCart() {
        this.productPage.openProductUrl(specificProduct);
        this.productPage.verify();
        this.productPage.attributeSelector();
        this.productPage.addToCart();
        Assert.assertTrue(this.productPage.isAddedMessage(), "The product was NOT added to the cart");
    }
}
