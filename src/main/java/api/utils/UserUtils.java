package api.utils;

import api.domain.user.User;
import helpers.Utilities;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class UserUtils {

    protected String user = Utilities.getPropertyFromAppProp("user");
    protected String pass = Utilities.getPropertyFromAppProp("userPassword");
    protected String urlLogin = Utilities.getPropertyFromAppProp("urlLogin");

    public void setAuthHeader(HttpURLConnection urlConnection) {

        BufferedReader httpResponseReader = null;
        try{

            URL serverUrl = new URL(urlLogin);
            urlConnection = (HttpURLConnection) serverUrl.openConnection();

            String basicAuthPayload = "Basic " + Base64.getEncoder().encodeToString((user+":"+pass).getBytes());
            urlConnection.addRequestProperty("Authorization", basicAuthPayload);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {

            if (httpResponseReader != null) {
                try {
                    httpResponseReader.close();
                } catch (IOException ioe) {
                    // Close quietly
                }
            }
        }
    }


    public static User generateADefaultUserPayload() {
        User user = new User();
        user.setId(RandomUtils.nextInt(1, 5));
        user.setUsername(Utilities.generateCharacters());
        user.setFirstName(Utilities.generateCharacters());
        user.setLastName(Utilities.generateCharacters());
        user.setEmail(Utilities.generatedEmail());
        user.setPassword(Utilities.generatePassword());
        user.setPhone(RandomStringUtils.randomNumeric(1, 11));
        user.setUserStatus(RandomUtils.nextInt(1, 5));

        return user;
    }

}
