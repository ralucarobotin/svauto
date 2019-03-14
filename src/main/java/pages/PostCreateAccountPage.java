package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class PostCreateAccountPage extends BasePage {

    @FindBy(className = "icon-list-ol")
    private WebElement iconList;

    @FindBy(className = "icon-ban-circle")
    private WebElement iconBan;

    @FindBy(className = "icon-building")
    private WebElement iconBuilding;

    @FindBy(className = "icon-user")
    private WebElement iconUser;

    @FindBy(className = "icon-heart")
    private WebElement iconHeart;

    @FindBy(className = "page-heading")
    private WebElement pageHeading;

    @FindBy(className = "info-account")
    private WebElement infoAccount;

    public PostCreateAccountPage(WebDriver driver){
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(pageHeading, infoAccount);
    }

    @Override
    protected boolean isValid() {
        return areVisible(infoAccount, pageHeading, iconList, iconBan, iconBuilding, iconUser, iconHeart);
    }
}
