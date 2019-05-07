package api.utils;

import api.domain.user.User;
import helpers.Utilities;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

public class UserUtils {

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

    public static boolean checkIfUsersAreEqual(User requestPayload, User responsePayload) {
        Assert.assertEquals(requestPayload.getId(), responsePayload.getId(), "The user's id is wrong");
        Assert.assertEquals(requestPayload.getUsername(), responsePayload.getUsername(), "The user's username is wrong");
        Assert.assertEquals(requestPayload.getFirstName(), responsePayload.getFirstName(), "The user's firstname is wrong");
        Assert.assertEquals(requestPayload.getLastName(), responsePayload.getLastName(), "The user's lastname is wrong");
        Assert.assertEquals(requestPayload.getEmail(), responsePayload.getEmail(), "The user's email is wrong");
        Assert.assertEquals(requestPayload.getPassword(), responsePayload.getPassword(), "The user's password is wrong");
        Assert.assertEquals(requestPayload.getPhone(), responsePayload.getPhone(), "The user's phone is wrong");
        Assert.assertEquals(requestPayload.getUserStatus(), responsePayload.getUserStatus(), "The user's userStatus is wrong");

        return true;
    }

}
