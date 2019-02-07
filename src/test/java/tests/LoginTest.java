package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.MyAccountPage;

import static helpers.Utilities.getPropertyFileContent;
import static helpers.Utilities.getPropertyValue;

public class LoginTest extends BaseTest {

  private String email;
  private String password;

  public LoginTest(){}

  @Factory(dataProvider = "dataProvider")
  public LoginTest(String email, String password){
    this.email = email;
    this.password = password;
  }

  @DataProvider
  public Object[][] dataProvider(){
    return new Object[][]{
        {
          getPropertyValue(getPropertyFileContent(APP_FILE), "email"),
          getPropertyValue(getPropertyFileContent(APP_FILE), "password")
        },
        {
          getPropertyValue(getPropertyFileContent(APP_FILE), "email1"),
          getPropertyValue(getPropertyFileContent(APP_FILE), "password")
        }
      };
  }

  @Test
  public void testLogin() {
    DashboardPage dashboardPage = new DashboardPage(getDriver());
    MyAccountPage myAccountPage = dashboardPage.header.clickLogin()
                                                      .login(this.email, this.password);
    Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed(),
        "The account page didn't load after login.");
  }
}