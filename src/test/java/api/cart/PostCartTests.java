package api.cart;

import api.domain.cart.items.AddItemToCart;
import api.domain.checkout.cart.Cart;
import api.utils.CartUtils;
import api.wrappers.CartApiWrapper;
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
        AddItemToCart itemToAdd = CartUtils.addItemToCart("30262", "5");
        Cart postCartResponse = cartApiWrapper.postEmptycart(cart);
        Cart postItemToCartResponse = cartApiWrapper.postCartItems(itemToAdd, postCartResponse.getId());
        Assert.assertNotNull(postItemToCartResponse.getId(), "id is null");
    }
}
