package pages;

import helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;
import static pages.DashboardPage.URL;

public class CreateAccountPage extends BasePage {
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
        openUrl(URL + "/index.php?controller=authentication&back=my-account");
    }
}



