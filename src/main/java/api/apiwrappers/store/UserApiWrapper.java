package api.apiwrappers.store;

import java.io.IOException;

import api.CommonApiWrapper;
import api.domain.user.User;

public class UserApiWrapper extends CommonApiWrapper {

  private final String orderPath = "/v2/store/order/";

  public User postUser(User order) throws IOException {
    String endpoint = baseUrl + orderPath;

    return (User)post(order, endpoint);
  }

  public User getUser(User order) throws IOException {
    String endpoint = baseUrl + orderPath + order.getId().toString();

    return (User)get(order, endpoint);
  }

  public User deleteUser(User order) throws IOException{
    String endpoint = baseUrl + orderPath + order.getId().toString();
    return (User)delete(order, endpoint);
  }

  public int getDeleteUserResponse(){
    return deleteResponse;
  }

  public int getPostUserResponse(){
    return postResponse;
  }

  public int getGetUserResponse(){
    return getResponse;
  }
}