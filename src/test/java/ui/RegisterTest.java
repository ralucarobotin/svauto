package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uiPages.BasePage;
import uiPages.RegisterPage;
import static org.testng.Assert.*;

import static helpers.Utilities.getPropertyFromRegProp;



public class RegisterTest extends BaseTest {

    private RegisterPage registerPage = null;

    private String email;
    private String password;
    private  String username;

    public RegisterTest() {

        this.username = getPropertyFromRegProp("username");
        this.email = getPropertyFromRegProp("email");
        this.password = getPropertyFromRegProp("password");
    }



    @BeforeMethod
    void beforeMethod() {
        this.registerPage = new RegisterPage(getDriver());
    }

    @Test
    public void testSuccessfulRegistration() {
        this.registerPage.open();
        this.registerPage.verify();
        this.registerPage.register(username, email, password);
        String validationMessage = this.registerPage.getRegisterMessage();
        Assert.assertEquals(validationMessage, this.registerPage.getExpectedRegisterMsg(), "The error message is " +
                "not correct.");
    }

}
