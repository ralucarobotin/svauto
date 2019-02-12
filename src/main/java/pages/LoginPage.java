package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.setFieldValue;
import static helpers.WebElementHelper.waitForElementToAppear;

public class LoginPage extends BasePage {

  @FindBy(id = "email")
  private WebElement emailField;

  @FindBy(id = "passwd")
  private WebElement passField;

  @FindBy(id = "SubmitLogin")
  private WebElement logInButton;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void waitForPageToLoad() {
    waitForElementToAppear(emailField);
  }

  public MyAccountPage login(String email, String password) {
    fillInEmail(email);
    fillInPassword(password);
    logInButton.click();
    return new MyAccountPage(driver);
  }

  private void fillInEmail(String email){
    setFieldValue(emailField, email);
  }

  private void fillInPassword(String password){
    setFieldValue(passField, password);
  }
}