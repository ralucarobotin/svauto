package api.cart;

import api.domain.cart.items.BillingAddress;
import api.domain.cart.items.Customer;
import api.domain.cart.items.Skus;
import api.domain.checkout.cart.Cart;
import api.utils.CartUtils;
import api.wrappers.CartApiWrapper;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostCartTests {

    private static final CartApiWrapper cartApiWrapper = new CartApiWrapper();

    @Test
    public void createEmptyCart() {
        Cart cart = new Cart();
        Cart postCartResponse = cartApiWrapper.postEmptycart(cart);
        Assert.assertNotNull(postCartResponse.getId(), "id is null");
    }

    @Test
    public void addItemsToCart() {
        Cart cart = new Cart();
        Skus itemToAdd = CartUtils.addSkusToCart(30262, 5);
        Cart postCartResponse = cartApiWrapper.postEmptycart(cart);
        Cart postItemToCartResponse = cartApiWrapper.postCartItems(itemToAdd, postCartResponse.getId());
        Assert.assertEquals(cartApiWrapper.statusCode, HttpStatus.SC_OK, "incorrect error code");
    }

    @Test
    public void addCartBillingAddress() {
        Cart cart = new Cart();
        Cart postCartResponse = cartApiWrapper.postEmptycart(cart);
        BillingAddress billingAddress = CartUtils.addBillingAddressToCart("John", "Knoxville", "KN", "US", "539784", "996325698", "shipping", "Lettuce", "No. 666");
        Cart postCartBillingAddress = cartApiWrapper.postCartBillingAddress(billingAddress, postCartResponse.getId());
        Assert.assertEquals(cartApiWrapper.statusCode, HttpStatus.SC_OK, "incorrect error code");
    }

    @Test
    public void addCustomerInfoToCart() {
        Cart cart = new Cart();
        Cart postCartResponse = cartApiWrapper.postEmptycart(cart);
        Customer infoToAdd = CartUtils.addCustomerInfoToCart("Gelu", "Haiduc", "haiduc.gelu@email.com");
        Cart postCartCustomerInfo = cartApiWrapper.postCartCustomerInfo(infoToAdd, postCartResponse.getId());
        Assert.assertEquals(cartApiWrapper.statusCode, HttpStatus.SC_OK, "incorrect error code");
    }
}
