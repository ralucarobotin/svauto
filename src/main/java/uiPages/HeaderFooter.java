package uiPages;

import helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderFooter extends WebUIPage{

  private final int RIGHT_TOPBAR_ELM_NR = 3;
  private final int LEFT_TOPBAR_ELM_NR = 2;

  @FindBy(className = "noo-topbar")
  protected WebElement topBar;

  @FindBy(className = "navbar")
  protected WebElement navBar;

  @FindBy(xpath = "//ul[contains(@class,'noo-topbar-left')]//a")
  protected List<WebElement> leftTopBar;

  @FindBy(xpath = "//ul[contains(@class,'noo-topbar-right')]//a")
  protected List<WebElement> rightTopBar;

  @FindBy(className = "noo-search")
  protected WebElement searchButton;

  @FindBy(className = "custom-logo")
  protected WebElement logoLink;

  @FindBy(className = "cart-button")
  protected WebElement cartButton;

  @FindBy(className = "woocommerce-store-notice__dismiss-link")
  protected WebElement qaHeaderButton;

  @FindBy(className = "wrap-footer")
  protected WebElement footer;

  public HeaderFooter(WebDriver driver) {
    super(driver);
    dismissQAHeader();
  }

  @Override
  protected boolean isCurrent() {
    return WebElementHelper.areVisible(topBar, navBar, footer);
  }

  @Override
  protected boolean isValid() {
    return (WebElementHelper.areVisible(rightTopBar.toArray(new WebElement[rightTopBar.size()]))
        && rightTopBar.size() == RIGHT_TOPBAR_ELM_NR)
        &&
        (WebElementHelper.areVisible(leftTopBar.toArray(new WebElement[leftTopBar.size()]))
            && leftTopBar.size() == LEFT_TOPBAR_ELM_NR)
        &&
        WebElementHelper.areVisible(searchButton, logoLink, cartButton, footer);
  }

  private void dismissQAHeader(){
    waitForElementToAppear(qaHeaderButton);
    qaHeaderButton.click();
  }
}