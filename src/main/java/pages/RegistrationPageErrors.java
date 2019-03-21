package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageErrors extends BasePage{

    public static final String EMAIL_IN_USE = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
    public static final String INVALID_EMAIL = "Invalid email address.";

    @FindBy(id = "create_account_error")
    private WebElement createAccountErrorBanner;

    public RegistrationPageErrors(WebDriver driver) {
        super(driver);
    }

    public String getCreateAccountErrorText() {
        return this.createAccountErrorBanner.getText();
    }
}
