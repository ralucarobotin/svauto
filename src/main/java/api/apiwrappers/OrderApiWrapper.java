package api.apiwrappers;

import java.io.IOException;

import api.CommonApiWrapper;
import api.domain.store.Order;

public class OrderApiWrapper extends CommonApiWrapper {

    public Order postOrder(Order order) throws IOException {
        String endpoint = baseUrl + "/v2/store/order";

        return (Order)post(order, endpoint);
    }

    public Order getOrder(Order order) throws IOException {
        String endpoint = baseUrl + "/v2/store/order/" + order.getId().toString();
        
        return (Order)get(order, endpoint);
    }

    public Order deleteOrder(Order order) throws IOException {
        String endpoint = baseUrl + "/v2/store/order/" + order.getId().toString();

        return (Order)delete(order, endpoint);
    }
}
