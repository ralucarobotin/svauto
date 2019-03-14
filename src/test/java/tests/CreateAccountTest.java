package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static helpers.Utilities.*;

public class CreateAccountTest extends BaseTest {

    private LoginPage loginPage = null;
    private CreateAccountPage createAccountPage = null;
    private PostCreateAccountPage postCreateAccountPage = null;

    private String messageWith10Errors;
    private String messageWith9Errors;
    private String messageWith8Errors;
    private String messageWith7Errors;
    private String messageWith6Errors;
    private String messageWith5Errors;
    private String messageWith4Errors;
    private String messageWith3Errors;
    private String messageWith2Errors;
    private String messageWith1Errors;

    public CreateAccountTest() {
        this.messageWith10Errors = getPropertyFromAppProp("messageWith10Errors");
        this.messageWith9Errors = getPropertyFromAppProp("messageWith9Errors");
        this.messageWith8Errors = getPropertyFromAppProp("messageWith8Errors");
        this.messageWith7Errors = getPropertyFromAppProp("messageWith7Errors");
        this.messageWith6Errors = getPropertyFromAppProp("messageWith6Errors");
        this.messageWith5Errors = getPropertyFromAppProp("messageWith5Errors");
        this.messageWith4Errors = getPropertyFromAppProp("messageWith4Errors");
        this.messageWith3Errors = getPropertyFromAppProp("messageWith3Errors");
        this.messageWith2Errors = getPropertyFromAppProp("messageWith2Errors");
        this.messageWith1Errors = getPropertyFromAppProp("messageWith1Errors");
    }

    @BeforeMethod
    void beforeMethod() {
        this.loginPage = new LoginPage(getDriver());
        this.createAccountPage = new CreateAccountPage(getDriver());
        this.postCreateAccountPage = new PostCreateAccountPage(getDriver());
    }

    @Test(description = "Test create account page with valid credentials:\n " +
            "Steps:\n" +
            "1. Navigate to the Dashboard page with URL: http://automationpractice.com/index.php\n" +
            "2. Verify that the Dashboard page is loaded correctly.\n" +
            "3. Input email.\n" +
            "4. Click on the 'Create an account' button\n" +
            "5. Verify that the 'Authentication' page is loaded correctly.\n" +
            "6. Input valid credentials in all the fields.\n" +
            "7. Click on the 'Register' button.\n"
    )
    public void testCreateValidAccount() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail(generatedEmail());
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
                .gender(generateBoolean())
                .customerFirstName(generateCharacters())
                .customerLastName(generateCharacters())
                .email(generatedEmail())
                .password(generatePassword())
                .firstName(generateCharacters())
                .lastName(generateCharacters())
                .company(generateCharacters())
                .firstAddress(generateCharacters())
                .secondAddress(generateCharacters())
                .city(generateCharacters())
                .postCode(generateZip())
                .otherInfo(generateCharacters())
                .phone(generateNumbers())
                .mobilePhone(generateNumbers())
                .alias(generatedEmail())
                .build();

