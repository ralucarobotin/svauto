package tests;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyAccountPage;

import static helpers.Utilities.getPropertyFromAppProp;

public class LoginTest extends BaseTest {

    private DashboardPage dashboardPage = null;
    private LoginPage loginPage = null;
    private MyAccountPage myAccountPage = null;

    private String email;
    private String password;
    private String invalidEmail;
    private String invalidPassword;
    private String emailRequired;
    private String passwordRequired;
    private String failedAuthenticationMessage;

    public LoginTest() {
        this.email = getPropertyFromAppProp("email");
        this.password = getPropertyFromAppProp("password");
        this.invalidEmail = getPropertyFromAppProp("invalidEmail");
        this.invalidPassword = getPropertyFromAppProp("invalidPassword");
        this.emailRequired = "An email address required.";
        this.passwordRequired = "Password is required.";
        this.failedAuthenticationMessage = "Authentication failed.";
    }

    @BeforeMethod
    void beforeMethod() {
        this.dashboardPage = new DashboardPage(getDriver());
        this.loginPage = new LoginPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    //Happy flow login
    @Test(description = "Test login with valid credentials:\n " +
            "Steps:\n" +
            "1. Navigate to the Dashboard page with URL: http://automationpractice.com/index.php\n" +
            "2. Verify that the Dashboard page is loaded correctly.\n" +
            "3. Click on the Sign in button.\n" +
            "4. Verify that the Login page is loaded correctly.\n" +
            "5. Add valid credentials into the email and password fields.\n" +
            "6. Verify that the introduced credentials are valid.\n" +
            "7. Click on the Sign in button.\n" +
            "8. Verify that the user is redirected correctly to the MyAccount page.\n"
    )
    public void testLogin() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();
        this.loginPage.verify();
        this.loginPage.login(email, password);
        this.myAccountPage.verify();
    }

    //Negative testing flow
    @Test(description = "Test login with invalid email:\n " +
            "Steps:\n" +
            "1. Navigate to the Login page with URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n" +
            "2. Verify that the Login page is loaded correctly.\n" +
            "3. Add valid credential for password and invalid credential into the email field.\n" +
            "4. Click on the Sign in button.\n" +
            "5. Verify that the expected error message is displayed.\n"
    )
    public void testInvalidEmail() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.login(invalidEmail, password);
        this.loginPage.verify();
        Assert.assertEquals(this.loginPage.getLoginPageErrorMessage(), failedAuthenticationMessage, "Test for invalid input in the email field, has failed");
    }

    @Test(description = "Test login with invalid password:\n " +
            "Steps:\n" +
            "1. Navigate to the Login page with URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n" +
            "2. Verify that the Login page is loaded correctly.\n" +
            "3. Add valid credential for email and invalid credential into the password field.\n" +
            "4. Click on the Sign in button.\n" +
            "5. Verify that the expected error message is displayed.\n"
    )
    public void testInvalidPassword() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.login(email, invalidPassword);
        this.loginPage.verify();
        Assert.assertEquals(this.loginPage.getLoginPageErrorMessage(), failedAuthenticationMessage, "Test for invalid input in the password field, has failed");
    }

    @Test(description = "Test login with empty email:\n " +
            "Steps:\n" +
            "1. Navigate to the Login page with URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n" +
            "2. Verify that the Login page is loaded correctly.\n" +
            "3. Leave the field for email empty and add valid credential into the password field.\n" +
            "4. Click on the Sign in button.\n" +
            "5. Verify that the expected error message is displayed.\n"
    )
    public void testEmptyEmail() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.login(StringUtils.EMPTY, password);
        this.loginPage.verify();
        Assert.assertEquals(this.loginPage.getLoginPageErrorMessage(), emailRequired, "Test for empty input in the email field, has failed");
    }

    @Test(description = "Test login with empty email:\n " +
            "Steps:\n" +
            "1. Navigate to the Login page with URL: http://automationpractice.com/index.php?controller=authentication&back=my-account\n" +
            "2. Verify that the Login page is loaded correctly.\n" +
            "3. Leave the field for password empty and add valid credential into the email field.\n" +
            "4. Click on the Sign in button.\n" +
            "5. Verify that the expected error message is displayed.\n"
    )
    public void testEmptyPassword() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.login(email, StringUtils.EMPTY);
        this.loginPage.verify();
        Assert.assertEquals(this.loginPage.getLoginPageErrorMessage(), passwordRequired, "Test for empty input in the password field, has failed");
    }
}
