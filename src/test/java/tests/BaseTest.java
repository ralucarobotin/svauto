package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import helpers.Environment;
import org.testng.annotations.DataProvider;

import static helpers.Utilities.getPropertyFileContent;
import static helpers.Utilities.getPropertyValue;

public class BaseTest extends Environment {

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
    }
}