package helpers;

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

  public static String inputGeneratedEmail(){
    int length = 5;
    int length2 = 4;
    int length3 = 3;
    boolean letters = true;
    boolean numbers = true;
    boolean numbersTwo = false;
    String generateStringOne = RandomStringUtils.random(length, letters, numbers);
    String generateStringTwo = RandomStringUtils.random(length2, letters, numbers);
    String generateStringThree = RandomStringUtils.random(length3, letters, numbersTwo);
    return (generateStringOne + "@" + generateStringTwo + "." + generateStringThree);
  }

  public static String inputPassword(){
    int length = 10;
    boolean letters = true;
    boolean numbers = true;
    String generateString = RandomStringUtils.random(length, letters, numbers);
    return generateString;
  }

  public static String inputLetters(){
    int length = 10;
    boolean letters = true;
    boolean numbers = false;
    String generateString = RandomStringUtils.random(length, letters, numbers);
    return generateString;
  }

  public static String inputNumbers(){
    String generateNumbers = RandomStringUtils.randomNumeric(0, 9);
    return generateNumbers;
  }

//  public static boolean selectGender(){
//    boolean genderMale = true;
//    boolean genderFemale = true;
//    boolean addGender = RandomUtils.nextBoolean();
//    return addGender ? genderMale : genderFemale;
//  }

}
