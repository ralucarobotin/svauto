package pages;

import helpers.WebElementHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class CreateAccountPage extends BasePage {
    @FindBy(css = "#center_column > h1")
    private WebElement pageHeadingCreateAccount;

    @FindBy(id = "email_create")
    private WebElement emailField;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(xpath = "//div[@class='form_content clearfix']//div[@class='alert alert-danger']")
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

    public static String generateEmail(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-";
        String email = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp.substring(0, temp.length() - 9) + "@yahoo.com";
        return email;
    }

    private void fillInEmail(String email) {
        setFieldValue(emailField, email);
    }

    public void create(String email) {
        fillInEmail(email);
        createAccountButton.click();
    }

    public WebElement getSignUpError() {
        waitForElementToAppear(createAccountError);
        return createAccountError;
    }

    public String getSignUpErrorMsg() {
        return createAccountError.getText();
    }

    public WebElement getPageHeadingCreateAccount() {
        return pageHeadingCreateAccount;
    }
}



