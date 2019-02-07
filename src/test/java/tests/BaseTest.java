package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import helpers.Environment;

public class BaseTest extends Environment {

  @BeforeClass(alwaysRun = true)
  public void setUpClass(){}

  @AfterClass(alwaysRun = true)
  public void tearDownClass(){}
}