package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class LoginPage extends BasePage {

  @FindBy(id = "email")
  private WebElement emailField;

  @FindBy(id = "passwd")
  private WebElement passField;

  @FindBy(id = "SubmitLogin")
  private WebElement logInButton;

  @FindBy (css = "#center_column > div.alert.alert-danger > ol > li")
  private WebElement signInError;

  //Create an account form
  @FindBy(id = "email_create")
  private WebElement createEmailField;

  @FindBy(css="button #SubmitCreate")
  private WebElement createAccountButton;

  @FindBy (id = "create_account_error")
  private WebElement createAccountError;

  public static final String EMPTY_EMAIL_ERROR = "An email address required.";
  public static final String EMPTY_PASSWORD_ERROR = "Password is required.";
  public static final String FAILED_AUTHENTICATION_ERROR = "Authentication failed.";

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

  private void fillInEmail(String email){
    setFieldValue(emailField, email);
  }

  private void fillInPassword(String password){
    setFieldValue(passField, password);
  }

  public String getSignInErrorText(){
    return this.signInError.getText();
  }

  public WebElement getErrorBanner(){
    return signInError;
  }

  //create new account
  public void fillEmailAddress(String email){
    setFieldValue(createEmailField,email);
  }

  public void clickCreateAccount(){
    this.createAccountButton.click();
  }

  public String getCreateAccountErrorText(){
    return this.createAccountError.getText();
  }

//  public void openLoginPage(){
//    DashboardPage dashboardPage = new DashboardPage(getDriver());
//    dashboardPage.verify();
//    dashboardPage.clickLoginButton();
//    this.verify();
//  }
}
