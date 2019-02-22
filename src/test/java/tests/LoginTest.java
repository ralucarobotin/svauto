package tests;

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

  private String email = "";
  private String password = "";

  private static final String INVALID_EMAIL_ERROR = "Invalid email address.";
  private static final String EMPTY_EMAIL_ERROR   = "An email address required.";
  private static final String AUTHENTIFICATION_FAILED_ERROR = "Authentication failed.";

  public LoginTest(){
  }

  public void setEmail(String email){
    this.email = getPropertyFromAppProp(email);
  }

  public void setPassword(String password) {
    this.password = getPropertyFromAppProp(password);
  }

  public void setEmail(){
    this.email = "";
  }

  public void setPassword(){
    this.password = "";
  }

  @BeforeMethod
  void beforeMethod(){
    this.dashboardPage = new DashboardPage(getDriver());
    this.loginPage = new LoginPage(getDriver());
    this.myAccountPage = new MyAccountPage(getDriver());
  }

  @Test
  public void testLogin(){
    setEmail("email");
    setPassword("password");

    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, password);

    this.myAccountPage.verify();
  }

  @Test
  public void testLoginInvalidEmailInvalidPassword(){
    setEmail("invalidEmail");
    setPassword("invalidPassword");

    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, password);

    this.loginPage.verify();
    Assert.assertEquals(this.loginPage.getLoginError().getText(), INVALID_EMAIL_ERROR);

  }

  @Test
  public void testLoginEmptyEmailEmptyPassword(){
    setEmail();
    setPassword();

    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, password);

    this.loginPage.verify();
    Assert.assertEquals(this.loginPage.getLoginError().getText(), EMPTY_EMAIL_ERROR);
  }

  @Test void testLoginWrongEmailWrongPassword(){
    setEmail("wrongEmail");
    setPassword("wrongPassword");

    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, password);

    this.loginPage.verify();
    Assert.assertEquals(this.loginPage.getLoginError().getText(), AUTHENTIFICATION_FAILED_ERROR);
}
}
