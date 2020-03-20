package uiPages;

import helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

    private final static String VALIDATION_MSG = "Hello ";

    @FindBy(xpath = "//div[@id='primary']//p[1]")
    private WebElement validationMessage;

    public MyAccount(WebDriver driver) { super(driver); }

    public static String getExpectedValidationMsg() { return VALIDATION_MSG; }

    public String getValidationMessage() {
        return WebElementHelper.getElementText(validationMessage);
    }
}
