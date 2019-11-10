package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uiPages.HomePage;
import uiPages.ProductPage;
import uiPages.WishlistPage;

public class WishlistTest extends BaseTest {

    private WishlistPage wishlistPage = null;
    private HomePage homePage = null;
    private ProductPage productPage = null;

    @BeforeMethod
    void beforeMethod() {
        this.homePage = new HomePage(getDriver());
        this.productPage = new ProductPage(getDriver());
        this.wishlistPage = new WishlistPage(getDriver());
    }

    @Test
    public void openWishlistPageFromHome() {
        this.homePage.openHomePageUrl();
        this.homePage.clickBannerDismissButton();
        this.homePage.clickMyWishlistButton();
        this.wishlistPage.verify();
        Assert.assertTrue(this.wishlistPage.isValid(), "The Wishlist page is NOT valid");
    }

    @Test
    public void openWishlistPageFromProduct() {
        this.productPage.openProductUrl("/pink-drop-shoulder-oversized-t-shirt/");
        this.productPage.clickBannerDismissButton();
        this.productPage.clickMyWishlistButton();
        this.wishlistPage.verify();
        Assert.assertTrue(this.wishlistPage.isValid(), "The Wishlist page is NOT valid");
    }

    @Test
    public void addProductToWishlist() {
        this.productPage.openProductUrl("/pink-drop-shoulder-oversized-t-shirt/");
        this.productPage.clickBannerDismissButton();
        this.productPage.clickAddToWishlistButton();
        String addedProductName = this.productPage.getProductName();
        this.productPage.scrollToTop();
        this.productPage.clickMyWishlistButton();
        this.wishlistPage.verify();
        String wishlistProducts = this.wishlistPage.getWishlistProducts();
        Assert.assertTrue(wishlistProducts.contains(addedProductName), "The product was NOT added to the Wishlist");
    }

    /**
     * under construction
     * imi da o eroare json si nu reusesc sa o rezolv
    @Test
    public void removeProductFromWishlist() {
        this.productPage.openProductUrl("/pink-drop-shoulder-oversized-t-shirt/");
        this.productPage.clickBannerDismissButton();
        this.productPage.clickAddToWishlistButton();
        String addedProductName = this.productPage.getProductName();
        this.productPage.scrollToTop();
        this.productPage.clickMyWishlistButton();
        this.wishlistPage.verify();
        String wishlistProducts = this.wishlistPage.getWishlistProducts();
        this.wishlistPage.clickRemoveButton();
        Assert.assertTrue(this.wishlistPage.isRemovedMessageDisplayed(), "The product was NOT removed from the Wishlist");
    }
    */

    /**
     * under construction
    @Test
    public void addTwoProductsToWishlist() {
        this.productPage.openProductUrl("/pink-drop-shoulder-oversized-t-shirt/");
        this.productPage.clickBannerDismissButton();
        this.productPage.clickAddToWishlistButton();
        String addedProductName1 = this.productPage.getProductName();
        //String prodid = this.productPage.getProductId();
        //dute la alt produs
        //adauga produsul
        //trebuie luat si idul produsului ca sa pot cauta dupa el in wishlist
        this.productPage.openProductUrl("/pink-ultimate-ma1-bomber-jacket/");
        //this.productPage.clickBannerDismissButton();
        this.productPage.clickAddToWishlistButton();
        String addedProductName2 = this.productPage.getProductName();
        this.productPage.scrollToTop();
        this.productPage.clickMyWishlistButton();
        this.wishlistPage.verify();
        this.wishlistPage.scrollToTable();
        String wishlistProducts = this.wishlistPage.getWishlistProducts();
        Assert.assertTrue(wishlistProducts.contains(addedProductName1), "The product1 was NOT added to the Wishlist");
        Assert.assertTrue(wishlistProducts.contains(addedProductName2), "The product2 was NOT added to the Wishlist");
    }
    */
}
