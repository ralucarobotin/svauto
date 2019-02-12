package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.waitForElementToAppear;

public class DashboardPage extends BasePage {

  public static Header header;

  @FindBy(id = "homeslider")
  private WebElement carousel;

  public DashboardPage(WebDriver driver){
    super(driver);
    header = new Header(driver);
  }

  public void login(String email, String password){
    header.clickLoginButton();
    new LoginPage(driver).login(email, password);
  }

  @Override
  public void waitForPageToLoad(){
    waitForElementToAppear(carousel);
  }
}