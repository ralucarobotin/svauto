package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helpers.WebElementHelper.isElementDisplayed;

public class MyAccountPage extends AbstractPage{

  @FindBy(className = "info-account")
  private WebElement accountContainer;

  @FindBy(css = "a[href*='history']")
  private WebElement orderHistoryAdnDetailsButton;

  @FindBy(css = "a[href*='history']")
  private WebElement myCreditSlipsButton;

  @FindBy(css = "a[href*='history']")
  private WebElement myAddressesButton;

  @FindBy(css = "a[href*='history']")
  private WebElement myPersonalInformationButton;

  @FindBy(css = "a[href*='history']")
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
    wait.until(ExpectedConditions.visibilityOf(accountContainer));
  }
}