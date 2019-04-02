package api.order;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import api.apiwrappers.OrderApiWrapper;
import api.domain.store.Order;
import api.utils.StoreUtils;

public class BaseTest {

    private static final OrderApiWrapper orderApiWrapper = new OrderApiWrapper();
    private static final SoftAssert softAssert = new SoftAssert();
    private static Order orderPayload, postResponseOrder;

    @BeforeClass
    private void generateOrderPayload(){
        orderPayload = StoreUtils.generateADefaultOrderPayload();
    }

    @Test
    private void verifyThatAnOrderIsSuccessfullyCreated() throws IOException {
        //Create order
        postResponseOrder = orderApiWrapper.postOrder(orderPayload);
        //Assert the order was successfully created
        checkIfOrdersAreEqual(orderPayload, postResponseOrder);
        Assert.assertEquals(orderApiWrapper.getPostOrderResponse(), HttpStatus.SC_OK,
            "The order " + postResponseOrder.getId() + ", was not successfully created.");
    }

    @Test (dependsOnMethods = "verifyThatAnOrderIsSuccessfullyCreated")
    private void verifyThatAnOrderIsSuccessfullyRetrieved() throws IOException{
        //Retrieve order
        Order getResponseOrder = orderApiWrapper.getOrder(postResponseOrder);
        //Assert the order was correctly retrieved
        checkIfOrdersAreEqual(postResponseOrder, getResponseOrder);
        Assert.assertEquals(orderApiWrapper.getGetOrderResponse(), HttpStatus.SC_OK,
            "The order " + postResponseOrder.getId() + ", was not successfully retrieved.");
    }

    @Test (dependsOnMethods = {
        "verifyThatAnOrderIsSuccessfullyCreated",
        "verifyThatAnOrderIsSuccessfullyRetrieved"})
    private void verifyThatAnOrderIsSuccessfullyDelete() throws IOException {
        //Delete order
        orderApiWrapper.deleteOrder(postResponseOrder);
        //Assert the order was correctly deleted
        Assert.assertEquals(orderApiWrapper.getDeleteOrderResponse(), HttpStatus.SC_OK,
            "The order " + postResponseOrder.getId() + ", was not successfully deleted.");
    }

    private static void checkIfOrdersAreEqual(Order requestPayload, Order responsePayload) {
        softAssert.assertEquals(requestPayload.getId(), responsePayload.getId(),  "The " +
            "order's id is wrong");
        softAssert.assertEquals(requestPayload.getPetId(), responsePayload.getPetId(), "The " +
            "order's pet id is wrong");
        softAssert.assertEquals(requestPayload.getQuantity(), responsePayload.getQuantity(),
        "The order's quantity is wrong");
        softAssert.assertTrue(requestPayload.getShipDate() != null, "The order's ship date is " +
            "wrong");
        softAssert.assertEquals(requestPayload.getStatus(), responsePayload.getStatus(),
        "The order's status is wrong");
        softAssert.assertEquals(requestPayload.getComplete(), responsePayload.getComplete(),
        "The order's status is wrong");
    }
}
