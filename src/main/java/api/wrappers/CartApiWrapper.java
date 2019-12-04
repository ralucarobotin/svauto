package api.wrappers;

import api.CommonApiWrapper;
import api.Headers;
import api.domain.cart.items.BillingAddress;
import api.domain.checkout.cart.Cart;
import api.utils.LoginUtils;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.message.BasicHeader;

import static helpers.Utilities.getPropertyFromAppProp;

public class CartApiWrapper extends CommonApiWrapper {
    String url = getPropertyFromAppProp("baseUrl");
    Header[] headers = {
            new BasicHeader(Headers.X_VIOLET_APP_SECRET, getPropertyFromAppProp(Headers.X_VIOLET_APP_SECRET))
            , new BasicHeader(Headers.X_VIOLET_APP_ID, getPropertyFromAppProp(Headers.X_VIOLET_APP_ID))
            , new BasicHeader(Headers.X_VIOLET_TOKEN, LoginUtils.getToken())
            , new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json")
    };

    public Cart postEmptycart(Object cart) {
        String endpoint = String.format("%s/checkout/cart", url);
        return (Cart) post(cart, endpoint, headers, Cart.class);
    }

    public Cart postCartItems(Object productSkus, int cartId) {
        String endpoint = String.format("%s/checkout/cart/%s/skus", url, cartId);
        return (Cart) post(productSkus, endpoint, headers, Cart.class);
    }

    public Cart postCartBillingAddress(Object billingAddress, int cartId) {
        String endpoint = String.format("%s/checkout/cart/%s/billing_address", url, cartId);
        return (Cart) post(billingAddress, endpoint, headers, Cart.class);
    }

    public Cart postCartCustomerInfo(Object customerInfo, int cartId) {
        String endpoint = String.format("%s/checkout/cart/%s/customer", url, cartId);
        return (Cart) post(customerInfo, endpoint, headers, Cart.class);
    }
}
