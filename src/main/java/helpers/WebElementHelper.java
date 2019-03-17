package helpers;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Helper class for working with the page's elements
 */
public class WebElementHelper {
  private static final Logger LOG = Logger.getLogger(Class.class.getName());

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

  public static boolean areVisible(WebElement... elements) {
    final List<WebElement> webElements = Arrays.asList(elements);
    final List<WebElement> elementsNotVisible = new ArrayList<>();

    webElements.forEach(webElement -> {
      if (!isElementDisplayed(webElement)) {
        elementsNotVisible.add(webElement);
      }
    });

    if (!elementsNotVisible.isEmpty()) {
      LOG.warning(String.format("The following elements are not visible in page: %s", elementsNotVisible));
    }
    return elementsNotVisible.isEmpty();
  }

  public static String generateRandomEmail() {
    int length = 10;
    String temp = RandomStringUtils.randomAlphanumeric(length);
    return temp + "@" + temp + "." + "com";
  }

  public static String generateRandomString() {
    int length = 10;
    return RandomStringUtils.randomAlphabetic(length);
  }

  public static String generateRandomNumber() {
    int length = 10;
    return RandomStringUtils.randomNumeric(length);
  }

  public static String generateRandomPassword() {
    int length = 10;
    return RandomStringUtils.randomAlphanumeric(length);
  }

  public static String generateRandomPostalCode() {
    int length = 5;
    return RandomStringUtils.randomNumeric(length);
  }

  public static String generateRandomState() {
    String[] stateList = new String[]{"Alabama", "Alaska", "Arizona",
            "Arkansas", "California", "Colorado", "Connecticut",
            "Delaware", "District of Columbia", "Florida", "Georgia",
            "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
            "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
            "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
            "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
            "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
            "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina",
            "South Dakota", "Tennessee", "Texas", "US Virgin Islands", "Utah",
            "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin",
            "Wyoming"};

    return stateList[RandomUtils.nextInt() % stateList.length];
  }
}
