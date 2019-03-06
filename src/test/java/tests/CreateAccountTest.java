package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CreateAccountTest extends BaseTest {

    private DashboardPage dashboardPage = null;
    private LoginPage loginPage = null;
    private CreateAnAccount createAnAccount = null;



    @BeforeMethod
    void beforeMethod(){
        this.dashboardPage = new DashboardPage(getDriver());
        this.loginPage = new LoginPage(getDriver());
        this.createAnAccount = new CreateAnAccount(getDriver());

    }

    @Test
    public void testInput() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail();
        this.loginPage.clickCreateAccountButton();
        this.createAnAccount.verify();
        this.createAnAccount.inputCustomerFirstName();
        this.createAnAccount.inputCustomerLastName();
        this.createAnAccount.inputHomePhone();
        this.createAnAccount.verify();
    }
}
