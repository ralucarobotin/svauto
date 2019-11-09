package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uiPages.ProductPage;

import static helpers.Utilities.getPropertyValue;
import static helpers.Utilities.getPropertyFileContent;

public class ProductAddTest extends BaseTest {

    private ProductPage productPage = null;

    private String specificProduct;
    public static final String PRODUCT_FILE = "./products.properties";

    public static String getPropertyFromProductsProp(String prop){
        return getPropertyValue(getPropertyFileContent(PRODUCT_FILE), prop);
    }

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
