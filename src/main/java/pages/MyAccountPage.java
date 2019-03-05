package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class MyAccountPage extends BasePage {

  private final static String URL = "http://automationpractice.com/index.php?controller=my-account";

  @FindBy(className = "info-account")
  private WebElement accountContainer;

  @FindBy(css = "a[href*='history']")
  private WebElement orderHistoryAdnDetailsButton;

  @FindBy(css = "a[href*='order-slip']")
  private WebElement myCreditSlipsButton;

  @FindBy(css = "a[href*='addresses']")
  private WebElement myAddressesButton;

  @FindBy(css = "a[href*='identity']")
  private WebElement myPersonalInformationButton;

  @FindBy(css = "a[href*='mywishlist']")
  private WebElement myWishlistButton;

  @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]/span[1]")
  private  WebElement username;

  public MyAccountPage(WebDriver driver){
    super(driver);
  }

  public void open(){
    openUrl(URL);
  }

  @Override
  protected boolean isCurrent() {
    return areVisible(accountContainer);
  }

  @Override
  protected boolean isValid() {
    return areVisible(orderHistoryAdnDetailsButton,
                      myCreditSlipsButton,
                      myAddressesButton,
                      myPersonalInformationButton,
                      myWishlistButton);
  }

  public String getUsernameText(){
    return username.getText();
  }
}
