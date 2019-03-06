package pages;

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

    private static String generateRandomEmail() {
        int length = 10;
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-";
        String temp = RandomStringUtils.random(length, allowedChars);
        return temp + "@yahoo.com";
    }

    private void fillInEmail(String email) {
        setFieldValue(emailField, email);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public void startCreateAccountValid() {
        fillInEmail(generateRandomEmail());
        clickCreateAccountButton();
    }

    public void startCreateAccountInvalid(String email) {
        fillInEmail(email);
        clickCreateAccountButton();
    }

    public boolean getPageHeadingCreateAccount() {
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



