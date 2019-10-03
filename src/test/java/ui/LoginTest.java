package ui;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uiPages.LoginPage;

import static helpers.Utilities.getPropertyFromAppProp;

public class LoginTest extends BaseTest {

    private LoginPage loginPage = null;

    private String email;
    private String password;

    public LoginTest() {
        this.email = getPropertyFromAppProp("email");
        this.password = getPropertyFromAppProp("password");
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
        Assert.assertEquals(errorMessage, this.loginPage.getWrongLoginErrMsg(), "The error message is " +
            "not correct.");
    }

    @Test
    public void testLoginEmptyPass(){
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(email, StringUtils.EMPTY);
        String errorMessage = this.loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, this.loginPage.getEmptyPassLoginErrMsg(), "The empty " +
            "password error message is not correct.");
    }
}
