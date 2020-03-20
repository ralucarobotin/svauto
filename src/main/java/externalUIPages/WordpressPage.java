package externalUIPages;

import helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uiPages.BasePage;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class WordpressPage extends BasePage {

    private static final String URL_PATH = "/shop-demoqa?redirect_to=http%3A%2F%2Fshop.demoqa.com%2Fmy-account%2F&aiowps_login_msg_id=session_expired";
    private static final String REGISTER_VAL_MSG = "Your session has expired because it has been over 60 minutes since your last login. Please log back in to continue.";

    @FindBy(xpath = "//p[@class='login message']")
    private WebElement validationMessage;

    @FindBy(id = "user_login")
    private WebElement usernameField;

    @FindBy(id = "user_pass")
    private WebElement passwordField;

    @FindBy(id = "rememberme")
    private WebElement rememberMeCheckbox;

    @FindBy(id = "wp-submit")
    private WebElement logInButton;

    @FindBy(id = "nav")
    private WebElement lostYourPasswordLink;

    @FindBy(id = "backtoblog")
    private WebElement backToQADemoSite;

    public WordpressPage(WebDriver driver){ super(driver); }

    public void open(){ openUrl(BASE_URL + URL_PATH); }

    @Override
    protected boolean isCurrent() {
        //super.isCurrent();
        return areVisible(usernameField, passwordField, rememberMeCheckbox, logInButton,
                          lostYourPasswordLink, backToQADemoSite);
    }

    @Override
    protected boolean isValid() {
        super.isValid();
        return areVisible(usernameField, passwordField, rememberMeCheckbox, logInButton,
                          lostYourPasswordLink, backToQADemoSite);
    }

    private void fillInEmail(String username){
        setFieldValue(usernameField, username);
    }

    private void fillInPassword(String password){
        setFieldValue(passwordField, password);
    }

    public void login(String username, String password) {
        fillInEmail(username);
        fillInPassword(password);
        logInButton.click();
    }

    public static String getExpectedRegisterMsg() {
        return REGISTER_VAL_MSG;
    }

    public String getRegisterMessage() {
        return WebElementHelper.getElementText(validationMessage);
    }


}
