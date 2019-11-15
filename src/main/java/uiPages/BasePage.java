package uiPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage extends WebUIPage {

  protected WebDriver  driver;
  protected final String BASE_URL = "http://shop.demoqa.com";
  protected static HeaderFooter headerFooter;

  public BasePage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @Override
  protected boolean isCurrent() {
    headerFooter = new HeaderFooter(driver);
    return headerFooter.isCurrent();
  }

  @Override
  protected boolean isValid() {
    return headerFooter.isValid();
  }
}
