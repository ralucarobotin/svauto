package api.user;

import api.apiwrappers.UserApiWrapper;
import api.domain.user.User;
import api.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTestUser {

    public static final UserApiWrapper userApiWrapper = new UserApiWrapper();
    private static User userPayload;

    @BeforeClass
    private void generateUserPayload(){
        userPayload = UserUtils.generateADefaultUserPayload();
    }


    @Test
    private void userSuccessfullyCreated(){
        //Process the user
        User postResponseUser = userApiWrapper.postUser(userPayload);

        //The user was successfully created
        assert UserUtils.checkIfUsersAreEqual(userPayload, postResponseUser);

        //Verify the user via GET call
        User getResponseUser = userApiWrapper.getUserByUsername(userPayload);
        assert UserUtils.checkIfUsersAreEqual(userPayload, getResponseUser);

        Assert.assertEquals(postResponseUser.getId(), getResponseUser.getId(), "The user's id is wrong");
        Assert.assertEquals(postResponseUser.getUsername(), getResponseUser.getUsername(), "The user's username is wrong");
        Assert.assertEquals(postResponseUser.getFirstName(), getResponseUser.getFirstName(), "The user's firstname is wrong");
        Assert.assertEquals(postResponseUser.getLastName(), getResponseUser.getLastName(), "The user's lastname is wrong");
        Assert.assertEquals(postResponseUser.getEmail(), getResponseUser.getEmail(), "The user's email is wrong");
        Assert.assertEquals(postResponseUser.getPassword(), getResponseUser.getPassword(), "The user's password is wrong");
        Assert.assertEquals(postResponseUser.getPhone(), getResponseUser.getPhone(), "The user's phone is wrong");
        Assert.assertEquals(postResponseUser.getUserStatus(), getResponseUser.getUserStatus(), "The user's userStatus is wrong");
    }


}
