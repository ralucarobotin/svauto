package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.WebElementHelper;

public class BasePage extends WebUiPage {

    protected WebDriver driver;

    @FindBy(id = "header")
    protected WebElement headerContainer;

    @FindBy(className = "shop-phone")
    protected WebElement headerShopPhone;

    @FindBy(id = "contact-link")
    protected WebElement headerContactButton;

    @FindBy(className = "login")
    protected WebElement headerLoginButton;

    @FindBy(className = "logo img-responsive")
    protected WebElement headerLogo;

    @FindBy(id = "search_query_top")
    protected WebElement headerSearchField;

    @FindBy(css = "#searchbox button")
    protected WebElement headerSearchSubmit;

    @FindBy(className = "shopping_cart")
    protected WebElement headerShoppingCart;

    @FindBy(css = "#block_top_menu.nth(0) ul li")
    protected WebElement headerCategoryWomen;

    @FindBy(css = "#block_top_menu.nth(1) ul li")
    protected WebElement headerCategoryDresses;

    @FindBy(id = "#block_top_menu.nth(2) ul li")
    protected WebElement headerCategoryTShirts;

    @FindBy(id = "footer")
    protected WebElement footerContainer;

    @FindBy(id = "newsletter-input")
    protected WebElement footerNewsletter;

    @FindBy(css = "#newsletter_block_left div form div button")
    protected WebElement footerNewsletterSubmit;

    @FindBy(css = "#social_block.nth(0) > ul > li > a")
    protected WebElement footerFacebookFollow;

    @FindBy(css = "#social_block.nth(1) > ul > li > a")
    protected WebElement footerTwitterFollow;

    @FindBy(css = "#social_block.nth(2) > ul > li > a")
    protected WebElement footerYouTubeFollow;

    @FindBy(css = "#social_block.nth(3) > ul > li > a")
    protected WebElement footerGooglePlusFollow;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected boolean isCurrent() {
        return WebElementHelper.areVisible(headerContainer, footerContainer);
    }

    @Override
    protected boolean isValid() {
        return WebElementHelper.areVisible(headerShopPhone, headerContactButton, headerLoginButton, headerLogo,
                headerSearchField, headerSearchSubmit, headerShoppingCart, headerCategoryWomen, headerCategoryDresses,
                headerCategoryTShirts, footerNewsletter, footerNewsletterSubmit, footerFacebookFollow, footerTwitterFollow,
                footerYouTubeFollow, footerGooglePlusFollow);
    }
}
