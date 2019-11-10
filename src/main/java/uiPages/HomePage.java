package uiPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.WebElementHelper.areVisible;

public class HomePage extends BasePage {

    protected final String BASE_URL = "http://shop.demoqa.com";

    @FindBy(xpath = "//a[@class='custom-logo-link']//img[@class='custom-logo']")
    private WebElement siteLogo;

    @FindBy(xpath = "//a[contains(text(),'My Wishlist')]")
    private WebElement myWishlistButton;

    @FindBy(xpath = "/html/body/p/a")
    private WebElement bannerDismissButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        super.isCurrent();
        return areVisible(siteLogo);
    }

    @Override
    public boolean isValid() {
        super.isValid();
        return areVisible(siteLogo);
    }

    public void clickMyWishlistButton() {
        waitForElementToAppear(myWishlistButton);
        myWishlistButton.click();
    }

    public void clickBannerDismissButton() {
        waitForElementToAppear(bannerDismissButton);
        bannerDismissButton.click();
    }

    public void openHomePageUrl(){
        openUrl(String.format(BASE_URL));
    }
}
