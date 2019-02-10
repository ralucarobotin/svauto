package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyAccountPage;

import static helpers.Utilities.getPropertyFileContent;
import static helpers.Utilities.getPropertyValue;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        MyAccountPage myAccountPage = dashboardPage.header.clickLogin()
                .login(getEmail(), getPassword());
        Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed(),
                "The account page didn't load after login.");
    }
}