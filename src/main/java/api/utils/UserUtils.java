package api.utils;

import api.domain.user.User;
import static helpers.Utilities.*;

public class UserUtils {

    public static User generateUserPayload() {
        User user = new User();
        user.setId(generateNumbers());
        user.setUsername(generateCharacters());
        user.setFirstName(generateCharacters());
        user.setLastName(generateCharacters());
        user.setEmail(generatedEmail());
        user.setPassword(generatePassword());
        user.setPhone(generateStringNumbers());
        user.setUserStatus(generateNumbers());

        return user;
    }

    public static boolean checkIfUsersAreEqual(User requestPayload, User responsePayload) {

        assert requestPayload.getId().equals(responsePayload.getId()) : "The user's id is wrong";
        assert requestPayload.getUsername().equals(responsePayload.getUsername()) : "The user's username is wrong";
        assert requestPayload.getFirstName().equals(responsePayload.getFirstName()) : "The user's firstname is wrong";
        assert requestPayload.getLastName().equals(responsePayload.getLastName()) : "The user's lastname is wrong";
        assert requestPayload.getEmail().equals(responsePayload.getEmail()) : "The user's email is wrong";
        assert requestPayload.getPassword().equals(responsePayload.getPassword()) : "The user's password is wrong";
        assert requestPayload.getPhone().equals(responsePayload.getPhone()) : "The user's phone is wrong";
        assert requestPayload.getUserStatus().equals(responsePayload.getUserStatus()) : "The user's status is wrong";

        return true;
    }
}
