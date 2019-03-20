package testHelpers;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utilities {
    private static final String ALLOWERCHARSANDNUMBERS = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
    private static final String ALLOWERCHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALLOWEDNUMBERS = "1234567890";
    private static final String EMAILDOMAIN = "@test.com";
    private static final String randomDate = generateRandomDate();


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

    private static String generateRandomDate() {
        int randomInt = RandomUtils.nextInt() % (360 * 30);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, -randomInt);
        return sdf.format(calendar.getTime());
    }

    public static String generateRandomDay(){
        return StringUtils.stripStart(randomDate.split(" ")[2], "0");
    }

    public static String generateRandomYear(){
        return randomDate.split(" ")[0];
    }

    public static String generateRandomMonth(){
        switch (randomDate.split(" ")[1]){
            case "Jan":
                return "1";
            case "Feb":
                return "2";
            case "Mar":
                return "3";
            case "Apr":
                return "4";
            case "May":
                return "5";
            case "Jun":
                return "6";
            case "Jul":
                return "7";
            case "Aug":
                return "8";
            case "Sep":
                return "9";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";
            default:
                return "12";
        }
    }

}
