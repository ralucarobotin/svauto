package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
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

    @BeforeMethod
    void beforeMethod() {
        this.productPage = new ProductPage(getDriver());
    }

    @Test
    public void addAnyProductToCart() {
        int i=1;
        while(!getPropertyFromProductsProp("product" + i).equals("empty")){
            this.specificProduct = getPropertyFromProductsProp("product"+i);
            this.productPage.openProductUrl(specificProduct);
            this.productPage.verify();
            this.productPage.selectColorByIndex(1);
            this.productPage.selectSizeByIndex(1);
            this.productPage.clickAddToCart();
            Assert.assertTrue(this.productPage.isAddedMessageDisplayed(), "The product was NOT added to the cart");
            String productName = this.productPage.getProductName().toLowerCase();
            Assert.assertTrue(this.productPage.getConfirmMessage().contains(productName), "A different product was added.");
            i++;
        }
    }

    @Parameters({ "product", "color", "size" })
    @Test
    public void addSpecificProductToCart(String product, String color, String size) {
        this.specificProduct = getPropertyFromProductsProp(product);
        this.productPage.openProductUrl(specificProduct);
        this.productPage.verify();
        this.productPage.selectColorByValue(color);
        this.productPage.selectSizeByValue(size);
        this.productPage.clickAddToCart();
        Assert.assertTrue(this.productPage.isAddedMessageDisplayed(), "The product was NOT added to the cart");
        String productName = this.productPage.getProductName().toLowerCase();
        Assert.assertTrue(this.productPage.getConfirmMessage().contains(productName), "A different product was added.");
    }
}
