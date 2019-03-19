package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class ShoppingCartPage extends BasePage {

    private final static String URL = "http://automationpractice.com/index.php?controller=order";

    @FindBy(id = "cart_title")
    private WebElement pageTitle;

    @FindBy(id = "order_step")
    private WebElement orderSteps;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement emptyShoppingCartText;

    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        openUrl(URL);
    }

    public boolean isCurrent(){
        return areVisible(pageTitle);
    }

    public boolean isValid(){
        return areVisible(pageTitle, orderSteps);
    }

    public String getShoppingCartEmptyWarning(){
        return emptyShoppingCartText.getText();
    }
}
