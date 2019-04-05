package api.utils;

import java.util.Date;
import java.util.Objects;

import api.domain.store.Order;
import org.apache.commons.lang3.RandomUtils;

public class StoreUtils {

    public static Order generateADefaultOrderPayload() {
        Order order = new Order();
        order.setId(RandomUtils.nextInt(1, 3));
        order.setPetId(RandomUtils.nextInt(1, 3));
        order.setQuantity(RandomUtils.nextInt(1, 3));
        order.setShipDate(String.valueOf(new Date().getTime()));
        order.setStatus("placed");
        order.setComplete(true);

        return order;
    }

    public static boolean checkIfOrdersAreEqual(Order requestPayload, Order responsePayload) {

        assert Objects.equals(requestPayload.getId(), responsePayload.getId()) : "The order's id is wrong";
        assert Objects.equals(requestPayload.getPetId(), responsePayload.getPetId()) : "The order's pet id is wrong";
        assert Objects.equals(requestPayload.getQuantity(), responsePayload.getQuantity()) : "The order's quantity is wrong";
        assert requestPayload.getShipDate() != null : "The order's ship date is wrong";
        assert requestPayload.getStatus().equals(responsePayload.getStatus()) : "The order's status is wrong";
        assert requestPayload.getComplete().equals(responsePayload.getComplete()) : "The order's status is wrong";

        return true;
    }

}
