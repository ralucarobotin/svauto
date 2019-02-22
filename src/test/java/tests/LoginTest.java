package tests;

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

  public LoginTest(){
    this.email = "";
    this.password = "";
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

    //Add assertion for the error message
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

    //Add assertion for the error message
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

  //Add assertion for the error message
}
}
