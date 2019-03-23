package api.apiwrappers;

import api.CommonApiWrapper;
import api.domain.store.Order;

import java.io.IOException;

public class OrderApiWrapper extends CommonApiWrapper {

    public Object postOrder(Order order) throws IOException {
        String endpoint = "https://petstore.swagger.io/v2/store/order";

        return post(order, endpoint);
    }

    public Object getOrder(Order order) throws IOException {
        String endpoint = "https://petstore.swagger.io/v2/store/order/" + order.getId().toString();

        return get(order, endpoint);
    }
}
