package api.utils;

import api.wrappers.LoginApiWrapper;
import api.domain.login.LoginRequest;
import api.domain.login.LoginResponse;

import static helpers.Utilities.getPropertyFromAppProp;

public class LoginUtils {

    /**
     * Creates a Login request body and populates it
     *
     * @return
     */
    public static LoginRequest createLogin() {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(getPropertyFromAppProp("apiUser"));
        loginRequest.setPassword(getPropertyFromAppProp("apiPassword"));

        return loginRequest;
    }

    /**
     * Creates a login session
     *
     * @return login response token that will be used for further calls
     */
    public static String getToken() {

        LoginApiWrapper loginApiWrapper = new LoginApiWrapper();
        LoginRequest requestPayload = createLogin();
        LoginResponse loginResponse = loginApiWrapper.postLogin(requestPayload);

        return loginResponse.getToken();
    }
}
