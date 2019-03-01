package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement pageHeader;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    protected boolean isCurrent() {
        return areVisible(pageHeader);
    }

    protected boolean isValid() {
        return areVisible(pageHeader);
    }


}
