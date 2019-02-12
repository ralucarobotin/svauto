package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.BasePage.wait;

public class WebElementHelper {

  public static void setFieldValue(WebElement element, String text){
    element.click();
    element.clear();
    element.sendKeys(text);
  }

  public static boolean isElementDisplayed(WebElement element) {
    try {
      if (element != null && element.isDisplayed()) {
        return true;
      }
    } catch (Exception e) {
      return false;
    }
    return false;
  }

  public static void waitForElementToAppear(WebElement element){
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitForElementToDisappear(WebElement element){
    wait.until(ExpectedConditions.invisibilityOf(element));
  }

  public static void waitForElementToAppear(By element){
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
  }

  public static void waitForElementToDisappear(By element){
    wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
  }
}