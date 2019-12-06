package api.customer;

import api.domain.cart.items.Skus;
import api.domain.checkout.cart.Cart;
import api.domain.customer.Customer;
import api.utils.CartUtils;

import api.wrappers.CartApiWrapper;
import api.wrappers.CustomerApiWrapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PostCustomerTests {

    private static final CustomerApiWrapper customerApiWrapper = new CustomerApiWrapper();
    private static final CartApiWrapper cartApiWrapper = new CartApiWrapper();
    private Cart postCustomerResponse;
    private Cart postCartResponse;
    private Cart postCartItemsResponse;

    @BeforeMethod
    void beforeMethod() {
        Cart cart = CartUtils.createEmptyCart();
        postCartResponse = cartApiWrapper.postEmptycart(cart);
        Skus itemToAdd = CartUtils.addSkusToCart(30262, 5);
        postCartItemsResponse = cartApiWrapper.postCartItems(itemToAdd, postCartResponse.getId());
    }

    @Test
    public void addNewCustomer() {
        Customer addCustomer = CartUtils.createNewCustomer("Adi", "Red", "adi.red@red.com");
        postCustomerResponse = customerApiWrapper.postCustomer(addCustomer, postCartResponse.getId());
        Assert.assertEquals(postCustomerResponse.getCustomer().getEmail(), addCustomer.getEmail(), "email must not be null is not null");
    }
}

