package helpers;

public class ErrorMsgList {
    public final static String EMPTY_CREDENTIALS_ERROR = "An email address required.";
    public final static String EMPTY_PSW_ERROR = "Password is required.";
    public final static String INVALID_EMAIL_ERROR = "Invalid email address.";
    public final static String INVALID_CREDENTIALS_ERROR = "Authentication failed.";
    public final static String EXISTING_EMAIL_ERROR = "An account using this email address has already been registered. " +
            "Please enter a valid password or request a new one.";
    public final static String EMPTY_ACCOUNT_DATA = "There are 8 errors\n" +
            "You must register at least one phone number.\n" +
            "lastname is required.\n" +
            "firstname is required.\n" +
            "passwd is required.\n" +
            "address1 is required.\n" +
            "city is required.\n" +
            "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n" +
            "This country requires you to choose a State.";
    public final static String EMPTY_FIELDS_NO_EMAIL = "There are 9 errors\n" +
            "You must register at least one phone number.\n"+
            "lastname is required.\n"+
            "firstname is required.\n"+
            "email is required.\n"+
            "passwd is required.\n"+
            "address1 is required.\n"+
            "city is required.\n"+
            "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n"+
            "This country requires you to choose a State.";
    public final static String FULL_EMPTY_FIELDS = "There are 10 errors\n" +
            "You must register at least one phone number.\n" +
            "lastname is required.\n" +
            "firstname is required.\n" +
            "email is required.\n" +
            "passwd is required.\n" +
            "id_country is required.\n" +
            "address1 is required.\n" +
            "city is required.\n" +
            "Country cannot be loaded with address->id_country\n" +
            "Country is invalid";
    public final static String EMPTY_FIRSTNAME = "There is 1 error\n" +
            "firstname is required.";
    public final static String EMPTY_LASTNAME = "There is 1 error\n" +
            "lastname is required.";
    public final static String EMPTY_PASSWORD = "There is 1 error\n" +
            "passwd is required.";
    public final static String INVALID_PASSWORD = "There is 1 error\n" +
            "passwd is invalid.";
    public final static String EMPTY_EMAIL = "There is 1 error\n" +
            "email is required.";
    public final static String INVALID_EMAIL = "There is 1 error\n" +
            "email is invalid.";
    public final static String INVALID_BIRTHDATE = "There is 1 error\n" +
            "Invalid date of birth.";
    public final static String EMPTY_ADDRESS1 = "There is 1 error\n" +
            "address1 is required.";
    public final static String EMPTY_CITY = "There is 1 error\n" +
            "city is required.";
    public final static String EMPTY_COUNTRY = "There are 3 errors\n" +
            "id_country is required.\n" +
            "Country cannot be loaded with address->id_country\n" +
            "Country is invalid";
    public final static String EMPTY_STATE = "There is 1 error\n" +
            "This country requires you to choose a State.";
    public final static String INVALID_POSTALCODE = "There is 1 error\n" +
            "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
    public final static String EMPTY_MOBILEPHONE = "There is 1 error\n" +
            "You must register at least one phone number.";
    public final static String INVALID_MOBILEPHONE = "There is 1 error\n" +
            "phone_mobile is invalid";
}
