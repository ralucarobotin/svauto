package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class DashboardPage extends BasePage {

    public final static String URL = "http://automationpractice.com";

    @FindBy(id = "homeslider")
    private WebElement carousel;

    @Override
    protected boolean isCurrent() {
        return areVisible(carousel);
    }

    @Override
    protected boolean isValid() {
        return areVisible(carousel);
    }

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        headerLoginButton.click();
    }

    public void clickLogo() {
        headerLogo.click();
    }

    public void clickSearchField() {
        headerSearchField.click();
    }

    public void typeSearch(String text) {
        headerSearchField.sendKeys(text);
    }

    public void clickSearchSubmit() {
        headerSearchSubmit.click();
    }

    public void clickShoppingCart() {
        headerShoppingCart.click();
    }

    public void clickNewsletterField() {
        footerNewsletter.click();
    }

    public void typeNewsletter(String email) {
        footerNewsletter.sendKeys(email);
    }

    public void clickNewsletterSubmit() {
        footerNewsletterSubmit.click();
    }

    public void open() {
        openUrl(URL);
    }
}
