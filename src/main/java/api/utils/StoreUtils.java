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
}
