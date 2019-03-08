package pages;

import helpers.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class RegistrationPage extends BasePage{

    private final static String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @FindBy(id = "email_create")
    private WebElement createEmailField;

    @FindBy(id="SubmitCreate")
    private WebElement createAccountButton;

    @FindBy (id = "create_account_error")
    private WebElement createAccountError;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(createAccountButton);
    }

    @Override
    protected boolean isValid() {
        return areVisible(createEmailField, createAccountButton);
    }

    public void open(){
        openUrl(URL);
    }

    public void fillEmailAddress(String email){
        setFieldValue(createEmailField,email);
    }

    public void clickCreateAccount(){
        this.createAccountButton.click();
    }

    public String getCreateAccountErrorText(){
        return this.createAccountError.getText();
    }

    public WebElement getCreateAccountButton(){ return this.createAccountButton;}

    public void gotoNewAccountForm(){
        fillEmailAddress(Utilities.generateEmail("mailinator.com"));
        clickCreateAccount();
    }
}
