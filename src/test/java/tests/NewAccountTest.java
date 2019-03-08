package tests;

import helpers.Utilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.MyAccountPage;
import pages.NewAccountPage;
import pages.RegistrationPage;

public class NewAccountTest extends BaseTest {
    private MyAccountPage myAccountPage = null;
    private NewAccountPage newAccountPage = null;
    private DashboardPage dashboardPage = null;
    private RegistrationPage registrationPage = null;

    @BeforeMethod
    void beforeMethod() {
        this.dashboardPage = new DashboardPage(getDriver());
        this.registrationPage = new RegistrationPage(getDriver());
        this.newAccountPage = new NewAccountPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    @Test(description = "Tests the first part of the flow, email validation - happy flow\n"
            + "Steps:\n"
            + "1. Open the Sign in page.\n"
            + "2. Fill in a valid, unused email address.\n"
            + "3. Click Create Account.\n"
            + "4. Verify that the Create account form is displayed.\n")
    public void testCreateAccountButton() {
        dashboardPage.open();
        dashboardPage.clickLoginButton();
        registrationPage.verify();
        registrationPage.fillEmailAddress(Utilities.generateNewEmail("mailinator.com"));
        registrationPage.waitForElementToAppear(registrationPage.getCreateAccountButton());
        registrationPage.clickCreateAccount();

        newAccountPage.verify();
    }

    @Test(priority = 1,
            description = "Create new account form validation - happy flow\n"
                    + "Steps:\n"
                    + "1. Open the Sign in page.\n"
                    + "2. Fill in email and click create account.\n"
                    + "3. Verify the email field is autocompleted.\n"
                    + "4. Verify the first name field is autocompleted.\n"
                    + "5. Verify the last name field is autocompleted.\n"
                    + "6. Click the Register button to complete the flow.\n"
                    + "7. Verify that the My Account page is displayed.\n")
    public void createAccount() {
        registrationPage.open();
        registrationPage.gotoCreateAccountForm();

        Assert.assertTrue(newAccountPage.verifyEmailAutofill(), "Email address was not auto-filled");
        newAccountPage.fillCreateAccountForm();
        Assert.assertTrue(newAccountPage.verifyFirstNameAutofill(), "First name was not auto-filled");
        Assert.assertTrue(newAccountPage.verifyLastNameAutofill(), "Last name was not auto-filled");
        newAccountPage.clickRegisterButton();

        myAccountPage.verify();
    }

    @Test
    public void emptyFieldErrors() {

    }

}
