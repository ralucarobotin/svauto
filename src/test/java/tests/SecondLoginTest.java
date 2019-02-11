package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.MyAccountPage;

import static helpers.Utilities.getPropertyFromAppProp;

public class SecondLoginTest extends BaseTest {

    private DashboardPage dashboardPage = null;
    private MyAccountPage myAccountPage = null;

    private String email;
    private String password;

    public SecondLoginTest(){
        this.email = getPropertyFromAppProp("email");
        this.password = getPropertyFromAppProp("password");
    }

    @Test
    public void testLogin(){
        this.dashboardPage = new DashboardPage(getDriver());
        this.dashboardPage.login(this.email, this.password);
        this.myAccountPage = new MyAccountPage(getDriver());

        Assert.assertEquals(myAccountPage.isMyAccountPageDisplayed(), true,
                "The account page didn't load after login.");
    }
}