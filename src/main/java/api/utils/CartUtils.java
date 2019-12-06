package api.utils;

import api.domain.cart.items.BillingAddress;
import api.domain.cart.items.ShippingAddress;
import api.domain.cart.items.Skus;

public class CartUtils {

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

    public static ShippingAddress addShippingAddressToCart(String name, String city, String state, String country, String postalCode, String phone, String type, String address1, String address2) {
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setName(name);
        shippingAddress.setCity(city);
        shippingAddress.setState(state);
        shippingAddress.setCountry(country);
        shippingAddress.setPostalCode(postalCode);
        shippingAddress.setPhone(phone);
        shippingAddress.setType(type);
        shippingAddress.setAddress1(address1);
        shippingAddress.setAddress2(address2);
        return shippingAddress;
    }

}
