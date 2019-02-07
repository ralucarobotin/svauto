package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

  protected WebDriver driver;
  protected WebDriverWait wait;

  private static final int TIMEOUT = 10;

  public AbstractPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, TIMEOUT);
    PageFactory.initElements(driver, this);
    waitForPageToLoad();
  }

  public abstract void waitForPageToLoad();

}