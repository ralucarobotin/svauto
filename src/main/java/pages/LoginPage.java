package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;
import static pages.DashboardPage.URL;

public class LoginPage extends BasePage {
  @FindBy(css = "#center_column > h1")
  private WebElement pageHeadingLogin;

  @FindBy(id = "email")
  private WebElement emailField;

  @FindBy(id = "passwd")
  private WebElement passField;

  @FindBy(id = "SubmitLogin")
  private WebElement logInButton;

  @FindBy(css = "#center_column > div.alert.alert-danger > ol > li")
  private WebElement loginError;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Override
  protected boolean isCurrent() {
    return areVisible(emailField);
  }

  @Override
  protected boolean isValid() {
    return areVisible(emailField, passField, logInButton);
  }

  public void login(String email, String password) {
    fillInEmail(email);
    fillInPassword(password);
    logInButton.click();
 }

  public void clickSignInButton(){
    logInButton.click();
  }

  private void fillInEmail(String email){
    setFieldValue(emailField, email);
  }

  private void fillInPassword(String password){
    setFieldValue(passField, password);
  }

  public boolean getPageHeading() {
    return areVisible(pageHeadingLogin);
  }

  public boolean getLoginError() {
    return areVisible(loginError);
  }

  public String getLoginErrorMsg() {
    return loginError.getText();
  }

  public void open() {
        openUrl(URL + "/index.php?controller=authentication&back=my-account");
  }
}
