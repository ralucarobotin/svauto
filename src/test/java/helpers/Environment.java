package helpers;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static helpers.Utilities.getPropertyFileContent;
import static helpers.Utilities.getPropertyValue;

public class Environment {
    private static WebDriver driver;
    private static Browsers browser;
    private static String url;
    protected final String APP_FILE = "./app.properties";
    private final String CHROME_DRIVER_PATH = "./src/main/resources/chromedriver.exe";
    private final String FIREFOX_DRIVER_PATH = "./src/main/resources/geckodriver.exe";

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    @Parameters({"browser", "url"})
    public void openBrowser(@Optional String browser, @Optional String url) {
        if (browser == null || StringUtils.isNotEmpty(url)) {
            setBrowser();
            openBrowser();
        } else {
            this.browser = Browsers.stringToEnum(browser);
            openBrowser();
        }
        if (url != null && StringUtils.isNotEmpty(url)) {
            this.url = url;
            this.driver.get(this.url);
        } else {
            setURL();
            this.driver.get(this.url);
        }
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    private void openBrowser() {
        switch (this.browser) {
            case CHROME:
                initChrome();
                break;
            case FIREFOX:
                initFirefox();
                break;
            default:
                try {
                    throw new Exception("Unknown browser!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    private void initChrome() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.merge(cap);
        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
    }

    private void initFirefox() {
        System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        options.merge(cap);
        this.driver = new FirefoxDriver(options);
        this.driver.manage().window().maximize();
    }

    public String getProperty(String prop) {
        return getPropertyValue(getPropertyFileContent(APP_FILE), prop);
    }

    private void setBrowser() {
        this.browser = Browsers.stringToEnum(getProperty("browser"));
    }

    private void setURL() {
        this.url = getProperty("url");
    }

    public String getEmail() {
        return getProperty("email");
    }


    public String getPassword() {
        return getProperty("password");
    }

}