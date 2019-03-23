package api;

import api.apiwrappers.OrderApiWrapper;
import api.domain.store.Order;
import api.utils.StoreUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class BaseTest {

    private static final OrderApiWrapper orderApiWrapper = new OrderApiWrapper();

    @Test
    private void VerifyThatAnOrderIsSuccessfullyCreated() throws IOException {

        //Generate the payload for an order
        Order orderPayload = StoreUtils.generateADefaultOrderPaylod();

        //Process the order
        Order postResponseOrder = (Order) orderApiWrapper.postOrder(orderPayload);

        //The order was successfully created
        assert StoreUtils.checkIfOrdersAreEquals(orderPayload, postResponseOrder);

        //Verify the order via GET call
        Order getResponseOrder = (Order) orderApiWrapper.getOrder(postResponseOrder);
        assert StoreUtils.checkIfOrdersAreEquals(postResponseOrder, getResponseOrder);
    }
}
