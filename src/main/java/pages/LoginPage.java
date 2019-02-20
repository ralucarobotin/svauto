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

    private void fillInEmail(String email) {
        setFieldValue(emailField, email);
    }

    private void fillInPassword(String password) {
        setFieldValue(passField, password);
    }
}
