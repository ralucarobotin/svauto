package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class MyAccountPage extends BasePage {

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

  public MyAccountPage(WebDriver driver){
    super(driver);
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
}
