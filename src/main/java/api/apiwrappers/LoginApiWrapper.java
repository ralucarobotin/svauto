package api.apiwrappers;

import api.CommonApiWrapper;
import api.domain.login.LoginRequest;
import api.domain.login.LoginResponse;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.message.BasicHeader;

import static helpers.Utilities.getPropertyFromAppProp;

public class LoginApiWrapper extends CommonApiWrapper {

    public LoginResponse postLogin(LoginRequest loginRequest) {
        Header[] headers = {
                new BasicHeader("X-Violet-App-Secret", getPropertyFromAppProp("X-Violet-App-Secret"))
                , new BasicHeader("X-Violet-App-Id", getPropertyFromAppProp("X-Violet-App-Id"))
                , new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json")
        };
        String endpoint = getPropertyFromAppProp("baseUrl")+"/login";
        return (LoginResponse) post(loginRequest, endpoint, headers, LoginResponse.class);
    }

}
