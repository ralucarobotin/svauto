package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uiPages.LoginPage;
import pages.MyAccountPage;

import static helpers.Utilities.getPropertyFromAppProp;

public class LoginTest extends BaseTest {

    private LoginPage loginPage = null;
    private MyAccountPage myAccountPage = null;

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
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    @Test
    public void testNegativeLogin() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(email, password);
        String errorMessage = this.loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, this.loginPage.getExpectedLoginErrMsg("wrongLogIn"), "The error message is " +
            "not correct.");
    }

    @Test
    public void testNegativeLoginNoEmail() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.loginPassword(passwordValid);
        String noUserErrorMessage = this.loginPage.getErrorMessage();
        Assert.assertEquals(noUserErrorMessage, this.loginPage.getExpectedLoginErrMsg("noUser"), "The error message is " +
                "not correct.");
    }

    @Test
    public void testNegativeLoginNoPass() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.loginEmail(emailValid);
        String noPassErrorMessage = this.loginPage.getErrorMessage();
        Assert.assertEquals(noPassErrorMessage, this.loginPage.getExpectedLoginErrMsg("noPassword"), "The error message is " +
                "not correct.");
    }

    @Test
    public void testNegativeLoginNoEmailNoPass() {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.clickLoginButton();
        String noUserErrorMessage = this.loginPage.getErrorMessage();
        Assert.assertEquals(noUserErrorMessage, this.loginPage.getExpectedLoginErrMsg("noUser"), "The error message is " +
                "not correct.");
    }

    @Test
    public void testPositiveLogin() throws InterruptedException {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(emailValid, passwordValid);
        boolean isLogInMessage = myAccountPage.isLogInMessage();
        Assert.assertEquals(isLogInMessage, true, "The log in message does NOT appear.");
    }
}
