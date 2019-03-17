package tests;

import helpers.ErrorMsgList;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.*;

import static helpers.Utilities.getPropertyFromAppProp;

public class CreateAccountTest extends BaseTest {
    private DashboardPage dashboardPage = null;
    private CreateAccountPage createAccountPage = null;
    private RegisterAccountPage registerAccountPage = null;
    private MyAccountPage myAccountPage = null;

    private String emailInvalidFormat;
    private String emailExisting;

    public CreateAccountTest() {
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
        Assert.assertTrue(this.createAccountPage.getPageHeading(), "Create Account page heading is displayed");

        this.createAccountPage.startValidAccountCreation();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getPageHeading(), "Register Account page heading is displayed");

        UserAccount account = new UserAccount.Builder().build();

        this.registerAccountPage.genderSelect();
        this.registerAccountPage.fillInCustomerFirstName(account.getCustomerFirstName());
        this.registerAccountPage.fillInCustomerLastName(account.getCustomerLastName());
        this.registerAccountPage.fillInPassword(account.getPasswordNew());
        this.registerAccountPage.daySelect();
        this.registerAccountPage.monthSelect();
        this.registerAccountPage.yearSelect();
        this.registerAccountPage.optionsSelect();
        this.registerAccountPage.fillInFirstName(account.getFirstName());
        this.registerAccountPage.fillInLastName(account.getLastName());
        this.registerAccountPage.fillInCompany(account.getCompany());
        this.registerAccountPage.fillInAddress1(account.getAddress1());
        this.registerAccountPage.fillInAddress2(account.getAddress2());
        this.registerAccountPage.fillInCity(account.getCity());
        this.registerAccountPage.stateSelect();
        this.registerAccountPage.fillInPostalCode(account.getPostalCode());
        this.registerAccountPage.countrySelect();
        this.registerAccountPage.fillInAdditionalInfo(account.getAdditionalInfo());
        this.registerAccountPage.fillInPhone(account.getPhone());
        this.registerAccountPage.fillInMobilePhone(account.getMobilePhone());
        this.registerAccountPage.fillInAlias(account.getAlias());
        this.registerAccountPage.clickRegisterButton();

