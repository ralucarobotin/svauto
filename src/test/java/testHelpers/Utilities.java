package testHelpers;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Utilities {
    private static final String ALLOWERCHARSANDNUMBERS = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
    private static final String ALLOWERCHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALLOWEDNUMBERS = "1234567890";
    private static final String EMAILDOMAIN = "@test.com";


    public static String generateValidEmailAddress() {
        return RandomStringUtils.random(10, ALLOWERCHARSANDNUMBERS) + EMAILDOMAIN;
    }

    public static String generateRandomString(int length) {
        return RandomStringUtils.random(length, ALLOWERCHARS);
    }

    public static String generateRandomGender() {
        return RandomUtils.nextBoolean() ? "Male" : "Female";
    }


    public static String generateRandomPhoneNumber() {
        return RandomStringUtils.random(10, ALLOWEDNUMBERS);
    }

    public static String generateRandomZipCode() {
        return RandomStringUtils.random(5, ALLOWEDNUMBERS);
    }

    public static String generateRandomState() {
        String[] stateList = new String[]{"Alabama", "Alaska", "Arizona",
                "Arkansas", "California", "Colorado", "Connecticut",
                "Delaware", "District of Columbia", "Florida", "Georgia",
                "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
                "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
                "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
                "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
                "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
                "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina",
                "South Dakota", "Tennessee", "Texas", "US Virgin Islands", "Utah",
                "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin",
                "Wyoming"};

        return stateList[RandomUtils.nextInt() % stateList.length];
    }

}
