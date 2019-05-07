package api.apiwrappers;

import api.CommonApiWrapper;
import api.domain.user.*;
import api.utils.UserUtils;



public class UserApiWrapper extends CommonApiWrapper {
    private String userEndpoint = baseUrl + "/v2/user";
    //private UserUtils header = new UserUtils();

    public User postUser(User user){
        //header.setAuthHeader();
        return (User)post(user, userEndpoint);
    }

    public User getUserByUsername(User user){
        return (User)get(user, userEndpoint + "/" + user.getUsername()) ;
    }
}
