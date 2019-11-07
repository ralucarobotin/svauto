package uiPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helpers.WebElementHelper;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class LoginPage extends BasePage {

  private static final String URL_PATH = "/my-account";
  private static final String LOGIN_ERR_MSG = "ERROR: The username or password you entered is" +
      " incorrect. Lost your password?";
  private static final String LOGIN_NO_USER_ERR_MSG = "Error: Username is required.";
  private static final String LOGIN_NO_PASSWORD_ERR_MSG = "ERROR: The password field is empty.";

  @FindBy(id = "username")
  private WebElement emailField;

  @FindBy(id = "password")
  private WebElement passField;

  @FindBy(name = "login")
  private WebElement logInButton;

  @FindBy(name = "rememberme")
  private WebElement rememberMeCheckbox;

  @FindBy(xpath = "//p[contains(@class, 'lost_password')]/a")
  private WebElement lostPasswordLink;

  @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
  private WebElement errorMessage;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Override
  protected boolean isCurrent() {
    super.isCurrent();
    return areVisible(emailField,passField, logInButton);
  }

  @Override
  protected boolean isValid() {
    super.isValid();
    return areVisible(emailField, passField, logInButton,rememberMeCheckbox, lostPasswordLink);
  }

  public void clickLoginButton() {
    logInButton.click();
  }

  public void login(String email, String password) {
    fillInEmail(email);
    fillInPassword(password);
    clickLoginButton();
  }

  public void loginEmail(String email) {
    fillInEmail(email);
    clickLoginButton();
  }

  public void loginPassword(String password) {
    fillInPassword(password);
    clickLoginButton();
  }

  private void fillInEmail(String email){
    setFieldValue(emailField, email);
  }

  private void fillInPassword(String password){
    setFieldValue(passField, password);
  }

  public void open(){
    openUrl(BASE_URL + URL_PATH);
  }

  public static String getExpectedNoUserErrMsg() { return LOGIN_NO_USER_ERR_MSG; }

  public static String getExpectedNoPasswordErrMsg() { return LOGIN_NO_PASSWORD_ERR_MSG; }

  public static String getExpectedWrongLoginErrMsg() { return LOGIN_ERR_MSG; }

  public String getErrorMessage() {
    return WebElementHelper.getElementText(errorMessage);
  }
}
