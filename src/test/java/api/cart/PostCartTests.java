package api.cart;

import api.domain.checkout.cart.Cart;
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
}
