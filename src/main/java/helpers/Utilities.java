package helpers;

import java.time.LocalDate;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;


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

    public static Properties getPropertyFileContent(String propertiesFileName) {
        return new ReadPropFile().getPropertiesValue(propertiesFileName);
    }

    public static String getPropertyFromAppProp(String prop) {
        return getPropertyValue(getPropertyFileContent(APP_FILE), prop);
    }

    public static Object executeScript(final WebDriver driver, final String script, final Object... args) {
        try {
            return ((JavascriptExecutor) driver).executeScript(script, args);
        } catch (final WebDriverException ex) {
            throw new WebDriverException("Could not execute JavaScript command '" + script + "'", ex);
        }
    }

    public static void sleep(final long timeoutMs, final boolean swallowExceptions) {
        try {
            Thread.sleep(timeoutMs);
        } catch (final InterruptedException e) {
            if (swallowExceptions) {
                LOG.info(SLEEP_INTERRUPTED);
            } else {
                throw new IllegalStateException(SLEEP_INTERRUPTED, e);
            }
        }
    }

    public static boolean generateBoolean() {
        return RandomUtils.nextBoolean();
    }

    public static String generateNumbers() {
        return RandomStringUtils.randomNumeric(1, 11);
    }

    public static String generateZip() {
        return RandomStringUtils.randomNumeric(5);
    }

    public static String generateCharacters() {
        return RandomStringUtils.random(10, true, false);
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

//    public static LocalDate generateDate(){
//    LocalDate startDate = LocalDate.of(1900, 1, 1);
//    long start = startDate.toEpochDay();
//    LocalDate endDate = LocalDate.now();
//    long end = endDate.toEpochDay();
//    long random = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
//    return LocalDate.ofEpochDay(random);
//    }
}
