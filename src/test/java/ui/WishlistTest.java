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
        this.productPage.openProductUrl("/pink-ultimate-ma1-bomber-jacket/");
        this.productPage.clickBannerDismissButton();
        this.productPage.clickAddToWishlistButton();
        String addedProductName = this.productPage.getProductName();
        this.productPage.scrollToTop();
        this.productPage.clickMyWishlistButton();
        this.wishlistPage.verify();
        String wishlistProduct = this.wishlistPage.getFirstWishlistProduct();
        Assert.assertTrue(wishlistProduct.contains(addedProductName), "The product was NOT added to the Wishlist");
    }

    @Test
    public void removeProductFromWishlist() {
        this.productPage.openProductUrl("/pink-ultimate-ma1-bomber-jacket/");
        this.productPage.clickBannerDismissButton();
        this.productPage.clickAddToWishlistButton();
        this.productPage.scrollToTop();
        this.productPage.clickMyWishlistButton();
        this.wishlistPage.verify();
        this.wishlistPage.clickRemoveButton();
        Assert.assertTrue(this.wishlistPage.isRemovedMessageDisplayed(), "The product was NOT removed from the Wishlist");
    }

    @Test
    public void selectOptionsProductFromWishlist() {
        this.productPage.openProductUrl("/pink-ultimate-ma1-bomber-jacket/");
        this.productPage.clickBannerDismissButton();
        this.productPage.clickAddToWishlistButton();
        this.productPage.scrollToTop();
        this.productPage.clickMyWishlistButton();
        this.wishlistPage.verify();
        String wishlistProduct = this.wishlistPage.getFirstWishlistProduct();
        this.wishlistPage.clickSelectOptionsButton();
        String addedProductName = this.productPage.getProductName();
        Assert.assertTrue(wishlistProduct.contains(addedProductName), "The product page from the wishlist is NOT selected.");
    }

    /**
     * in testul asta vreau sa verific ca se pot adauga mai multe produse in wishlist
     * da nu am reusit sa identific randurile din tabel in functie de idul produsului
     * nu stiu cum sa identific idul produsului ca sa pot adauga la capatul selectorului de rand al tabelului cu produse
     * momentan ii facut cu produsul specific da vreau sa pot verifica orice produs intra in lista
     */
    @Test
    public void addTwoProductsToWishlist() {
        this.productPage.openProductUrl("/pink-ultimate-ma1-bomber-jacket/");
        this.productPage.clickBannerDismissButton();
        this.productPage.clickAddToWishlistButton();
        String addedProductName1 = this.productPage.getProductName();
        this.productPage.openProductUrl("/pink-drop-shoulder-oversized-t-shirt/");
        this.productPage.clickAddToWishlistButton();
        String addedProductName2 = this.productPage.getProductName();
        this.productPage.scrollToTop();
        this.productPage.clickMyWishlistButton();
        this.wishlistPage.verify();
        this.wishlistPage.scrollToTable();
        String wishlistProduct1 = this.wishlistPage.getFirstWishlistProduct();
        String wishlistProduct2 = this.wishlistPage.getSecondWishlistProduct();
        Assert.assertTrue(wishlistProduct1.contains(addedProductName1), "The product1 was NOT added to the Wishlist");
        Assert.assertTrue(wishlistProduct2.contains(addedProductName2), "The product2 was NOT added to the Wishlist");
    }
}
