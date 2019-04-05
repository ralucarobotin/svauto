package api.user;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.apiwrappers.store.UserApiWrapper;
import api.domain.user.User;
import api.utils.UserUtils;

public class UserCRUD200Tests {

  private UserApiWrapper userApiWrapper = new UserApiWrapper();
  private static User userPayload, postResponseUser;

  @BeforeClass
  private void generateOrderPayload(){
    userPayload = UserUtils.generateDefaultPayload();
  }

  @Test
  private void validateAddingAUserIsSuccessful() throws IOException {
    postResponseUser = userApiWrapper.postUser(userPayload);

    Assert.assertEquals(userApiWrapper.getPostUserResponse(), HttpStatus.SC_OK,
        "The user " + postResponseUser.getId() + ", was not successfully created.");
  }

}