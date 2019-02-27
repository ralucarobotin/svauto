package tests;

import helpers.Utilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.NewAccountPage;

import static helpers.Utilities.getPropertyFromAppProp;

public class NewAccountTest extends BaseTest {
    private DashboardPage dashboardPage = null;
    private LoginPage loginPage = null;
    private MyAccountPage myAccountPage = null;
    private NewAccountPage newAccountPage = null;

    public NewAccountTest() {}

    @BeforeMethod
    void beforeMethod() {
        this.dashboardPage = new DashboardPage(getDriver());
        this.loginPage = new LoginPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
        this.newAccountPage = new NewAccountPage(getDriver());
    }


    @Test
    public void testCreateAccountPage() {
        dashboardPage.verify();
        dashboardPage.clickLoginButton();
        loginPage.verify();
        newAccountPage.fillEmailAddress(getPropertyFromAppProp("email"));
        newAccountPage.clickCreateAccount();
    }

}
