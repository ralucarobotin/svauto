package tests;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
=======
import org.testng.annotations.AfterMethod;

>>>>>>> Second commit
=======
import org.testng.annotations.AfterMethod;

>>>>>>> Second commit
=======
import org.testng.annotations.AfterMethod;

>>>>>>> 013c7945306b0c9c9de8e767e8db21be127b59db

import java.util.Optional;

import helpers.BrowserName;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
  private WebDriver driver;
  private final static String BROWSER_SYSTEM_VAR = "browser";


  @BeforeMethod(alwaysRun = true)
  public void setUpClass(){
    if (StringUtils.isBlank(System.getProperty(BROWSER_SYSTEM_VAR))){
      throw new IllegalArgumentException("Browser name is not set in VM options. " +
                                                 "Please make sure you're setting the <browser> value before starting the tests " +
                                                 "-- https://www.screencast.com/t/CGYCEL6bc3U --");
    }
    final String browserVariable = System.getProperty(BROWSER_SYSTEM_VAR).toLowerCase();

    if (browserVariable.equals(BrowserName.CHROME.getName())){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
    }
    else if (browserVariable.equals(BrowserName.FIREFOX.getName())){
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
      driver.manage().window().maximize();
    }
    else {
      throw new IllegalArgumentException("Browser name is incorrectly set in VM options");
    }

  }

  @AfterMethod(alwaysRun = true)
  public void tearDownClass(){
    if (driver != null) {
      driver.quit();
    }
  }

  protected WebDriver getDriver(){
    return driver;
  }
}
