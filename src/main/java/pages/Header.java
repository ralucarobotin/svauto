package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.waitForElementToAppear;

public class Header extends BasePage {

  @FindBy(className = "login")
  private WebElement loginButton;

  @FindBy(id = "header")
  private WebElement headerContainer;

  public Header(WebDriver driver){
    super(driver);
  }

  @Override
  public void waitForPageToLoad(){
    waitForElementToAppear(headerContainer);
  }

  public LoginPage clickLogin() {
    loginButton.click();
    return new LoginPage(driver);
  }

  public void clickLoginButton() {
    loginButton.click();
  }
}