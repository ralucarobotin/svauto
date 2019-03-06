package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import pages.*;

import static helpers.Utilities.getPropertyFromAppProp;

public class CreateAccountTest extends BaseTest {
    private final static String INVALID_EMAIL_ERROR = "Invalid email address.";
    private final static String EXISTING_EMAIL_ERROR = "An account using this email address has already been registered. " +
            "Please enter a valid password or request a new one.";
    private final static String EMPTY_ACCOUNT_DATA = "There are 8 errors\n" +
            "You must register at least one phone number.\n" +
            "lastname is required.\n" +
            "firstname is required.\n" +
            "passwd is required.\n" +
            "address1 is required.\n" +
            "city is required.\n" +
            "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n" +
            "This country requires you to choose a State.";

    private DashboardPage dashboardPage = null;
    private CreateAccountPage createAccountPage = null;
    private RegisterAccountPage registerAccountPage = null;
    private MyAccountPage myAccountPage = null;

    private String customerFirstName;
    private String customerLastName;
    private String passwordNew;
    private String email;
    private String day;
    private String month;
    private String year;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String additionalInfo;
    private String phone;
    private String mobilePhone;
    private String alias;
    private String emailInvalidFormat;
    private String emailExisting;

    public CreateAccountTest() {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.passwordNew = passwordNew;
        this.day = day;
        this.month = month;
        this.year = year;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.additionalInfo = additionalInfo;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.alias = alias;
        this.emailInvalidFormat = getPropertyFromAppProp("invalidEmailFormat");
        this.emailExisting = getPropertyFromAppProp("email");
    }

    @BeforeMethod
    void beforeMethod() {
        this.dashboardPage = new DashboardPage(getDriver());
        this.createAccountPage = new CreateAccountPage(getDriver());
        this.registerAccountPage = new RegisterAccountPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    @Test(description = "[Happy Flow] Test account creation with valid Email address and account information\n"
            + "Steps:\n"
            + "1.Navigate to Dashboard page URL: http://automationpractice.com/index.php\n"
            + "2.Fill in the Email address field with a random generated email\n"
            + "3.Click Create an account button\n"
            + "4.Verify that redirect to Registration form is performed\n"
            + "5.Fill in the account data\n"
            + "6.Click Register button\n"
            + "7.Verify that the account is successfully created\n")
    public void testCreateAccount() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getPageHeadingCreateAccount(), "Create Account page heading is displayed");

        this.createAccountPage.startCreateAccountValid();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getPageHeadingRegistration(), "Register Account page heading is displayed");

        this.registerAccountPage.registerRandomData();

        this.myAccountPage.verify();
        Assert.assertTrue(this.myAccountPage.getPageHeadingMyAccount(), "My Account page heading is displayed");
    }

    @Test(description = "Test account creation with empty Email address\n"
            + "Steps:\n"
            + "1.Navigate to Create Account page URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n"
            + "2.Without typing anything in the Email address field, click Create an account button\n"
            + "3.Verify that the specific error is displayed\n")
    public void testEmptyEmail() {
        this.createAccountPage.open();
        this.createAccountPage.verify();
        this.createAccountPage.clickCreateAccountButton();

        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getSignUpError(), "Error is displayed");
        Assert.assertEquals(this.createAccountPage.getSignUpErrorMsg(), INVALID_EMAIL_ERROR, "Text errors do not match");
    }

    @Test(description = "Test account creation with invalid Email address format\n"
            + "Steps:\n"
            + "1.Navigate to Create Account page URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n"
            + "2.Fill in the Email address field with invalid format\n"
            + "3.Click Create an account button\n"
            + "4.Verify that the specific error is displayed\n")
    public void testInvalidEmailFormat() {
        this.createAccountPage.open();
        this.createAccountPage.verify();
        this.createAccountPage.startCreateAccountInvalid(this.emailInvalidFormat);

        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getSignUpError(), "Error is displayed");
        Assert.assertEquals(this.createAccountPage.getSignUpErrorMsg(), INVALID_EMAIL_ERROR, "Text errors do not match");
    }

    @Test(description = "Test account creation with an existing Email address\n"
            + "Steps:\n"
            + "1.Navigate to Create Account page URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n"
            + "2.Fill in the Email address field with an existing email\n"
            + "3.Click Create an account button\n"
            + "4.Verify that the specific error is displayed\n")
    public void testExistingEmail() {
        this.createAccountPage.open();
        this.createAccountPage.verify();
        this.createAccountPage.startCreateAccountInvalid(this.emailExisting);

        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getSignUpError(), "Error is displayed");
        Assert.assertEquals(this.createAccountPage.getSignUpErrorMsg(), EXISTING_EMAIL_ERROR, "Text errors do not match");
    }

    @Test(description = "Test account creation with valid Email address and empty account information\n"
            + "Steps:\n"
            + "1.Navigate to Create Account page URL: http://automationpractice.com/index.php?controller=authentication&back=my-accounthp\n"
            + "2.Fill in the Email address field with a random generated email\n"
            + "3.Click Create an account button\n"
            + "4.Verify that redirect to Registration form is performed\n"
            + "5.Without filling in any account data, click Register button\n"
            + "6.Verify that the specific error is displayed\n")
    public void testCreateAccountEmptyData() {
        this.createAccountPage.open();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getPageHeadingCreateAccount(), "Create Account page heading is displayed");

        this.createAccountPage.startCreateAccountValid();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getPageHeadingRegistration(), "Register Account page heading is displayed");

        this.registerAccountPage.registerEmptyData();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getRegisterAccountError(), "Error is displayed");
        Assert.assertEquals(this.registerAccountPage.getRegisterAccountErrorMsg(), EMPTY_ACCOUNT_DATA, "Text errors do not match");
    }
}
