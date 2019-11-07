package ui;

import externalUIPages.WordpressPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uiPages.MyAccount;
import uiPages.RegisterPage;

import static helpers.Utilities.getPropertyFileContent;
import static helpers.Utilities.getPropertyValue;


public class RegisterTest extends BaseTest {

    private RegisterPage registerPage = null;
    private WordpressPage wordpressPage = null;
    private MyAccount myAccount = null;
    private final static String REG_FILE = "./register.properties";

    private String email;
    private String password;
    private  String username;

    public RegisterTest() {

        this.username = getPropertyFromRegProp("username");
        this.email = getPropertyFromRegProp("email");
        this.password = getPropertyFromRegProp("password");
    }

    private static String getPropertyFromRegProp(String prop){
        return getPropertyValue(getPropertyFileContent(REG_FILE), prop);
    }

    @BeforeMethod
    void beforeMethod() {
        this.registerPage = new RegisterPage(getDriver());
        this.wordpressPage = new WordpressPage(getDriver());
        this.myAccount = new MyAccount(getDriver());
    }

    @Test
    public void testSuccessfulRegistration() {
        this.registerPage.open();
        this.registerPage.verify();
        this.registerPage.register(username, email, password);

        this.wordpressPage.verify();
        this.wordpressPage.login(username, password);

        String validationMessage = this.myAccount.getValidationMessage() + username;
        Assert.assertTrue(validationMessage.contains(MyAccount.getExpectedValidationMsg() + username), "The error message is " +
                "not correct.");
    }

}
