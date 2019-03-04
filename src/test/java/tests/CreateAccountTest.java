package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;

public class CreateAccountTest extends BaseTest {
    private LoginPage loginPage = null;
    private CreateAccountPage createAccountPage = null;

    private static final String ALLOWERCHARS = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
    private static final String UNIQUE_EMAIL_FOR_REGISTRATION = RandomStringUtils.random(10, ALLOWERCHARS) + "@test.com";
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

        this.loginPage.submitEmailAccountCreation(UNIQUE_EMAIL_FOR_REGISTRATION);
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
    void accessCreateAccountPageWithDuplicateEmail(){
        this.loginPage.open();;
        this.loginPage.verify();

        this.loginPage.submitEmailAccountCreation(DUPLICATE_EMAIL);
        this.loginPage.verify();

        Assert.assertEquals(this.loginPage.getCreateAccountErrorText(), DUPLICATE_EMAIL_ERROR);
    }
}
