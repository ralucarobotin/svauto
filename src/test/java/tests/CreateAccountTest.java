package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static helpers.Utilities.*;

public class CreateAccountTest extends BaseTest {

    private LoginPage loginPage = null;
    private CreateAccountPage createAccountPage = null;

    private String phoneRequired;
    private String firstNameRequired;
    private String lasttNameRequired;
    private String passwordRequired;
    private String firstAddressRequired;
    private String cityRequired;
    private String postalCodeRequired;
    private String stateRequired;
    private String countryRequired;

    public CreateAccountTest() {
        this.phoneRequired = "You must register at least one phone number.";
        this.firstNameRequired = "firstname is required.";
        this.lasttNameRequired = "lastname is required.";
        this.passwordRequired = "passwd is required.";
        this.firstAddressRequired = "address1 is required";
        this.cityRequired = "city is required.";
        this.postalCodeRequired = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
        this.stateRequired = "This country requires you to choose a State.";
        this.countryRequired = "Country is invalid";
    }

    @BeforeMethod
    void beforeMethod() {
        this.loginPage = new LoginPage(getDriver());
        this.createAccountPage = new CreateAccountPage(getDriver());
    }

//    @Test(description = "Test create account page with valid credentials:\n " +
//            "Steps:\n" +
//            "1. Navigate to the Dashboard page with URL: http://automationpractice.com/index.php\n" +
//            "2. Verify that the Dashboard page is loaded correctly.\n" +
//            "3. Input email.\n" +
//            "4. Click on the 'Create an account' button\n" +
//            "5. Verify that the 'Authentication' page is loaded correctly.\n" +
//            "6. Input valid credentials in all the fields.\n" +
//            "7. Click on the 'Register' button.\n"
//    )
//    public void testCreateValidAccount() {
//        this.loginPage.openLoginPage();
//        this.loginPage.verify();
//        this.loginPage.fillInAccountEmail(generatedEmail());
//        this.loginPage.clickCreateAccountButton();
//        this.createAccountPage.verify();
//        Account account = new Account.Builder()
//                .gender(generateBoolean())
//                .customerFirstName(generateCharacters())
//                .customerLastName(generateCharacters())
//                .email(generatedEmail())
//                .password(generatePassword())
//                .firstName(generateCharacters())
//                .lastName(generateCharacters())
//                .company(generateCharacters())
//                .firstAddress(generateCharacters())
//                .secondAddress(generateCharacters())
//                .city(generateCharacters())
//                .postCode(generateZip())
//                .otherInfo(generateCharacters())
//                .phone(generateNumbers())
//                .mobilePhone(generateNumbers())
//                .alias(generatedEmail())
//                .build();
//
//        this.createAccountPage.inputGender(account.getGender());
//        this.createAccountPage.inputCustomerFirstName(account.getCustomerFirstName());
//        this.createAccountPage.inputCustomerLastName(account.getCustomerLastName());
//        this.createAccountPage.inputEmail(account.getEmail());
//        this.createAccountPage.inputPassword(account.getPassword());
//        this.createAccountPage.inputDays();
//        this.createAccountPage.inputMonths();
//        this.createAccountPage.inputYears();
//        this.createAccountPage.inputNewsLetter();
//        this.createAccountPage.inputOptIn();
//        this.createAccountPage.inputFirstName(account.getFirstName());
//        this.createAccountPage.inputLastName(account.getLastName());
//        this.createAccountPage.inputCompany(account.getCompany());
//        this.createAccountPage.inputFirstAddress(account.getFirstAddress());
//        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
//        this.createAccountPage.inputCity(account.getCity());
//        this.createAccountPage.inputState();
//        this.createAccountPage.inputPostCode(account.getPostCode());
//        this.createAccountPage.inputCountry();
//        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
//        this.createAccountPage.inputPhone(account.getPhone());
//        this.createAccountPage.inputMobilePhone(account.getMobilePhone());
//        this.createAccountPage.inputAlias(account.getAlias());
//        this.createAccountPage.clickRegisterButton();
//        this.createAccountPage.verify();
//    }

    @Test(description = "Test adding data to the non mandatory fields\n" +
            "1. Navigate successfully to the account creation page.\n" +
            "2. Input data into the fields that are not mandatory.\n" +
            "3. Click on the 'Register' button"
    )
    public void testRequiredNotInput() {
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
                .phone(generateNumbers())
                .mobilePhone(generateNumbers())
                .alias(generatedEmail())
                .build();

        this.createAccountPage.inputGender(account.getGender());
        this.createAccountPage.inputEmail(account.getEmail());
        this.createAccountPage.inputDays();
        this.createAccountPage.inputMonths();
        this.createAccountPage.inputYears();
        this.createAccountPage.inputNewsLetter();
        this.createAccountPage.inputOptIn();
        this.createAccountPage.inputFirstName(account.getFirstName());
        this.createAccountPage.inputLastName(account.getLastName());
        this.createAccountPage.inputCompany(account.getCompany());
        this.createAccountPage.inputSecondAddress(account.getSecondAddress());
        this.createAccountPage.inputOtherInfo(account.getOtherInfo());
        this.createAccountPage.inputPhone(account.getPhone());
        this.createAccountPage.inputMobilePhone(account.getMobilePhone());
        this.createAccountPage.inputAlias(account.getAlias());
        this.createAccountPage.clickRegisterButton();
        this.createAccountPage.verify();
    }
}
