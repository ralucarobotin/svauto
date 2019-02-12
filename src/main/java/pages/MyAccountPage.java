package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.isElementDisplayed;
import static helpers.WebElementHelper.waitForElementToAppear;

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

  public boolean isMyAccountPageDisplayed(){
    return isElementDisplayed(orderHistoryAdnDetailsButton)
        && isElementDisplayed(myCreditSlipsButton)
        && isElementDisplayed(myAddressesButton)
        && isElementDisplayed(myPersonalInformationButton)
        && isElementDisplayed(myWishlistButton);
  }

  @Override
  public void waitForPageToLoad(){
    waitForElementToAppear(accountContainer);
  }
}