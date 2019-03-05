package testHelpers;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Utilities {
    private static final String ALLOWERCHARSANDNUMBERS = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
    private static final String ALLOWERCHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALLOWEDNUMBERS= "1234567890";
    private static final String EMAILDOMAIN = "@test.com";

    public static String generateValidEmailAddress(){
        return RandomStringUtils.random(10, ALLOWERCHARSANDNUMBERS) + EMAILDOMAIN;
    }

    public static String generateRandomString(int length){
        return RandomStringUtils.random(length, ALLOWERCHARS);
    }

    public static String generateRandomGender(){
        boolean testGender = RandomUtils.nextBoolean();
        return testGender ? "Male" : "Female";
    }

    public static String generateRandomPhoneNumber(){
        return RandomStringUtils.random(10, ALLOWEDNUMBERS);
    }

    public static String generateRandomZipCode(){
        return RandomStringUtils.random(5, ALLOWEDNUMBERS);
    }

    public static String generateRandomState(){
        return "Alabama";
    }

}
