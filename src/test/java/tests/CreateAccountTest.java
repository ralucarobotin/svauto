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

    private String messageForNoMandatoryInput;
    private String messageForEmailAdded;
    private String messageForEmailCountryAdded;
    private String messageForEmailCountryStateAdded;
    private String messageForEmailCountryStateZipAdded;
    private String messageForEmailCountryStateZipCityAdded;
    private String messageForEmailCountryStateZipCityAddressAdded;
    private String messageForEmailCountryStateZipCityAddressPasswordAdded;
    private String messageForEmailCountryStateZipCityAddressPasswordFirstNameAdded;
    private String messageForEmailCountryStateZipCityAddressPasswordFirstNameLastNameAdded;

    public CreateAccountTest() {
        this.messageForNoMandatoryInput = getPropertyFromAppProp("messageForNoMandatoryInput");
        this.messageForEmailAdded = getPropertyFromAppProp("messageForEmailAdded");
        this.messageForEmailCountryAdded = getPropertyFromAppProp("messageForEmailCountryAdded");
        this.messageForEmailCountryStateAdded = getPropertyFromAppProp("messageForEmailCountryStateAdded");
        this.messageForEmailCountryStateZipAdded = getPropertyFromAppProp("messageForEmailCountryStateZipAdded");
        this.messageForEmailCountryStateZipCityAdded = getPropertyFromAppProp("messageForEmailCountryStateZipCityAdded");
        this.messageForEmailCountryStateZipCityAddressAdded = getPropertyFromAppProp("messageForEmailCountryStateZipCityAddressAdded");
        this.messageForEmailCountryStateZipCityAddressPasswordAdded = getPropertyFromAppProp("messageForEmailCountryStateZipCityAddressPasswordAdded");
        this.messageForEmailCountryStateZipCityAddressPasswordFirstNameAdded = getPropertyFromAppProp("messageForEmailCountryStateZipCityAddressPasswordFirstNameAdded");
        this.messageForEmailCountryStateZipCityAddressPasswordFirstNameLastNameAdded = getPropertyFromAppProp("messageForEmailCountryStateZipCityAddressPasswordFirstNameLastNameAdded");
    }

    @BeforeMethod
    void beforeMethod() {
        this.loginPage = new LoginPage(getDriver());
        this.createAccountPage = new CreateAccountPage(getDriver());
        this.postCreateAccountPage = new PostCreateAccountPage(getDriver());
    }

    @Test(invocationCount = 3, description = "Test create account page with valid credentials:\n " +
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
        this.createAccountPage.inputDate2();
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

    @Test(description = "Test create account page with no valid credentials added:" +
            "Steps:" +
            "1. Navigate to the Login page with URL: http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation" +
            "2. Verify that the Login page is loaded correctly." +
            "3. Input email." +
            "4. Click on the 'Create an account' button." +
            "5. Verify that the 'Authentication' page is loaded correctly." +
            "6. Input only the fields where valid credentials are not required." +
            "7. Click on the 'Register' button." +
            "8. Verify that the error message displays the mandatory error Strings."
    )
    public void messageForNoMandatoryInput() {
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
        this.createAccountPage.inputDate2();
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.clearCountry();
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageForNoMandatoryInput,
                "The test for messageForNoMandatoryInput has failed");
    }

    @Test(description = "TBD"
    )
    public void messageForEmailAdded() {
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
        this.createAccountPage.inputDate2();
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.clearCountry();
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageForEmailAdded,
                "The test for messageForEmailAdded has failed");
    }

    @Test(description = "TBD"
    )
    public void messageForEmailCountryAdded() {
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
        this.createAccountPage.inputDate2();
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageForEmailCountryAdded,
                "The test for messageForEmailCountryAdded has failed");
    }

    @Test(description = "TBD"
    )
    public void messageForEmailCountryStateAdded() {
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
        this.createAccountPage.inputDate2();
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputState();
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageForEmailCountryStateAdded,
                "The test for messageForEmailCountryStateAdded has failed");
    }

    @Test(description = "TBD"
    )
    public void messageForEmailCountryStateZipAdded() {
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
        this.createAccountPage.inputDate2();
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputState();
        this.createAccountPage.inputPostCode(account.getPostCode());
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
        Assert.assertTrue(this.createAccountPage.getCreateAccountErrorMessage());
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageForEmailCountryStateZipAdded,
                "The test for messageForEmailCountryStateZipAdded has failed");
    }

    @Test(description = "TBD"
    )
    public void messageForEmailCountryStateZipCityAdded() {
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
        this.createAccountPage.inputDate2();
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
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageForEmailCountryStateZipCityAdded,
                "The test for messageForEmailCountryStateZipCityAdded has failed");
    }

    @Test(description = "TBD"
    )
    public void messageForEmailCountryStateZipCityAddressAdded() {
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
        this.createAccountPage.inputDate2();
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
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageForEmailCountryStateZipCityAddressAdded,
                "The test for messageForEmailCountryStateZipCityAddressAdded has failed");
    }

    @Test(description = "TBD"
    )
    public void messageForEmailCountryStateZipCityAddressPasswordAdded() {
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
        this.createAccountPage.inputDate2();
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
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageForEmailCountryStateZipCityAddressPasswordAdded,
                "The test for messageForEmailCountryStateZipCityAddressPasswordAdded has failed");
    }

    @Test(description = "TBD"
    )
    public void messageForEmailCountryStateZipCityAddressPasswordFirstNameAdded() {
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
        this.createAccountPage.inputDate2();
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
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageForEmailCountryStateZipCityAddressPasswordFirstNameAdded,
                "The test for messageForEmailCountryStateZipCityAddressPasswordFirstNameAdded has failed");
    }

    @Test(description = "TBD"
    )
    public void messageForEmailCountryStateZipCityAddressPasswordFirstNameLastNameAdded() {
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
        this.createAccountPage.inputDate();
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
        Assert.assertEquals(this.createAccountPage.getStringsCreateAccountErrorMessage(), messageForEmailCountryStateZipCityAddressPasswordFirstNameLastNameAdded,
                "The test for messageForEmailCountryStateZipCityAddressPasswordFirstNameLastNameAdded has failed");
    }
}