        this.createAccountPage.inputGender(account.getGender());
        this.createAccountPage.inputCustomerFirstName(account.getCustomerFirstName());
        this.createAccountPage.inputCustomerLastName(account.getCustomerLastName());
        this.createAccountPage.inputEmail(account.getEmail());
        this.createAccountPage.inputPassword(account.getPassword());
        this.createAccountPage.inputDays();
        this.createAccountPage.inputMonths();
        this.createAccountPage.inputYears();
        this.createAccountPage.inputNewsLetter();
        this.createAccountPage.inputOptIn();
        this.createAccountPage.inputFirstName(account.getFirstName());
        this.createAccountPage.inputLastName(account.getLastName());
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputFirstAddress(account.getFirstAddress());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputCity(account.getCity());
        this.createAccountPage.inputState();
        this.createAccountPage.inputPostCode(account.getPostCode());
        this.createAccountPage.inputCountry();
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputPhone(account.getPhone());
        this.createAccountPage.inputMobilePhone(account.getMobilePhone());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.postCreateAccountPage.verify();
    }

    @Test(description = " "
    )
    public void messageWith10Errors() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail(generatedEmail());
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
                .gender(generateBoolean())
                .email(generatedEmail())
                .firstName(generateCharacters())
                .lastName(generateCharacters())
                .company(generateCharacters())
                .secondAddress(generateCharacters())
                .otherInfo(generateCharacters())
                .alias(generatedEmail())
                .build();

        this.createAccountPage.inputGender(account.getGender());
        this.createAccountPage.inputEmail(account.getEmail());
        this.createAccountPage.inputFirstName(account.getFirstName());
        this.createAccountPage.inputLastName(account.getLastName());
        this.createAccountPage.clearEmail();
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.clearCountry();
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageWith10Errors, "The test for messageWith10Errors has failed");
    }

    @Test(description = " "
    )
    public void messageWith9Errors() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail(generatedEmail());
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
                .gender(generateBoolean())
                .email(generatedEmail())
                .firstName(generateCharacters())
                .lastName(generateCharacters())
                .company(generateCharacters())
                .secondAddress(generateCharacters())
                .otherInfo(generateCharacters())
                .alias(generatedEmail())
                .build();

        this.createAccountPage.inputGender(account.getGender());
        this.createAccountPage.inputEmail(account.getEmail());
        this.createAccountPage.inputFirstName(account.getFirstName());
        this.createAccountPage.inputLastName(account.getLastName());
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.clearCountry();
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageWith9Errors, "The test for messageWith9Errors has failed");
    }

    @Test(description = " "
    )
    public void messageWith8Errors() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail(generatedEmail());
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
                .gender(generateBoolean())
                .email(generatedEmail())
                .firstName(generateCharacters())
                .lastName(generateCharacters())
                .company(generateCharacters())
                .secondAddress(generateCharacters())
                .otherInfo(generateCharacters())
                .alias(generatedEmail())
                .build();

        this.createAccountPage.inputGender(account.getGender());
        this.createAccountPage.inputEmail(account.getEmail());
        this.createAccountPage.inputFirstName(account.getFirstName());
        this.createAccountPage.inputLastName(account.getLastName());
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageWith8Errors, "TThe test for messageWith8Errors has failed");
    }

    @Test(description = " "
    )
    public void messageWith7Errors() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail(generatedEmail());
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
                .gender(generateBoolean())
                .email(generatedEmail())
                .firstName(generateCharacters())
                .lastName(generateCharacters())
                .company(generateCharacters())
                .secondAddress(generateCharacters())
                .otherInfo(generateCharacters())
                .alias(generatedEmail())
                .build();

        this.createAccountPage.inputGender(account.getGender());
        this.createAccountPage.inputEmail(account.getEmail());
        this.createAccountPage.inputFirstName(account.getFirstName());
        this.createAccountPage.inputLastName(account.getLastName());
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputState();
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageWith7Errors, "TThe test for messageWith7Errors has failed");
    }

    @Test(description = " "
    )
    public void messageWith6Errors() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail(generatedEmail());
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
                .gender(generateBoolean())
                .email(generatedEmail())
                .firstName(generateCharacters())
                .lastName(generateCharacters())
                .company(generateCharacters())
                .secondAddress(generateCharacters())
                .postCode(generateZip())
                .otherInfo(generateCharacters())
                .alias(generatedEmail())
                .build();

        this.createAccountPage.inputGender(account.getGender());
        this.createAccountPage.inputEmail(account.getEmail());
        this.createAccountPage.inputFirstName(account.getFirstName());
        this.createAccountPage.inputLastName(account.getLastName());
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputState();
        this.createAccountPage.inputPostCode(account.getPostCode());
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageWith6Errors, "TThe test for messageWith6Errors has failed");
    }

    @Test(description = " "
    )
    public void messageWith5Errors() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail(generatedEmail());
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
                .gender(generateBoolean())
                .email(generatedEmail())
                .firstName(generateCharacters())
                .lastName(generateCharacters())
                .company(generateCharacters())
                .secondAddress(generateCharacters())
                .city(generateCharacters())
                .postCode(generateZip())
                .otherInfo(generateCharacters())
                .alias(generatedEmail())
                .build();

        this.createAccountPage.inputGender(account.getGender());
        this.createAccountPage.inputEmail(account.getEmail());
        this.createAccountPage.inputFirstName(account.getFirstName());
        this.createAccountPage.inputLastName(account.getLastName());
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputCity(account.getCity());
        this.createAccountPage.inputState();
        this.createAccountPage.inputPostCode(account.getPostCode());
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageWith5Errors, "TThe test for messageWith5Errors has failed");
    }

    @Test(description = " "
    )
    public void messageWith4Errors() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail(generatedEmail());
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
                .gender(generateBoolean())
                .email(generatedEmail())
                .firstName(generateCharacters())
                .lastName(generateCharacters())
                .company(generateCharacters())
                .firstAddress(generateCharacters())
                .secondAddress(generateCharacters())
                .city(generateCharacters())
                .postCode(generateZip())
                .otherInfo(generateCharacters())
                .alias(generatedEmail())
                .build();

        this.createAccountPage.inputGender(account.getGender());
        this.createAccountPage.inputEmail(account.getEmail());
        this.createAccountPage.inputFirstName(account.getFirstName());
        this.createAccountPage.inputLastName(account.getLastName());
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputFirstAddress(account.getFirstAddress());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputCity(account.getCity());
        this.createAccountPage.inputState();
        this.createAccountPage.inputPostCode(account.getPostCode());
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageWith4Errors, "TThe test for messageWith4Errors has failed");
    }

    @Test(description = " "
    )
    public void messageWith3Errors() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail(generatedEmail());
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
                .gender(generateBoolean())
                .email(generatedEmail())
                .password(generatePassword())
                .firstName(generateCharacters())
                .lastName(generateCharacters())
                .company(generateCharacters())
                .firstAddress(generateCharacters())
                .secondAddress(generateCharacters())
                .city(generateCharacters())
                .postCode(generateZip())
                .otherInfo(generateCharacters())
                .alias(generatedEmail())
                .build();

        this.createAccountPage.inputGender(account.getGender());
        this.createAccountPage.inputEmail(account.getEmail());
        this.createAccountPage.inputPassword(account.getPassword());
        this.createAccountPage.inputFirstName(account.getFirstName());
        this.createAccountPage.inputLastName(account.getLastName());
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputFirstAddress(account.getFirstAddress());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputCity(account.getCity());
        this.createAccountPage.inputState();
        this.createAccountPage.inputPostCode(account.getPostCode());
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageWith3Errors, "TThe test for messageWith3Errors has failed");
    }

    @Test(description = " "
    )
    public void messageWith2Errors() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail(generatedEmail());
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
                .gender(generateBoolean())
                .customerFirstName(generateCharacters())
                .email(generatedEmail())
                .password(generatePassword())
                .firstName(generateCharacters())
                .lastName(generateCharacters())
                .company(generateCharacters())
                .firstAddress(generateCharacters())
                .secondAddress(generateCharacters())
                .city(generateCharacters())
                .postCode(generateZip())
                .otherInfo(generateCharacters())
                .alias(generatedEmail())
                .build();

        this.createAccountPage.inputGender(account.getGender());
        this.createAccountPage.inputCustomerFirstName(account.getCustomerFirstName());
        this.createAccountPage.inputEmail(account.getEmail());
        this.createAccountPage.inputPassword(account.getPassword());
        this.createAccountPage.inputFirstName(account.getFirstName());
        this.createAccountPage.inputLastName(account.getLastName());
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputFirstAddress(account.getFirstAddress());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputCity(account.getCity());
        this.createAccountPage.inputState();
        this.createAccountPage.inputPostCode(account.getPostCode());
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageWith2Errors, "TThe test for messageWith2Errors has failed");
    }

    @Test(description = " "
    )
    public void messageWith1Errors() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail(generatedEmail());
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
                .gender(generateBoolean())
                .customerFirstName(generateCharacters())
                .customerLastName(generateCharacters())
                .email(generatedEmail())
                .password(generatePassword())
                .firstName(generateCharacters())
                .lastName(generateCharacters())
                .company(generateCharacters())
                .firstAddress(generateCharacters())
                .secondAddress(generateCharacters())
                .city(generateCharacters())
                .postCode(generateZip())
                .otherInfo(generateCharacters())
                .alias(generatedEmail())
                .build();

        this.createAccountPage.inputGender(account.getGender());
        this.createAccountPage.inputCustomerFirstName(account.getCustomerFirstName());
        this.createAccountPage.inputCustomerLastName(account.getCustomerLastName());
        this.createAccountPage.inputEmail(account.getEmail());
        this.createAccountPage.inputPassword(account.getPassword());
        this.createAccountPage.inputFirstName(account.getFirstName());
        this.createAccountPage.inputLastName(account.getLastName());
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputFirstAddress(account.getFirstAddress());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputCity(account.getCity());
        this.createAccountPage.inputState();
        this.createAccountPage.inputPostCode(account.getPostCode());
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageWith1Errors, "TThe test for messageWith1Errors has failed");
    }
}