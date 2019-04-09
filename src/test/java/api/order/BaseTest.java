package api.order;

import java.io.IOException;

import api.apiwrappers.PetApiWrapper;
import api.apiwrappers.UserApiWrapper;
import api.domain.pets.Pet;
import api.domain.user.User;
import org.testng.annotations.Test;

import api.apiwrappers.OrderApiWrapper;
import api.domain.store.Order;
import api.utils.*;

public class BaseTest {

    private static final OrderApiWrapper orderApiWrapper = new OrderApiWrapper();
    private static final PetApiWrapper petApiWrapper =  new PetApiWrapper();
    private static final UserApiWrapper userApiWrapper = new UserApiWrapper();

    @Test
    private void testOrder() throws IOException {

        //Generate the payload for an order
        Order orderPayload = StoreUtils.generateOrderPayload();
        Order orderPayloadUpdated = StoreUtils.generateOrderPayload();


        //Process the order
        Order postResponseOrder = orderApiWrapper.postOrder(orderPayload);

        //The order was successfully created
        assert StoreUtils.checkIfOrdersAreEqual(orderPayload, postResponseOrder);

        //Verify the order via GET call
        Order getResponseOrder = orderApiWrapper.getOrder(postResponseOrder);
        assert StoreUtils.checkIfOrdersAreEqual(postResponseOrder, getResponseOrder);

        //Update order TBD
        Order putResponseOrder = orderApiWrapper.putOrder(orderPayloadUpdated);
        assert StoreUtils.checkIfOrdersAreEqual(orderPayloadUpdated, putResponseOrder);

        //Delete order & check it with GET
        orderApiWrapper.deleteOrder(postResponseOrder);
        orderApiWrapper.getOrder(orderPayload);

    }

    @Test
    private void testPet() throws IOException{

        //Generate the payload for an order
        Pet petPayload = PetsUtils.generatePetPayload();

        //Process the order
        Pet postResponsePet = petApiWrapper.postPet(petPayload);
        assert PetsUtils.checkIfPetsAreEqual(petPayload, postResponsePet);

        //Verify the order via GET call
        Pet getResponsePet = petApiWrapper.getPet(postResponsePet);
        assert PetsUtils.checkIfPetsAreEqual(postResponsePet, getResponsePet);

        //Delete order & check it with GET
        petApiWrapper.deletePet(postResponsePet);
        petApiWrapper.getPet(petPayload);
    }

    @Test
    private void testUser() throws IOException{

        //Generate the payload for an order
        User userPayload = UserUtils.generateUserPayload();

        //Process the order
        User postResponseUser = userApiWrapper.postUser(userPayload);
        assert UserUtils.checkIfUsersAreEqual(userPayload, postResponseUser);

        //Verify the order via GET call
        User getResponseUser = userApiWrapper.getUser(postResponseUser);
        assert UserUtils.checkIfUsersAreEqual(postResponseUser, getResponseUser);
    }

}
