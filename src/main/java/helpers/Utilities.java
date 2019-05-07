package helpers;

import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


/**
 * General helper class
 */
public class Utilities {
  public static final String APP_FILE = "./app.properties";
  private static final Logger LOG = Logger.getLogger(Class.class.getName());
  private static final String SLEEP_INTERRUPTED = "Sleep interrupted!";

  public static String getPropertyValue(Properties properties, String propertyName) {
    if (StringUtils.isBlank(propertyName)) {
      throw new IllegalArgumentException("System property name cannot be null or blank");
    }

    final String propertyValue = properties.getProperty(propertyName);
    if (StringUtils.isNotBlank(propertyValue)) {
      return propertyValue;
    } else {
      throw new IllegalArgumentException(String.format(
          "Environment variable '%s' does not exist or is blank", propertyValue));
    }
  }

  public static Properties getPropertyFileContent(String propertiesFileName){
    return new ReadPropFile().getPropertiesValue(propertiesFileName);
  }

  public static String getPropertyFromAppProp(String prop){
    return getPropertyValue(getPropertyFileContent(APP_FILE), prop);
  }

  public static Object executeScript(final WebDriver driver, final String script, final Object... args) {
    try {
      return ((JavascriptExecutor) driver).executeScript(script, args);
    }
    catch (final WebDriverException ex) {
      throw new WebDriverException("Could not execute JavaScript command '" + script + "'", ex);
    }
  }

  public static String generatedEmail() {
    String generateStringOne = RandomStringUtils.random(5, true, true);
    String generateStringTwo = RandomStringUtils.random(4, true, true);
    String generateStringThree = RandomStringUtils.random(3, true, false);
    return (generateStringOne + "@" + generateStringTwo + "." + generateStringThree);
  }

  public static String generatePassword() {
    return RandomStringUtils.random(10, true, true);
  }

  public static String generateCharacters() {
    return RandomStringUtils.random(10, true, false);
  }

  public static void sleep(final long timeoutMs, final boolean swallowExceptions) {
    try {
      Thread.sleep(timeoutMs);
    }
    catch (final InterruptedException e) {
      if (swallowExceptions) {
        LOG.info(SLEEP_INTERRUPTED);
      }
      else {
        throw new IllegalStateException(SLEEP_INTERRUPTED, e);
      }
    }
  }
}
