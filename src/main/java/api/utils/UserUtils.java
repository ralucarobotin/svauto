package api.utils;

import java.util.Random;

import api.domain.user.User;

public class UserUtils {

  public static User generateDefaultPayload(){
    User user = new User();
    user.setId(new Random().nextInt(20));
    user.setUsername(new String(new byte[10]));
    user.setFirstName(new String(new byte[10]));
    user.setLastName(new String(new byte[10]));
    user.setEmail(new String(new byte[5]) + "@domain.com");
    user.setPassword(new String(new byte[10]));
    user.setPhone(new String(new byte[10]));
    user.setUserStatus(new Random().nextInt(20));

    return user;
  }
}