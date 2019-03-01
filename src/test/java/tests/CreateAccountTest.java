package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyAccountPage;

public class CreateAccountTest extends BaseTest {
    private DashboardPage dashboardPage = null;
    private LoginPage loginPage = null;
    private CreateAccountPage createAccountPage = null;

    private static final String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
    private static final String UNIQUE_EMAIL_FOR_REGISTRATION = RandomStringUtils.random(10, allowedChars) + "@test.com";

    public CreateAccountTest() {
    }

    @BeforeMethod
    void beforeMethod() {
        this.dashboardPage = new DashboardPage(getDriver());
        this.loginPage = new LoginPage(getDriver());
        this.createAccountPage = new CreateAccountPage(getDriver());
    }

    @Test
    void navigateToAccountCreationPage() {
        this.dashboardPage.open();
        ;
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.submitEmailAccountCreation(UNIQUE_EMAIL_FOR_REGISTRATION);

        this.createAccountPage.verify();


    }


}
