package uiPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static helpers.WebElementHelper.areVisible;

public class DashboardPage extends BasePage {

  private final static int CAROUSELS_NR = 7;

  @FindBy(className = "noo-container-fluid")
  private List<WebElement> carousels;

  @Override
  protected boolean isCurrent() {
    return areVisible(carousels) && carousels.size() == CAROUSELS_NR;
  }

  @Override
  protected boolean isValid() {
    return areVisible(carousels) && carousels.size() == CAROUSELS_NR;
  }

  public DashboardPage(WebDriver driver){
    super(driver);
  }
}
