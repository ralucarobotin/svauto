package tests;

<<<<<<< HEAD
import org.apache.commons.lang3.StringUtils;
=======
>>>>>>> First commit
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
<<<<<<< HEAD
    this.emptyEmail = StringUtils.EMPTY;
    this.emptyPassword = StringUtils.EMPTY;
=======
    this.emptyEmail = "";
    this.emptyPassword = "";
>>>>>>> First commit
  }

  @BeforeMethod
  void beforeMethod(){
    this.dashboardPage = new DashboardPage(getDriver());
    this.loginPage = new LoginPage(getDriver());
    this.myAccountPage = new MyAccountPage(getDriver());
  }
  //Happy flow login
<<<<<<< HEAD
  @Test
=======
  @Test(priority = 5)
>>>>>>> First commit
  public void testLogin(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, password);
    this.myAccountPage.verify();
  }
  //Negative testing flow
<<<<<<< HEAD
  @Test
=======
  @Test(priority = 3)
>>>>>>> First commit
  public void testInvalidEmail(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(invalidEmail, password);
<<<<<<< HEAD
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
  }

  @Test
=======
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());

    this.loginPage.verify();
  }

  @Test(priority = 4)
>>>>>>> First commit
  public void testInvalidPassword(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, invalidPassword);
<<<<<<< HEAD
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
  }

  @Test
=======
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());

    this.loginPage.verify();
  }

  @Test(priority = 1)
>>>>>>> First commit
  public void testEmptyEmail(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(emptyEmail, password);
<<<<<<< HEAD
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
  }

  @Test
=======
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());

    this.loginPage.verify();
  }

  @Test(priority = 2)
>>>>>>> First commit
  public void testEmptyPassword(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, emptyPassword);
<<<<<<< HEAD
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
=======
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());

    this.loginPage.verify();
>>>>>>> First commit
  }
}
