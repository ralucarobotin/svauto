package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helpers.Utilities;
import uiPages.LoginPage;

public class LoginTest extends BaseTest {

    private static final String SPREADSHEET = "1QRkAzJxD1gyYV7_cfnGFQEjilMryjW-vpplM2IxYHcg";
    private static final String RANGE = "LoginTests!A:B";

    private LoginPage loginPage = null;

    @DataProvider
    public Object[][] getTestInputData() throws Exception {
        return Utilities.getTestInputData(SPREADSHEET, RANGE);
    }

    @BeforeMethod
    public void beforeMethod() {
        this.loginPage = new LoginPage(getDriver());
    }

    @Test(dataProvider = "getTestInputData")
    public void testNegativeLogin(String email, String password) {
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(email, password);
        String errorMessage = this.loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, this.loginPage.getExpectedLoginErrMsg(), "The error message is " +
            "not correct.");
    }
}
