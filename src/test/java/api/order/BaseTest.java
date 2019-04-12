package api.order;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.apiwrappers.OrderApiWrapper;
import api.domain.store.Order;
import api.utils.StoreUtils;

public class BaseTest {

    private static final OrderApiWrapper orderApiWrapper = new OrderApiWrapper();

    private static Order orderPayload;

    @BeforeClass
    private void generateOrderPayload(){
        orderPayload = StoreUtils.generateADefaultOrderPayload();
    }

    @Test
    private void VerifyThatAnOrderIsSuccessfullyCreated() throws IOException {
        //Process the order
        Order postResponseOrder = orderApiWrapper.postOrder(orderPayload);

        //The order was successfully created
        assert StoreUtils.checkIfOrdersAreEqual(orderPayload, postResponseOrder);

        //Verify the order via GET call
        Order getResponseOrder = orderApiWrapper.getOrder(postResponseOrder);
        assert StoreUtils.checkIfOrdersAreEqual(postResponseOrder, getResponseOrder);
    }

    @Test
    private void VerifyThatAnOrderIsSuccessfullyDeleted() throws IOException {
        //Process the order
        Order postResponseOrder = orderApiWrapper.postOrder(orderPayload);

        //The order was successfully created
        assert StoreUtils.checkIfOrdersAreEqual(orderPayload, postResponseOrder);

        //Delete the order via DELETE call
        orderApiWrapper.deleteOrder(postResponseOrder);
        Assert.assertEquals(orderApiWrapper.getDeleteOrderResponse(), HttpStatus.SC_OK, "The order " + postResponseOrder.getId()
                + ", was not successfully deleted.");
    }
}
