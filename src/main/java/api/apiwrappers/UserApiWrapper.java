package api.apiwrappers;

import api.CommonApiWrapper;
import api.domain.user.*;


public class UserApiWrapper extends CommonApiWrapper {
    private String userEndpoint = baseUrl + "/v2/user";

    public User postUser(User user){
        return (User)post(user, userEndpoint);
    }

    public User getUserByUsername(User user){
        return (User)get(user, userEndpoint + "/" + user.getUsername()) ;
    }
}
