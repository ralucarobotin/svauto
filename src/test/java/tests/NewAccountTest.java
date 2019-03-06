package tests;

import helpers.Utilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.NewAccountPage;

public class NewAccountTest extends BaseTest {
    private MyAccountPage myAccountPage = null;
    private NewAccountPage newAccountPage = null;
    private LoginPage loginPage = null;
    private DashboardPage dashboardPage = null;

    @BeforeMethod
    void beforeMethod() {
        this.dashboardPage = new DashboardPage(getDriver());
        this.loginPage = new LoginPage(getDriver());
        this.newAccountPage = new NewAccountPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    @Test
    public void testRegisterButton() {
        dashboardPage.open();
        dashboardPage.clickLoginButton();
        loginPage.verify();
        loginPage.fillEmailAddress(Utilities.generateNewEmail("mailinator"));
        loginPage.clickCreateAccount();
        newAccountPage.verify();
    }

}
