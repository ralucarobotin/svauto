package api.utils;

import java.util.Date;
import api.domain.store.Order;
import static helpers.Utilities.*;

public class StoreUtils {

    public static Order generateOrderPayload() {
        Order order = new Order();
        order.setId(generateNumbers());
        order.setPetId(generateNumbers());
        order.setQuantity(generateNumbers());
        order.setShipDate(String.valueOf(new Date().getTime()));
        order.setStatus(generateOrderRandomStatus());
        order.setComplete(generateBoolean());

        return order;
    }

    public static boolean checkIfOrdersAreEqual(Order requestPayload, Order responsePayload) {

        assert requestPayload.getId().equals(responsePayload.getId()) : "The order's id is wrong";
        assert requestPayload.getPetId().equals(responsePayload.getPetId()) : "The order's pet id is wrong";
        assert requestPayload.getQuantity().equals(responsePayload.getQuantity()) : "The order's quantity is wrong";
        assert requestPayload.getShipDate() != null : "The order's ship date is wrong";
        assert requestPayload.getStatus().equals(responsePayload.getStatus()) : "The order's status is wrong";
        assert requestPayload.getComplete().equals(responsePayload.getComplete()) : "The order's status is wrong";

        return true;
    }
}
