package tests;

import helpers.Utilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.NewAccountPage;

public class NewAccountTest extends BaseTest {
    private MyAccountPage myAccountPage = null;
    private NewAccountPage newAccountPage = null;
    private LoginPage loginPage = null;

    public NewAccountTest() {}

    @BeforeMethod
    void beforeMethod() {
        this.myAccountPage = new MyAccountPage(getDriver());
        this.newAccountPage = new NewAccountPage(getDriver());
    }

    @Test
    public void testCreateAccountPage() {
        loginPage.openLoginPage();
        loginPage.fillEmailAddress(Utilities.generateNewEmail("mailinator"));
        loginPage.clickCreateAccount();
    }

}
