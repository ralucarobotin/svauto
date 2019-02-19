package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class CreateAccountPage extends BasePage {

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

    public void create(String emailNew) {
        fillInEmail(emailNew);
        createAccountButton.click();
    }

    private void fillInEmail(String emailNew) {
        setFieldValue(emailField, emailNew);
    }

    public WebElement getError(){
        return createAccountError;
    }
}



