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
  private String emptyEmail;
  private String emptyPassword;

  public LoginTest(){
    this.email = getPropertyFromAppProp("email");
    this.password = getPropertyFromAppProp("password");
    this.invalidEmail = getPropertyFromAppProp("invalidEmail");
    this.invalidPassword = getPropertyFromAppProp("invalidPassword");
    this.emptyEmail = "";
    this.emptyPassword = "";
  }

  @BeforeMethod
  void beforeMethod(){
    this.dashboardPage = new DashboardPage(getDriver());
    this.loginPage = new LoginPage(getDriver());
    this.myAccountPage = new MyAccountPage(getDriver());
  }
  //Happy flow login
  @Test
  public void testLogin(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, password);
    this.myAccountPage.verify();
  }
  //Negative testing flow
  @Test
  public void testInvalidEmail(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(invalidEmail, password);
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
  }

  @Test
  public void testInvalidPassword(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, invalidPassword);
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
  }

  @Test
  public void testEmptyEmail(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(emptyEmail, password);
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
  }

  @Test
  public void testEmptyPassword(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, emptyPassword);
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
  }
}
