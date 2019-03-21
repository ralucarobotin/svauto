package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;

import static helpers.WebElementHelper.areVisible;

public class NewAccountErrors extends BasePage{
    public static final String INVALID_EMAIL_ERROR = "Invalid email address.";
    public static final String EMAIL_EXISTS_ERROR = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
    public static final String LAST_NAME_REQUIRED_ERROR = "lastname is required.";
    public static final String FIRST_NAME_REQUIRED_ERROR = "firstname is required.";
    public static final String PSWD_REQUIRED_ERROR = "passwd is required.";
    public static final String ADDRESS_REQUIRED_ERROR = "address1 is required.";
    public static final String CITY_REQUIRED_ERROR = "city is required.";
    public static final String ZIP_INVALID_ERROR = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
    public static final String STATE_REQUIRED_ERROR = "This country requires you to choose a State.";
    public static final String PHONE_REQUIRED_TIP = "You must register at least one phone number.";
    public static final String COUNTRY_REQUIRED_ERROR = "Country is invalid";
    public static final String INVALID_LAST_NAME_ERROR = "lastname is invalid.";
    public static final String INVALID_FIRST_NAME_ERROR = "firstname is invalid.";
    public static final String TOTAL_NUMBER_OF_ERRORS = "There are 8 errors";

    @FindBy(css = "#center_column > div.alert.alert-danger")
    private WebElement accountFormErrorBanner;

    public NewAccountErrors(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(this.accountFormErrorBanner);
    }

    @Override
    protected boolean isValid() {
        return areVisible(this.accountFormErrorBanner);
    }

    public WebElement getErrorBannerElement() {
        return accountFormErrorBanner;
    }

    public String getAccountFormErrorText() {
        return accountFormErrorBanner.getText();
    }
}
