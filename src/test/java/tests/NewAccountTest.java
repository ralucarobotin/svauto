package tests;

import helpers.AccountBuilder;
import helpers.Utilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static pages.NewAccountErrors.*;

public class NewAccountTest extends BaseTest {
    private MyAccountPage myAccountPage = null;
    private NewAccountPage newAccountPage = null;
    private NewAccountErrors newAccountErrors = null;
    private RegistrationPage registrationPage = null;


    @BeforeMethod
    void beforeMethod() {
        this.registrationPage = new RegistrationPage(getDriver());
        this.newAccountPage = new NewAccountPage(getDriver());
        this.newAccountErrors = new NewAccountErrors(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    @Test
    public void emptyFormThrowsErrors() {
        registrationPage.gotoNewAccountForm();
        newAccountPage.verify();
        newAccountPage.clickRegisterButton();
        Assert.assertTrue(newAccountErrors.getErrorBannerElement().isDisplayed(), "No errors displayed");
        Assert.assertTrue(newAccountErrors.getAccountFormErrorText().contains(TOTAL_NUMBER_OF_ERRORS), "Incorrect number of errors displayed");
    }

    @Test (description = "Create new account form validation - happy flow\n"
                    + "Steps:\n"
                    + "1. Open the Sign in page.\n"
                    + "2. Fill in email and click create account.\n"
                    + "3. Verify the email field is autocompleted.\n"
                    + "4. Verify the first name field is autocompleted.\n"
                    + "5. Verify the last name field is autocompleted.\n"
                    + "6. Click the Register button to complete the flow.\n"
                    + "7. Verify that the My Account page is displayed.\n"
            )
    public void createValidNewAccount() {
        registrationPage.gotoNewAccountForm();
        newAccountPage.verify();
        newAccountPage.fillCreateAccountForm();
        Assert.assertTrue(newAccountPage.verifyFirstNameAutofill(), "First name was not auto-filled");
        Assert.assertTrue(newAccountPage.verifyLastNameAutofill(), "Last name was not auto-filled");
        newAccountPage.clickRegisterButton();
        myAccountPage.verify();
    }

//    @Test
//    public void invalidPasswordThrowsError(){
//        registrationPage.gotoNewAccountForm();
//        AccountBuilder account = new AccountBuilder.Builder()
//                .setGender(Utilities.generateRandomBoolean())
//                .setPersonalInfo_firstName(Utilities.generateRandomAlphabetic())
//                .setPersonalInfo_lastName(Utilities.generateRandomAlphabetic())
//                .setPasswordField("")
//                .setBirthDate_year(Utilities.randomYear())
//                .setBirthDate_month(Utilities.randomMonth())
//                .setBirthDate_day(Utilities.randomDay())
//                .setAddress_streetAddress(Utilities.generateRandomAlphabetic())
//                .setAddress_city(Utilities.generateRandomAlphabetic())
//                .setAddress_state()
//                .setAddress_postcode(Utilities.generateRandomNumbers())
//                .setAddress_mobilePhone(Utilities.generateRandomNumbers())
//                .setAddress_alias(Utilities.generateRandomAlphabetic());
//
//
//    }

}
