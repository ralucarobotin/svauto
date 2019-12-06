package api.wrappers;

import api.CommonApiWrapper;
import api.Headers;
import api.domain.checkout.cart.Cart;
import api.domain.customer.Customer;
import api.utils.LoginUtils;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.message.BasicHeader;

import static helpers.Utilities.getPropertyFromAppProp;

public class CustomerApiWrapper extends CommonApiWrapper {
    String url = getPropertyFromAppProp("baseUrl");
    Header[] headers = {
            new BasicHeader(Headers.X_VIOLET_APP_SECRET, getPropertyFromAppProp(Headers.X_VIOLET_APP_SECRET))
            , new BasicHeader(Headers.X_VIOLET_APP_ID, getPropertyFromAppProp(Headers.X_VIOLET_APP_ID))
            , new BasicHeader(Headers.X_VIOLET_TOKEN, LoginUtils.getToken())
            , new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json")
    };

    public Cart postCustomer(Customer customer, Integer cartId) {
        String endpoint = String.format("%s/checkout/cart/%d/customer", url, cartId);
        return (Cart) post(customer, endpoint, headers, Cart.class);
    }
}

