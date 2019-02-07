package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends AbstractPage {

  @FindBy(className = "login")
  private WebElement loginButton;

  @FindBy(id = "header")
  private WebElement headerContainer;

  public Header(WebDriver driver){
    super(driver);
  }

  @Override
  public void waitForPageToLoad(){
    wait.until(ExpectedConditions.visibilityOf(headerContainer));
  }

  public LoginPage clickLogin() {
    loginButton.click();
    return new LoginPage(driver);
  }
}