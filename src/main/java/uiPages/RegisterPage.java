package uiPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class RegisterPage extends BasePage{

    private static final String URL_PATH = "/my-account";
    private static final String REGISTER_ERR_MSG = "Error: An account is already registered with that username." +
            "Please choose another.";


    @FindBy(id = "reg_username")
    private WebElement usernameField;

    @FindBy(id = "reg_email")
    private WebElement emailField;

    @FindBy(id = "reg_password")
    private WebElement passField;

    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(xpath = "//a[@class='woocommerce-privacy-policy-link']")
    private WebElement privacyPolicyLink;

    @FindBy(xpath = "//ul[@class='woocommerce-error']")
    private WebElement errorMessage;

    public RegisterPage(WebDriver driver){ super(driver);}

    @Override
    protected boolean isCurrent() {
        super.isCurrent();
        return areVisible(usernameField, emailField, passField, registerButton);
    }

    @Override
    protected boolean isValid() {
        super.isValid();
        return areVisible(usernameField, emailField, passField, registerButton, privacyPolicyLink);
    }


    private void fillInUsername(String username){
        setFieldValue(usernameField, username);
    }

    private void fillInEmail(String email){
        setFieldValue(emailField, email);
    }

    private void fillInPassword(String password){
        setFieldValue(passField, password);
    }

    public void register(String username,String email, String password) {
        fillInUsername(username);
        fillInEmail(email);
        fillInPassword(password);
        registerButton.click();
    }

    public void open(){ openUrl(BASE_URL + URL_PATH); }


}
