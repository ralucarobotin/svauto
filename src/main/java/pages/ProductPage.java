package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class ProductPage extends BasePage {
    private final static String URL = "http://automationpractice.com/index.php?id_product=1&controller=product";

    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement addToCartButton;

    @FindBy(id = "layer_cart")
    private WebElement productAddedToCartLayer;

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public boolean isCurrent(){
        return areVisible(addToCartButton);
    }

    public boolean isValid(){
        return areVisible(addToCartButton);
    }

    public void open(){
        openUrl(URL);
    }

    public void addProductToCart(){
        this.addToCartButton.click();
    }
}
