package api.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import api.domain.store.Order;

public class StoreUtils {

    public static Order generateADefaultOrderPayload() {
        Order order = new Order();
        order.setId(new BigDecimal(new Random().nextInt(20)));
        order.setPetId(new BigDecimal(String.valueOf(new Random().nextInt(20))));
        order.setQuantity(new BigDecimal(String.valueOf(new Random().nextInt(20))));
        order.setShipDate(String.valueOf(new Date().getTime()));
        order.setStatus("placed");
        order.setComplete(true);

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
