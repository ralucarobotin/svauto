package pages;

import helpers.WebElementHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class CreateAccountPage extends BasePage {
    public static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @FindBy(css = "#center_column > h1")
    private WebElement pageHeadingCreateAccount;

    @FindBy(id = "email_create")
    private WebElement emailField;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "create_account_error")
    private WebElement createAccountError;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(emailField);
    }

    @Override
    protected boolean isValid() {
        return areVisible(emailField, createAccountButton);
    }

    private void fillInEmail(String email) {
        setFieldValue(emailField, email);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public void startValidAccountCreation() {
        fillInEmail(WebElementHelper.generateRandomEmail());
        clickCreateAccountButton();
    }

    public void startInvalidAccountCreation(String email) {
        fillInEmail(email);
        clickCreateAccountButton();
    }

    public boolean getPageHeading() {
        return areVisible(pageHeadingCreateAccount);
    }

    public boolean getSignUpError() {
        waitForElementToAppear(createAccountError);
        return areVisible(createAccountError);
    }

    public String getSignUpErrorMsg() {
        return createAccountError.getText();
    }

    public void open(){
        openUrl(URL);
    }
}



