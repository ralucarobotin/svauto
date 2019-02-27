package tests;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
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

  public LoginTest(){
    this.email = getPropertyFromAppProp("email");
    this.password = getPropertyFromAppProp("password");
    this.invalidEmail = getPropertyFromAppProp("invalidEmail");
    this.invalidPassword = getPropertyFromAppProp("invalidPassword");

  }

  @BeforeMethod
  void beforeMethod(){
    this.dashboardPage = new DashboardPage(getDriver());
    this.loginPage = new LoginPage(getDriver());
    this.myAccountPage = new MyAccountPage(getDriver());
  }

  @Test (priority = 3)
  public void testLogin(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, password);

    this.myAccountPage.verify();
  }

  @Test (priority = 0)
  public void emptyEmailField(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(StringUtils.EMPTY, password);

    this.loginPage.verify();
    Assert.assertTrue(loginPage.getErrorBanner().isDisplayed(), "The error message is displayed.");
    Assert.assertEquals(this.loginPage.getSignInErrorText(), LoginPage.EMPTY_EMAIL_ERROR, "The email required error text did not match.");
  }

    @Test (priority = 1)
    public void emptyPasswordField(){
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login(email, StringUtils.EMPTY);

        this.loginPage.verify();
        Assert.assertTrue(loginPage.getErrorBanner().isDisplayed(), "The error message is displayed.");
        Assert.assertEquals(this.loginPage.getSignInErrorText(), LoginPage.EMPTY_PASSWORD_ERROR, "The password required error text did not match.");
    }

    @Test (priority = 2)
    public void invalidAuthentication(){
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.loginPage.verify();
        this.loginPage.login(invalidEmail, invalidPassword);

        this.loginPage.verify();
        Assert.assertTrue(loginPage.getErrorBanner().isDisplayed(), "The error message is displayed.");
        Assert.assertEquals(this.loginPage.getSignInErrorText(), LoginPage.FAILED_AUTHENTICATION_ERROR,"The authentication failed error text did not match." );
    }
}