        this.myAccountPage.verify();
        Assert.assertTrue(this.myAccountPage.getPageHeading(), "My Account page heading is displayed");
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
        Assert.assertTrue(this.createAccountPage.getSignUpError(), "[Create Account Page] Error message is displayed");
        Assert.assertEquals(this.createAccountPage.getSignUpErrorMsg(), ErrorMsgList.INVALID_EMAIL_ERROR, "[Create Account Page] " +
                "Received text error message does not match - Invalid email address. - error");
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
        this.createAccountPage.startInvalidAccountCreation(this.emailInvalidFormat);

        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getSignUpError(), "[Create Account Page] Error message is displayed");
        Assert.assertEquals(this.createAccountPage.getSignUpErrorMsg(), ErrorMsgList.INVALID_EMAIL_ERROR, "[Create Account Page] " +
                "Received text error message does not match - Invalid email address. - error");
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
        this.createAccountPage.startInvalidAccountCreation(this.emailExisting);

        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getSignUpError(), "[Create Account Page] Error message is displayed");
        Assert.assertEquals(this.createAccountPage.getSignUpErrorMsg(), ErrorMsgList.EXISTING_EMAIL_ERROR, "[Create Account Page] " +
                "Received text error message does not match - An account using this email address has already been registered. " +
                "- error");
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
        Assert.assertTrue(this.createAccountPage.getPageHeading(), "Create Account page heading is displayed");

        this.createAccountPage.startValidAccountCreation();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getPageHeading(), "Register Account page heading is displayed");

        this.registerAccountPage.registerEmptyData();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getRegisterAccountError(), "[Register Account Page] Error message is displayed");
        Assert.assertEquals(this.registerAccountPage.getRegisterAccountErrorMsg(), ErrorMsgList.EMPTY_ACCOUNT_DATA, "[Register Account Page] " +
                "Received text error message does not match - There are 8 errors ... - error");
    }

    @Test(description = "Test account creation with valid Email address and empty customer first name information\n"
            + "Steps:\n"
            + "1.Navigate to Create Account page URL: http://automationpractice.com/index.php?controller=authentication&back=my-accounthp\n"
            + "2.Fill in the Email address field with a random generated email\n"
            + "3.Click Create an account button\n"
            + "4.Verify that redirect to Registration form is performed\n"
            + "5.Fill in the account data with the exception of Customer First Name.\n"
            + "6.Click Register button\n"
            + "7.Verify that the specific error is displayed\n")
    public void testCreateAccountEmptyCustomerName() {
        this.createAccountPage.open();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getPageHeading(), "Create Account page heading is displayed");

        this.createAccountPage.startValidAccountCreation();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getPageHeading(), "Register Account page heading is displayed");

        UserAccount account = new UserAccount.Builder().build();

        this.registerAccountPage.genderSelect();
        this.registerAccountPage.fillInCustomerFirstName(StringUtils.EMPTY);
        this.registerAccountPage.fillInCustomerLastName(account.getCustomerLastName());
        this.registerAccountPage.fillInPassword(account.getPasswordNew());
        this.registerAccountPage.daySelect();
        this.registerAccountPage.monthSelect();
        this.registerAccountPage.yearSelect();
        this.registerAccountPage.optionsSelect();
        this.registerAccountPage.fillInFirstName(account.getFirstName());
        this.registerAccountPage.fillInLastName(account.getLastName());
        this.registerAccountPage.fillInCompany(account.getCompany());
        this.registerAccountPage.fillInAddress1(account.getAddress1());
        this.registerAccountPage.fillInAddress2(account.getAddress2());
        this.registerAccountPage.fillInCity(account.getCity());
        this.registerAccountPage.stateSelect();
        this.registerAccountPage.fillInPostalCode(account.getPostalCode());
        this.registerAccountPage.countrySelect();
        this.registerAccountPage.fillInAdditionalInfo(account.getAdditionalInfo());
        this.registerAccountPage.fillInPhone(account.getPhone());
        this.registerAccountPage.fillInMobilePhone(account.getMobilePhone());
        this.registerAccountPage.fillInAlias(account.getAlias());
        this.registerAccountPage.clickRegisterButton();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getRegisterAccountError(), "[Register Account Page] Error message is displayed");
        Assert.assertEquals(this.registerAccountPage.getRegisterAccountErrorMsg(), ErrorMsgList.EMPTY_FIRSTNAME, "[Register Account Page] " +
                "Received text error message does not match - There is 1 error: firstname is required.");
    }

    @Test(description = "Test account creation with valid Email address and empty city information\n"
            + "Steps:\n"
            + "1.Navigate to Create Account page URL: http://automationpractice.com/index.php?controller=authentication&back=my-accounthp\n"
            + "2.Fill in the Email address field with a random generated email\n"
            + "3.Click Create an account button\n"
            + "4.Verify that redirect to Registration form is performed\n"
            + "5.Fill in the account data with the exception of City.\n"
            + "6.Click Register button\n"
            + "7.Verify that the specific error is displayed\n")
    public void testCreateAccountEmptyCity() {
        this.createAccountPage.open();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getPageHeading(), "Create Account page heading is displayed");

        this.createAccountPage.startValidAccountCreation();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getPageHeading(), "Register Account page heading is displayed");

        UserAccount account = new UserAccount.Builder().build();

        this.registerAccountPage.genderSelect();
        this.registerAccountPage.fillInCustomerFirstName(account.getCustomerFirstName());
        this.registerAccountPage.fillInCustomerLastName(account.getCustomerLastName());
        this.registerAccountPage.fillInPassword(account.getPasswordNew());
        this.registerAccountPage.daySelect();
        this.registerAccountPage.monthSelect();
        this.registerAccountPage.yearSelect();
        this.registerAccountPage.optionsSelect();
        this.registerAccountPage.fillInFirstName(account.getFirstName());
        this.registerAccountPage.fillInLastName(account.getLastName());
        this.registerAccountPage.fillInCompany(account.getCompany());
        this.registerAccountPage.fillInAddress1(account.getAddress1());
        this.registerAccountPage.fillInAddress2(account.getAddress2());
        this.registerAccountPage.fillInCity(StringUtils.EMPTY);
        this.registerAccountPage.stateSelect();
        this.registerAccountPage.fillInPostalCode(account.getPostalCode());
        this.registerAccountPage.countrySelect();
        this.registerAccountPage.fillInAdditionalInfo(account.getAdditionalInfo());
        this.registerAccountPage.fillInPhone(account.getPhone());
        this.registerAccountPage.fillInMobilePhone(account.getMobilePhone());
        this.registerAccountPage.fillInAlias(account.getAlias());
        this.registerAccountPage.clickRegisterButton();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getRegisterAccountError(), "[Register Account Page] Error message is displayed");
        Assert.assertEquals(this.registerAccountPage.getRegisterAccountErrorMsg(), ErrorMsgList.EMPTY_CITY, "[Register Account Page] " +
                "Received text error message does not match - There is 1 error: city is required.");
    }

    @Test(description = "Test account creation with valid Email address and empty phone and mobile phone information\n"
            + "Steps:\n"
            + "1.Navigate to Create Account page URL: http://automationpractice.com/index.php?controller=authentication&back=my-accounthp\n"
            + "2.Fill in the Email address field with a random generated email\n"
            + "3.Click Create an account button\n"
            + "4.Verify that redirect to Registration form is performed\n"
            + "5.Fill in the account data with the exception of phone and mobile phone.\n"
            + "6.Click Register button\n"
            + "7.Verify that the specific error is displayed\n")
    public void testCreateAccountEmptyPhone() {
        this.createAccountPage.open();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getPageHeading(), "Create Account page heading is displayed");

        this.createAccountPage.startValidAccountCreation();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getPageHeading(), "Register Account page heading is displayed");

        UserAccount account = new UserAccount.Builder().build();

        this.registerAccountPage.genderSelect();
        this.registerAccountPage.fillInCustomerFirstName(account.getCustomerFirstName());
        this.registerAccountPage.fillInCustomerLastName(account.getCustomerLastName());
        this.registerAccountPage.fillInPassword(account.getPasswordNew());
        this.registerAccountPage.daySelect();
        this.registerAccountPage.monthSelect();
        this.registerAccountPage.yearSelect();
        this.registerAccountPage.optionsSelect();
        this.registerAccountPage.fillInFirstName(account.getFirstName());
        this.registerAccountPage.fillInLastName(account.getLastName());
        this.registerAccountPage.fillInCompany(account.getCompany());
        this.registerAccountPage.fillInAddress1(account.getAddress1());
        this.registerAccountPage.fillInAddress2(account.getAddress2());
        this.registerAccountPage.fillInCity(account.getCity());
        this.registerAccountPage.stateSelect();
        this.registerAccountPage.fillInPostalCode(account.getPostalCode());
        this.registerAccountPage.countrySelect();
        this.registerAccountPage.fillInAdditionalInfo(account.getAdditionalInfo());
        this.registerAccountPage.fillInPhone(StringUtils.EMPTY);
        this.registerAccountPage.fillInMobilePhone(StringUtils.EMPTY);
        this.registerAccountPage.fillInAlias(account.getAlias());
        this.registerAccountPage.clickRegisterButton();

        this.registerAccountPage.verify();
        Assert.assertTrue(this.registerAccountPage.getRegisterAccountError(), "[Register Account Page] Error message is displayed");
        Assert.assertEquals(this.registerAccountPage.getRegisterAccountErrorMsg(), ErrorMsgList.EMPTY_MOBILEPHONE, "[Register Account Page] " +
                "Received text error message does not match - There is 1 error: You must register at least one phone number.");
    }


}
