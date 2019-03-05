package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;

import static testHelpers.Utilities.*;

public class CreateAccountTest extends BaseTest {
    private LoginPage loginPage = null;
    private CreateAccountPage createAccountPage = null;

    private static final String DUPLICATE_EMAIL = "test@test.com";

    private static final String EMPTY_INVALID_EMAIL_ERROR = "Invalid email address.";
    private static final String DUPLICATE_EMAIL_ERROR = "An account using this email address has already been registered. Please enter a valid password or request a new one.";

    public CreateAccountTest() {
    }

    @BeforeMethod
    void beforeMethod() {
        this.loginPage = new LoginPage(getDriver());
        this.createAccountPage = new CreateAccountPage(getDriver());
    }

    @Test
    void navigateToAccountCreationPage() {
        this.loginPage.open();
        this.loginPage.verify();

        this.loginPage.submitEmailAccountCreation(generateValidEmailAddress());
        this.createAccountPage.verify();
    }

    @Test
    void accessCreateAccountPageWithEmptyEmail() {
        this.loginPage.open();
        this.loginPage.verify();

        this.loginPage.submitEmailAccountCreation("");
        this.loginPage.verify();

        Assert.assertEquals(this.loginPage.getCreateAccountErrorText(), EMPTY_INVALID_EMAIL_ERROR);
    }

    @Test
    void accessCreateAccountPageWithDuplicateEmail() {
        this.loginPage.open();
        this.loginPage.verify();

        this.loginPage.submitEmailAccountCreation(DUPLICATE_EMAIL);
        this.loginPage.verify();

        Assert.assertEquals(this.loginPage.getCreateAccountErrorText(), DUPLICATE_EMAIL_ERROR);
    }

    @Test
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
                .build();

        this.loginPage.open();
        this.loginPage.verify();

        this.loginPage.submitEmailAccountCreation(generateValidEmailAddress());
        this.createAccountPage.verify();

        this.createAccountPage.fillFirstNameField(account.getFirstName());
        this.createAccountPage.fillLastNameField(account.getLastName());
        this.createAccountPage.fillPasswordField(account.getPassword());
        this.createAccountPage.fillHomePhoneField(account.getHomePhone());
        this.createAccountPage.fillMobilePhoneField(account.getMobilePhone());
        this.createAccountPage.fillAddress1Field(account.getAddress1Address());
        this.createAccountPage.fillCityField(account.getCityAddress());
        this.createAccountPage.fillZipCodeField(account.getZipAddress());
        this.createAccountPage.fillStateField(account.getStateOptionAddress());
        this.createAccountPage.register();

        System.out.println("test");

    }
}
