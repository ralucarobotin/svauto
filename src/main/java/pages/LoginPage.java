package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class LoginPage extends BasePage {

    private static final String  openLoginUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passField;

    @FindBy(id = "SubmitLogin")
    private WebElement logInButton;

    @FindBy(css = "#center_column div ol li")
    private WebElement errorMessage;

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

    public WebElement errorMessage() {
        return errorMessage;
    }

    public void openLoginUrl(){
        openUrl(openLoginUrl);
    }

}
