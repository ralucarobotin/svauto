package api.utils;

import java.util.Random;

import api.domain.user.User;

public class UserUtils {

  public static User generateDefaultPayload(){
    User user = new User();
    user.setId(new Random().nextInt(20));
    user.setUsername(new byte[10].toString());
    user.setFirstName(new byte[10].toString());
    user.setLastName(new byte[10].toString());
    user.setEmail(new byte[5].toString() + "@domain.com");
    user.setPassword(new byte[10].toString());
    user.setPhone(new byte[10].toString());
    user.setUserStatus(new Random().nextInt(20));

    return user;
  }
}