package api.apiwrappers;

import java.io.IOException;
import api.CommonApiWrapper;
import api.domain.user.User;

public class UserApiWrapper extends CommonApiWrapper {

    private String userUrl = "/v2/user";
    private String postUserUrl = "/v2/user/";

    public User postUser(User user) throws IOException {
        String endpoint = baseUrl + userUrl;

        return (User) post(user, endpoint);
    }

    public User getUser(User user) throws IOException {
        String endpoint = baseUrl + postUserUrl + user.getUsername();

        return (User) get(user, endpoint);
    }

    public User putUser(User user) throws IOException {
        String endpoint = baseUrl + postUserUrl + user.getUsername();

        return (User) put(user, endpoint);
    }

    public User deleteUser(User user) throws IOException {
        String endpoint = baseUrl + postUserUrl + user.getUsername();

        return (User) delete(endpoint);
    }

}
