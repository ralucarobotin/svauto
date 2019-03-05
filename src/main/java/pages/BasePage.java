package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.WebElementHelper;



public class BasePage extends WebUiPage {

  protected WebDriver  driver;

  @FindBy(id = "header")
  protected WebElement headerContainer;

  @FindBy(className = "login")
  protected WebElement headerLoginButton;

  public BasePage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @Override
  protected boolean isCurrent() {
      return WebElementHelper.areVisible(headerContainer);
  }

  @Override
  protected boolean isValid() {
      return true;
  }
}
