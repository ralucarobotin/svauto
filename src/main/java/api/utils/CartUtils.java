package api.utils;

import api.domain.cart.items.BillingAddress;
import api.domain.cart.items.Skus;
import api.domain.checkout.cart.Cart;
import api.wrappers.CartApiWrapper;
import api.domain.customer.Customer;

public class CartUtils {

    private static final CartApiWrapper cartApiWrapper = new CartApiWrapper();

    /**
     * Adds an item to the card by it's SKU
     *
     * @param skuId    this is the sku_id of the item to be added to the cart
     * @param quantity this is the quantity of the item to be added to the cart
     * @return body with the SKU of the item and the quantity
     */
    public static Skus addSkusToCart(int skuId, int quantity) {
        Skus item = new Skus();
        item.setSkuId(skuId);
        item.setQuantity(quantity);
        return item;
    }

    /**
     * Method to generate valid billing address
     *
     * @param name
     * @param city
     * @param state
     * @param country
     * @param postalCode
     * @param phone
     * @param type
     * @param address1
     * @param address2
     * @return {{@link BillingAddress}
     */
    public static BillingAddress addBillingAddressToCart(String name, String city, String state, String country, String postalCode, String phone, String type, String address1, String address2) {
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setName(name);
        billingAddress.setCity(city);
        billingAddress.setState(state);
        billingAddress.setCountry(country);
        billingAddress.setPostalCode(postalCode);
        billingAddress.setPhone(phone);
        billingAddress.setType(type);
        billingAddress.setAddress1(address1);
        billingAddress.setAddress2(address2);
        return billingAddress;
    }

    public static Cart createEmptyCart() {
        Cart cart = new Cart();
        return cart;
    }

    public static Customer createNewCustomer(String firstName, String lastName, String email) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        return customer;
    }
}
