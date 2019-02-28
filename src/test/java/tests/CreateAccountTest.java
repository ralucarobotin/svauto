package tests;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.reporters.jq.INavigatorPanel;
import pages.*;

import static helpers.Utilities.getPropertyFromAppProp;

public class CreateAccountTest extends BaseTest {
    final static String INVALID_EMAIL_ERROR = "Invalid email address.";
    final static String EXISTING_EMAIL_ERROR = "An account using this email address has already been registered. " +
            "Please enter a valid password or request a new one.";
    final static String EMPTY_ACCOUNT_DATA = "There are 8 errors\n" +
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
    //   private String email;
    private String passwordNew;
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
    private String emptyEmail;
    private String emailInvalidFormat;
    private String emailExisting;

    public CreateAccountTest() {
        this.customerFirstName = getPropertyFromAppProp("customerFirstName");
        this.customerLastName = getPropertyFromAppProp("customerLastName");
        this.passwordNew = getPropertyFromAppProp("passwordNew");
        this.day = getPropertyFromAppProp("day");
        this.month = getPropertyFromAppProp("month");
        this.year = getPropertyFromAppProp("year");
        this.firstName = getPropertyFromAppProp("firstName");
        this.lastName = getPropertyFromAppProp("lastName");
        this.company = getPropertyFromAppProp("company");
        this.address1 = getPropertyFromAppProp("address1");
        this.address2 = getPropertyFromAppProp("address2");
        this.city = getPropertyFromAppProp("city");
        this.state = getPropertyFromAppProp("state");
        this.postalCode = getPropertyFromAppProp("postalCode");
        this.country = getPropertyFromAppProp("country");
        this.additionalInfo = getPropertyFromAppProp("additionalInfo");
        this.phone = getPropertyFromAppProp("phone");
        this.mobilePhone = getPropertyFromAppProp("mobilePhone");
        this.alias = getPropertyFromAppProp("alias");
        this.emptyEmail = StringUtils.EMPTY;
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

    @Test(description = "Test account creation with empty Email address\n"
            + "Steps:\n"
            + "1.Navigate to Dashboard page URL: http://automationpractice.com/index.php\n"
            + "2.Without typing anything in the Email address field, click Create an account button\n"
            + "3.Verify that the specific error is displayed\n")
    public void testEmptyEmail() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.createAccountPage.verify();
        this.createAccountPage.create(this.emptyEmail);

        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getSignUpError().isDisplayed(), "Error is displayed");
        Assert.assertEquals(this.createAccountPage.getSignUpErrorMsg(), INVALID_EMAIL_ERROR, "Text errors do not match");
    }

    @Test(description = "Test account creation with invalid Email address format\n"
            + "Steps:\n"
            + "1.Navigate to Dashboard page URL: http://automationpractice.com/index.php\n"
            + "2.Fill in the Email address field with invalid format\n"
            + "3.Click Create an account button\n"
            + "4.Verify that the specific error is displayed\n")
    public void testInvalidEmailFormat() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.createAccountPage.verify();
        this.createAccountPage.create(this.emailInvalidFormat);

        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getSignUpError().isDisplayed(), "Error is displayed");
        Assert.assertEquals(this.createAccountPage.getSignUpErrorMsg(), INVALID_EMAIL_ERROR, "Text errors do not match");
    }

    @Test(description = "Test account creation with an existing Email address\n"
            + "Steps:\n"
            + "1.Navigate to Dashboard page URL: http://automationpractice.com/index.php\n"
            + "2.Fill in the Email address field with an existing email\n"
            + "3.Click Create an account button\n"
            + "4.Verify that the specific error is displayed\n")
    public void testExistingEmail() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.createAccountPage.verify();
        this.createAccountPage.create(this.emailExisting);

        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getSignUpError().isDisplayed(), "Error is displayed");
        Assert.assertEquals(this.createAccountPage.getSignUpErrorMsg(), EXISTING_EMAIL_ERROR, "Text errors do not match");
    }

    @Test(description = "Test account creation with valid Email address and empty account information\n"
            + "Steps:\n"
            + "1.Navigate to Dashboard page URL: http://automationpractice.com/index.php\n"
            + "2.Fill in the Email address field with a random generated email\n"
            + "3.Click Create an account button\n"
            + "4.Verify that redirect to Registration form is performed\n"
            + "5.Without filling in any account data, click Register button\n"
            + "6.Verify that the specific error is displayed\n")
    public void testCreateAccountEmptyData() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getPageHeadingCreateAccount().isDisplayed(), "Page heading is displayed");

        String email = CreateAccountPage.generateEmail(20);
        this.createAccountPage.create(email);

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getPageHeadingRegistration().isDisplayed(), "Page heading is displayed");

        this.registerAccountPage.registerEmptyData();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getRegisterAccountError().isDisplayed(), "Error is displayed");
        Assert.assertEquals(this.registerAccountPage.getRegisterAccountErrorMsg(), EMPTY_ACCOUNT_DATA, "Text errors do not match");
    }

    @Test(description = "Test account creation with valid Email address and account information\n"
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
        Assert.assertTrue(this.createAccountPage.getPageHeadingCreateAccount().isDisplayed(), "Page heading is displayed");

        String email = CreateAccountPage.generateEmail(20);
        this.createAccountPage.create(email);

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getPageHeadingRegistration().isDisplayed(), "Page heading is displayed");

        this.registerAccountPage.register();

        this.myAccountPage.verify();
        Assert.assertTrue(this.myAccountPage.getPageHeadingMyAccount().isDisplayed(), "Page heading is displayed");
    }

    @AfterMethod
    void afterMethod() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

}
