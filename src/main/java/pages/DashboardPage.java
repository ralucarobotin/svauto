package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DashboardPage extends AbstractPage {

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
    wait.until(ExpectedConditions.visibilityOf(carousel));
  }
}