package api.wrappers;

import api.CommonApiWrapper;
import api.Headers;
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
}
