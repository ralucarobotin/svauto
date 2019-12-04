package api.utils;

import api.domain.cart.items.BillingAddress;
import api.domain.cart.items.Customer;
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

    /**
     * Adds the customer information to the cart
     *
     * @param firstName the first name of the customer
     * @param lastName the last name of the customer
     * @param email the email address of the customer
     * @return body with the customer info to be added to the cart
     */
    public static Customer addCustomerInfoToCart(String firstName, String lastName, String email) {
        Customer customerInfo = new Customer();
        customerInfo.setFirstName(firstName);
        customerInfo.setLastName(lastName);
        customerInfo.setEmail(email);
        return customerInfo;
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

}
