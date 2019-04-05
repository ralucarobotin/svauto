package api.user;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import api.apiwrappers.store.UserApiWrapper;
import api.domain.user.User;
import api.utils.UserUtils;

public class UserCRUDPositiveTests {

  private UserApiWrapper userApiWrapper = new UserApiWrapper();
  private static final SoftAssert softAssert = new SoftAssert();
  private static User userPayload, postResponseUser;

  @BeforeClass
  private void generateOrderPayload(){
    userPayload = UserUtils.generateDefaultPayload();
  }

  @Test
  private void validateAddingAUserIsSuccessful() throws IOException {
    postResponseUser = userApiWrapper.postUser(userPayload);

    checkIfUsersAreEqual(userPayload, postResponseUser);
    Assert.assertEquals(userApiWrapper.getPostUserResponse(), HttpStatus.SC_OK,
        "The user " + postResponseUser.getId() + ", was not successfully created.");
  }

  private static void checkIfUsersAreEqual(User requestPayload, User responsePayload) {
    softAssert.assertEquals(requestPayload.getId(), responsePayload.getId(),  "The " +
        "user's id is wrong");
    softAssert.assertEquals(requestPayload.getFirstName(), responsePayload.getFirstName(), "The " +
        "user's first name is wrong");
    softAssert.assertEquals(requestPayload.getLastName(), responsePayload.getLastName(),
        "The user's last name is wrong");
    softAssert.assertEquals(requestPayload.getEmail(), responsePayload.getEmail(),
        "The user's email is wrong");
    softAssert.assertEquals(requestPayload.getPassword(), responsePayload.getPassword(),
        "The user's password is wrong");
    softAssert.assertEquals(requestPayload.getPhone(), responsePayload.getPhone(),
        "The user's phone number is wrong");
    softAssert.assertEquals(requestPayload.getUsername(), responsePayload.getUsername(),
        "The user's username is wrong");
    softAssert.assertEquals(requestPayload.getUserStatus(), responsePayload.getUserStatus(),
        "The user's status is wrong");
  }
}