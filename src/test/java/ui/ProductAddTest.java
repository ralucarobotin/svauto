package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uiPages.LoginPage;
import uiPages.ProductPage;

import static helpers.Utilities.getPropertyFromProductsProp;

public class ProductAddTest extends BaseTest {

    private ProductPage productPage = null;

    private String specificProduct;

    public ProductAddTest() {
        this.specificProduct = getPropertyFromProductsProp("product3");
    }

    @BeforeMethod
    void beforeMethod() {
        this.productPage = new ProductPage(getDriver());
    }

    @Test
    public void addProductToCart() {
        this.productPage.openProductUrl(specificProduct);
        this.productPage.verify();
        this.productPage.selectColor();
        this.productPage.selectSize();
        this.productPage.clickAddToCart();
        Assert.assertTrue(this.productPage.isAddedMessageDisplayed(), "The product was NOT added to the cart");
    }
}
