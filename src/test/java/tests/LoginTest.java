package tests;

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

    public LoginTest() {
        this.email = getPropertyFromAppProp("email");
        this.password = getPropertyFromAppProp("password");
        this.invalidEmail = getPropertyFromAppProp("invalidEmail");
        this.invalidPassword = getPropertyFromAppProp("invalidPassword");
    }

    @BeforeMethod
    void beforeMethod() {
        this.dashboardPage = new DashboardPage(getDriver());
        this.loginPage = new LoginPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    @Test(priority = 0)
    public void testNoCredentials() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login("", "");
    }

    @Test(priority = 1)
    public void testNoMail() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login("", password);
    }

    @Test(priority = 2)
    public void testNoPassword() {
        dashboardPage.open();
        dashboardPage.verify();
        dashboardPage.clickLoginButton();

        loginPage.verify();
        loginPage.login(email, "");
    }

    @Test(priority = 3)
    public void testInvalidMail() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login(invalidEmail, password);
    }

    @Test(priority = 4)
    public void testInvalidPassword() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login(email, invalidPassword);

        this.loginPage.verify();
    }

    @Test(priority = 5)
    public void testLogin() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login(email, password);

        this.myAccountPage.verify();
    }
}
