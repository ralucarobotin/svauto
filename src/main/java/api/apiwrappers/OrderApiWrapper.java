package api.apiwrappers;

import java.io.IOException;
import api.CommonApiWrapper;
import api.domain.store.Order;

public class OrderApiWrapper extends CommonApiWrapper {

    private String orderUrl = "/v2/store/order";
    private String postOrderUrl = "/v2/store/order/";

    public Order postOrder(Order order) throws IOException {
        String endpoint = baseUrl + orderUrl;

        return (Order) post(order, endpoint);
    }

    public Order getOrder(Order order) throws IOException {
        String endpoint = baseUrl + postOrderUrl + order.getId().toString();

        return (Order) get(order, endpoint);
    }
    //TBD
    public Order putOrder(Order order) throws IOException {
        String endpoint = baseUrl + postOrderUrl + order.getId().toString();

        return (Order) put(order, endpoint);
    }

    public void deleteOrder(Order order) throws IOException {
        String endpoint = baseUrl + postOrderUrl + order.getId().toString();

        delete(endpoint);
    }
}
