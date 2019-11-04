package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helpers.WebElementHelper;
import uiPages.BasePage;

import static helpers.WebElementHelper.areVisible;

public class MyAccountPage extends BasePage {

    private static final String URL_PATH = "/my-account";

    @FindBy(className = "woocommerce-MyAccount-content")
    private WebElement logInMessage;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        super.isCurrent();
        return areVisible();
    }

    @Override
    protected boolean isValid() {
        super.isValid();
        return areVisible();
    }

    public void open(){
        openUrl(BASE_URL + URL_PATH);
    }

    public boolean isLogInMessage() {
        waitForElementToAppear(logInMessage);
        return WebElementHelper.isElementDisplayed(logInMessage);
    }
}
