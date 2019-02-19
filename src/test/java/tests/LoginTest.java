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

    public LoginTest() {
        this.email = getPropertyFromAppProp("email");
        this.password = getPropertyFromAppProp("password");
    }

    @BeforeMethod
    void beforeMethod() {
        this.dashboardPage = new DashboardPage(getDriver());
        this.loginPage = new LoginPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    @Test(priority = 0)
    public void testEmptyCredentials() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login("", "");

        this.loginPage.verify();
    }

    @Test(priority = 1)
    public void testEmptyEmail() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login("", password);

        this.loginPage.verify();
    }

    @Test(priority = 2)
    public void testEmptyPassword() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login(email, "");

        this.loginPage.verify();
    }

    @Test(priority = 3)
    public void testInvalidEmail() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login("daniela", password);

        this.loginPage.verify();
    }

    @Test(priority = 4)
    public void testInvalidPassword() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login(email, "testtest");

        this.loginPage.verify();
    }

    @Test(priority = 5)
    public void testInvalidCredentials() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login("test@yahoo.com", "testtest");

        this.loginPage.verify();
    }

    @Test(priority = 6)
    public void testLogin() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login(email, password);

        this.myAccountPage.verify();
    }
}
