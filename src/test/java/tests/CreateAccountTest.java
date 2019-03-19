package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;
import pages.MyAccountPage;


import static testHelpers.Utilities.*;

public class CreateAccountTest extends BaseTest {
    private LoginPage loginPage = null;
    private CreateAccountPage createAccountPage = null;
    private MyAccountPage myAccountPage = null;

    private static final String DUPLICATE_EMAIL = "test@test.com";

    private static final String EMPTY_INVALID_EMAIL_ERROR = "Invalid email address.";
    private static final String DUPLICATE_EMAIL_ERROR = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
    private static final String EMPTY_FORM_ERROR = "There are 8 errors";

    public CreateAccountTest() {
    }

    @BeforeMethod
    void beforeMethod() {
        this.loginPage = new LoginPage(getDriver());
        this.createAccountPage = new CreateAccountPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    @Test(description = "Test navigating to create account page from the login page\n"
            + "Steps:\n"
            + "1. Open the login page\n"
            + "2. Insert a unique email address and click the Create an account button\n"
            + "3. Verify the create account page is sucesfully displayed\n")
    void navigateToAccountCreationPage() {
        this.loginPage.open();
        this.loginPage.verify();

        this.loginPage.submitEmailAccountCreation(generateValidEmailAddress());
        this.createAccountPage.verify();
    }

    @Test(description = "Test navigating to create account page with empty email\n"
            + "Steps:\n"
            + "1. Open the login page\n"
            + "2. Leave the email address field empty and click the Create an account button\n"
            + "3. Verify the login page is sucesfully displayed and the error message is correct\n")
    void accessCreateAccountPageWithEmptyEmail() {
        this.loginPage.open();
        this.loginPage.verify();

        this.loginPage.submitEmailAccountCreation("");
        this.loginPage.verify();

        Assert.assertEquals(this.loginPage.getCreateAccountErrorText(), EMPTY_INVALID_EMAIL_ERROR);
    }

    @Test(description = "Test navigating to create account page with empty email\n"
            + "Steps:\n"
            + "1. Open the login page\n"
            + "2. Insert an email address already used and click the Create an account button\n"
            + "3. Verify the login page is sucesfully displayed and the error message is correct\n")
    void accessCreateAccountPageWithDuplicateEmail() {
        this.loginPage.open();
        this.loginPage.verify();

        this.loginPage.submitEmailAccountCreation(DUPLICATE_EMAIL);
        this.loginPage.verify();

        Assert.assertEquals(this.loginPage.getCreateAccountErrorText(), DUPLICATE_EMAIL_ERROR);
    }

    @Test(description = "Test navigating to create account page with empty email\n"
            + "Steps:\n"
            + "1. Open the login page\n"
            + "2. Insert a unique email address and click the Create an account button\n"
            + "3. Verify the create account page is sucesfully displayed\n"
            + "4. Fill the form with valid details and click the Register button\n"
            + "5. Verify the my account page is sucesfully displayed\n")
    void createAccountValidDetails() {
        Account account = new Account.Builder()
                .gender(generateRandomGender())
                .firstName(generateRandomString(10))
                .lastName(generateRandomString(8))
                .password(generateRandomString(10))
                .homePhone(generateRandomPhoneNumber())
                .mobilePhone(generateRandomPhoneNumber())
                .address1(generateRandomString(50))
                .city(generateRandomString(6))
                .zip(generateRandomZipCode())
                .state(generateRandomState())
                .yearOfBirth(generateRandomYear())
                .monthOfBirth(generateRandomMonth())
                .dayOfBirth(generateRandomDay())
                .build();

        this.loginPage.open();
        this.loginPage.verify();

        this.loginPage.submitEmailAccountCreation(generateValidEmailAddress());
        this.createAccountPage.verify();

        this.createAccountPage.fillGenderField(account.getGender());
        this.createAccountPage.fillFirstNameField(account.getFirstName());
        this.createAccountPage.fillLastNameField(account.getLastName());
        this.createAccountPage.fillPasswordField(account.getPassword());
        this.createAccountPage.fillHomePhoneField(account.getHomePhone());
        this.createAccountPage.fillMobilePhoneField(account.getMobilePhone());
        this.createAccountPage.fillAddress1Field(account.getAddress1Address());
        this.createAccountPage.fillCityField(account.getCityAddress());
        this.createAccountPage.fillZipCodeField(account.getZipAddress());
        this.createAccountPage.fillStateField(account.getStateOptionAddress());
        this.createAccountPage.fillDayOfBirthField(account.getDayOfBirth());
        this.createAccountPage.fillYearsOfBirthField(account.getYearOfBirth());
        this.createAccountPage.fillMonthsOfBirthField(account.getMonthOfBirth());

        this.createAccountPage.register();
        this.myAccountPage.verify();

        Assert.assertEquals(this.myAccountPage.getUsernameText(), account.getFirstName() + " " + account.getLastName());
    }

    @Test(description = "Test navigating to create account page with empty email\n"
            + "Steps:\n"
            + "1. Open the login page\n"
            + "2. Insert a unique email address and click the Create an account button\n"
            + "3. Verify the create account page is sucesfully displayed\n"
            + "4. Leave the form empty and click the Register button\n"
            + "5. Verify the create account page is sucesfully displayed and the error message is correct\n")
    void registerEmptyForm() {
        this.loginPage.open();
        this.loginPage.verify();

        this.loginPage.submitEmailAccountCreation(generateValidEmailAddress());
        this.createAccountPage.verify();

        this.createAccountPage.register();
//        this.createAccountPage.verify();

        Assert.assertEquals(this.createAccountPage.getCreateAccountErrorText(), EMPTY_FORM_ERROR);
    }


}
