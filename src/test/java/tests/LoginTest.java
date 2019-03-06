package tests;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyAccountPage;

import static helpers.Utilities.getPropertyFromAppProp;

public class LoginTest extends BaseTest {
    private final static String EMPTY_CREDENTIALS_ERROR = "An email address required.";
    private final static String EMPTY_PSW_ERROR = "Password is required.";
    private final static String INVALID_EMAIL_ERROR = "Invalid email address.";
    private final static String INVALID_CREDENTIALS_ERROR = "Authentication failed.";

    private DashboardPage dashboardPage = null;
    private LoginPage loginPage = null;
    private MyAccountPage myAccountPage = null;

    private String email;
    private String password;
    private String emailInvalidFormat;
    private String emailInvalid;
    private String pswInvalid;
    private String emptyEmail;
    private String emptyPsw;

    public LoginTest() {
        this.email = getPropertyFromAppProp("email");
        this.password = getPropertyFromAppProp("password");
        this.emailInvalid = getPropertyFromAppProp("invalidEmail");
        this.emailInvalidFormat = getPropertyFromAppProp("invalidEmailFormat");
        this.pswInvalid = getPropertyFromAppProp("invalidPsw");
        this.emptyEmail = StringUtils.EMPTY;
        this.emptyPsw = StringUtils.EMPTY;
    }

    @BeforeMethod
    void beforeMethod() {
        this.dashboardPage = new DashboardPage(getDriver());
        this.loginPage = new LoginPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    @Test(description = "[Happy Flow] Test login with valid Email Address and Password of a registered account\n"
            + "Steps:\n"
            + "1.Navigate to Dashboard page URL: http://automationpractice.com/index.php\n"
            + "2.Click Sign in button\n"
            + "3.Fill in the Email address and Password fields with valid data of a registered account\n"
            + "4.Click Sign in button\n"
            + "5.Verify that sign in is successfully performed\n")
    public void testLogin() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        Assert.assertTrue(this.loginPage.getPageHeadingLogin(), "Login page heading is displayed");

        this.loginPage.login(this.email, this.password);

        this.myAccountPage.verify();
        Assert.assertTrue(this.myAccountPage.getPageHeadingMyAccount(), "My Account page heading is displayed");
    }

    @Test(description = "[Happy Flow] Test login and logout flow\n"
            + "Steps:\n"
            + "1.Navigate to Login page URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n"
            + "2.Fill in the Email address and Password fields with valid data of a registered account\n"
            + "3.Click Sign in button\n"
            + "4.Verify that sign in is successfully performed\n"
            + "5.Click Sign out button\n"
            + "6.Verify that sign out is successfully performed\n")
    public void testLogout() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(email, password);

        this.myAccountPage.verify();
        Assert.assertTrue(this.myAccountPage.getPageHeadingMyAccount(), "My Account page heading is displayed");

        this.myAccountPage.clickLogoutButton();

        this.loginPage.verify();
        Assert.assertTrue(this.loginPage.getPageHeadingLogin(), "Login page heading is displayed");
    }

    @Test(description = "Test login with empty credentials\n"
            + "Steps:\n"
            + "1.Navigate to Login page URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n"
            + "2.Without typing anything in Email address and Password fields, click Sign in button\n"
            + "3.Verify that the specific error is displayed\n")
    public void testEmptyCredentials() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.clickSignInButton();

        this.loginPage.verify();
        Assert.assertTrue(this.loginPage.getLoginError(), "Error is displayed");
        Assert.assertEquals(this.loginPage.getLoginErrorMsg(), EMPTY_CREDENTIALS_ERROR, "Text errors do not match");
    }

    @Test(description = "Test login with empty Email address\n"
            + "Steps:\n"
            + "1.Navigate to Login page URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n"
            + "2.Fill in the Password field, leaving Email address field empty\n"
            + "3.Click Sign in button\n"
            + "4.Verify that the specific error is displayed\n")
    public void testEmptyEmail() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(this.emptyEmail, this.password);

        this.loginPage.verify();
        Assert.assertTrue(this.loginPage.getLoginError(), "Error is displayed");
        Assert.assertEquals(this.loginPage.getLoginErrorMsg(), EMPTY_CREDENTIALS_ERROR, "Text errors do not match");
    }

    @Test(description = "Test login with empty Password\n"
            + "Steps:\n"
            + "1.Navigate to Login page URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n"
            + "2.Fill in the Email address field, leaving Password field empty\n"
            + "3.Click Sign in button\n"
            + "4.Verify that the specific error is displayed\n")
    public void testEmptyPassword() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(this.email, this.emptyPsw);

        this.loginPage.verify();
        Assert.assertTrue(this.loginPage.getLoginError(), "Error is displayed");
        Assert.assertEquals(this.loginPage.getLoginErrorMsg(), EMPTY_PSW_ERROR, "Text errors do not match");
    }

    @Test(description = "Test login with Email address invalid format\n"
            + "Steps:\n"
            + "1.Navigate to Login page URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n"
            + "2.Fill in the Email address field with an invalid format\n"
            + "3.Fill in the Password field\n"
            + "4.Click Sign in button\n"
            + "5.Verify that the specific error is displayed\n")
    public void testInvalidEmailFormat() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(this.emailInvalidFormat, this.password);

        this.loginPage.verify();
        Assert.assertTrue(this.loginPage.getLoginError(), "Error is displayed");
        Assert.assertEquals(this.loginPage.getLoginErrorMsg(), INVALID_EMAIL_ERROR, "Text errors do not match");
    }

    @Test(description = "Test login with invalid Password\n"
            + "Steps:\n"
            + "1.Navigate to Login page URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n"
            + "2.Click Sign in button\n"
            + "3.Fill in the Email address field with valid data\n"
            + "4.Fill in the Password field with invalid data\n"
            + "5.Click Sign in button\n"
            + "6.Verify that the specific error is displayed\n")
    public void testInvalidPassword() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(this.email, this.pswInvalid);

        this.loginPage.verify();
        Assert.assertTrue(this.loginPage.getLoginError(), "Error is displayed");
        Assert.assertEquals(this.loginPage.getLoginErrorMsg(), INVALID_CREDENTIALS_ERROR, "Text errors do not match");
    }

    @Test(description = "Test login with valid Email Address and Password of an account not registered\n"
            + "Steps:\n"
            + "1.Navigate to Login page URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n"
            + "2.Fill in the Email address and Password fields with valid data of an account never registered\n"
            + "4.Click Sign in button\n"
            + "5.Verify that the specific error is displayed\n")
    public void testInvalidCredentials() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(this.emailInvalid, this.pswInvalid);

        this.loginPage.verify();
        Assert.assertTrue(this.loginPage.getLoginError(), "Error is displayed");
        Assert.assertEquals(this.loginPage.getLoginErrorMsg(), INVALID_CREDENTIALS_ERROR, "Text errors do not match  ");
    }
}
