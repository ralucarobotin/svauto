package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uiPages.LoginPage;

import static helpers.Utilities.getPropertyFromAppProp;

public class LoginTest extends BaseTest {

    private LoginPage loginPage = null;

    private String email;
    private String password;
    private String emailValid;
    private String passwordValid;

    public LoginTest() {
        this.email = getPropertyFromAppProp("email");
        this.password = getPropertyFromAppProp("password");
        this.emailValid = getPropertyFromAppProp("emailValid");
        this.passwordValid = getPropertyFromAppProp("passwordValid");
    }

    @BeforeMethod
    void beforeMethod() {
        this.loginPage = new LoginPage(getDriver());
    }

    @Test
    public void testNegativeLogin() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(email, password);
        String errorMessage = this.loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, this.loginPage.getExpectedLoginErrMsg(), "The error message is " +
            "not correct.");
    }

    @Test
    public void testPositiveLogin() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(emailValid, passwordValid);
        boolean isLogInMessage = this.loginPage.isLogInMessage();
        Assert.assertEquals(isLogInMessage, true, "The log in message does NOT appear.");
    }
}
