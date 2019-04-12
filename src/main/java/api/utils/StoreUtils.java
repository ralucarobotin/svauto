package api.utils;

import java.util.Date;

import api.domain.store.Order;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;

public class StoreUtils {

    public static Order generateADefaultOrderPayload() {
        Order order = new Order();
        order.setId(RandomUtils.nextInt(1, 5));
        order.setPetId(RandomUtils.nextInt(1, 5));
        order.setQuantity(RandomUtils.nextInt(1, 5));
        order.setShipDate(String.valueOf(new Date().getTime()));
        order.setStatus("placed");
        order.setComplete(true);

        return order;
    }

    public static boolean checkIfOrdersAreEqual(Order requestPayload, Order responsePayload) {

        Assert.assertEquals(requestPayload.getId(), responsePayload.getId(), "The order's id is wrong");
        Assert.assertEquals(requestPayload.getPetId(), responsePayload.getPetId(),"The order's pet id is wrong");
        Assert.assertEquals(requestPayload.getQuantity(), responsePayload.getQuantity(),"The order's quantity is wrong");
        Assert.assertNotNull(requestPayload.getShipDate(),"The order's ship date is wrong");
        Assert.assertEquals(requestPayload.getStatus(), responsePayload.getStatus(), "The order's status is wrong");
        Assert.assertEquals(requestPayload.getComplete(), responsePayload.getComplete(),"The order's status is wrong");

        return true;
   }
}
