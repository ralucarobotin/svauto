package api.apiwrappers.store;

import java.io.IOException;

import api.CommonApiWrapper;
import api.domain.store.Order;

public class OrderApiWrapper extends CommonApiWrapper {

    private final String orderPath = "/v2/store/order/";

    public Order postOrder(Order order) throws IOException {
        String endpoint = baseUrl + orderPath;

        return (Order)post(order, endpoint);
    }

    public Order getOrder(Order order) throws IOException {
        String endpoint = baseUrl + orderPath + order.getId().toString();
        
        return (Order)get(order, endpoint);
    }

    public Order deleteOrder(Order order) throws IOException{
        String endpoint = baseUrl + orderPath + order.getId().toString();
        return (Order)delete(order, endpoint);
    }

    public int getDeleteOrderResponse(){
        return deleteResponse;
    }

    public int getPostOrderResponse(){
        return postResponse;
    }

    public int getGetOrderResponse(){
        return getResponse;
    }
}
