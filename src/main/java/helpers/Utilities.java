package helpers;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

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

  public static List<List<Object>> readTestInputData(String spreadsheet, String range){
    List<List<Object>> inputData = new ArrayList<>();
    try {
      inputData = GoogleSheets.readSheet(spreadsheet, range);
    } catch (IOException e) {
      LOG.warning("The test input data file was not found!");
      e.printStackTrace();
    } catch (GeneralSecurityException e) {
      LOG.warning("There was a problem on reading the test input data file!");
      e.printStackTrace();
    }
    return inputData;
  }

  public static Object[][] getTestInputData(String spreadsheet, String range) throws Exception {
    List<List<Object>> testInputData = readTestInputData(spreadsheet, range);
    if (testInputData != null){
      //Get the header
      List<String> header = new ArrayList<>();
      testInputData.get(0)
                   .stream()
                   .forEach(h -> header.add(h.toString()));

      //Get data from the rows
      int rowsNo = (int)testInputData.stream().count() - 1;
      int columnsNo = header.size();
      Object[][] rows = new Object[rowsNo][columnsNo];
      for (int i = 0 ; i < testInputData.stream().count() - 1; i++){
        //Get data from each row
        List<Object> row = testInputData.get(i + 1);
        if (row.isEmpty()){
          continue;
        } else {
          if (row.size() <=  columnsNo){
            for (int k = 0; k < columnsNo; k++){
              try {
                rows[i][k] = row.get(k).toString();
              } catch (IndexOutOfBoundsException ex){
                rows[i][k] = StringUtils.EMPTY;
              }
            }
          } else {
            throw new Exception("The columns length doesn't match the header.");
          }
        }
      }
      return rows;
    }
    throw new Exception("The test input data was not successfully set.");
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
