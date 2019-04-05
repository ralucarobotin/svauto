package api.order;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.apiwrappers.OrderApiWrapper;
import api.domain.store.Order;
import api.utils.StoreUtils;

public class BaseTest {

    private static final OrderApiWrapper orderApiWrapper = new OrderApiWrapper();

    @Test
    private void VerifyThatAnOrderIsSuccessfullyCreated() throws IOException {

        //Generate the payload for an order
        Order orderPayload = StoreUtils.generateADefaultOrderPayload();

        //Process the order
        Order postResponseOrder = orderApiWrapper.postOrder(orderPayload);

        //The order was successfully created
        assert StoreUtils.checkIfOrdersAreEqual(orderPayload, postResponseOrder);

        //Verify the order via GET call
        Order getResponseOrder = orderApiWrapper.getOrder(postResponseOrder);
        assert StoreUtils.checkIfOrdersAreEqual(postResponseOrder, getResponseOrder);

        //Delete the order via DELETE call
        Order deleteResponseOrder = orderApiWrapper.deleteOrder(postResponseOrder);
        Assert.assertEquals(deleteResponseOrder, HttpStatus.SC_OK);
    }
}
