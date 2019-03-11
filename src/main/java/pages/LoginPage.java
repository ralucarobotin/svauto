package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.*;

public class LoginPage extends BasePage {

    public static final String LOGIN_PAGE_URL = DashboardPage.BASE_URL + "/index.php?controller=authentication&back=my-account";

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passField;

    @FindBy(id = "SubmitLogin")
    private WebElement logInButton;

    @FindBy(css = "#center_column div ol li")
    private WebElement loginErrorMessage;

    @FindBy(css = "#email_create")
    private WebElement inputEmailCreateAccount;

    @FindBy(id = "SubmitCreate")
    protected WebElement createAnAccount;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(emailField, passField, logInButton);
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

    private void fillInEmail(String email) {
        setFieldValue(emailField, email);
    }

    private void fillInPassword(String password) {
        setFieldValue(passField, password);
    }

    public String getLoginPageErrorMessage() {
        return loginErrorMessage.getText();
    }

    public void openLoginPage(){
        openUrl(LOGIN_PAGE_URL);
    }

    public void fillInAccountEmail(String text){
        setFieldValue(inputEmailCreateAccount,  text);
    }

    public void clickCreateAccountButton(){
        createAnAccount.click();
    }
}
