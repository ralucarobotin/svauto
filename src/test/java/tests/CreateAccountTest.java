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

    private static final String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
    private static final String UNIQUE_EMAIL_FOR_REGISTRATION = RandomStringUtils.random(10, allowedChars) + "@test.com";
    private static final String EMPTY_INVALID_EMAIL_ERROR = "Invalid email address.";

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

        Assert.assertEquals(loginPage.getAccountCreateEmailError(), EMPTY_INVALID_EMAIL_ERROR);
    }
}
