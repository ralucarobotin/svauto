package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class DashboardPage extends BasePage {

  public static final String BASE_URL = "http://automationpractice.com";

  @FindBy(id = "homeslider")
  private WebElement carousel;

  @FindBy(id = "editorial_block_center")
  private WebElement editorialBlockCenter;

  @Override
  protected boolean isCurrent() {
      return areVisible(carousel, editorialBlockCenter);
  }

  @Override
  protected boolean isValid() {
      return areVisible(carousel, editorialBlockCenter);
  }

  public DashboardPage(WebDriver driver){
    super(driver);
  }

  public void clickLoginButton(){
      headerLoginButton.click();
    }

  public void open(){
    openUrl(BASE_URL);
  }
}
