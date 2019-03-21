package tests;

import helpers.Utilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class RegistrationTest extends BaseTest{

    private NewAccountPage newAccountPage = null;
    private RegistrationPage registrationPage = null;
    private RegistrationPageErrors registrationPageErrors = null;

    @BeforeMethod
    void beforeMethod() {
        this.registrationPage = new RegistrationPage(getDriver());
        this.registrationPageErrors = new RegistrationPageErrors(getDriver());
        this.newAccountPage = new NewAccountPage(getDriver());
    }

    @Test
    public void invalidEmailThrowsAnError(){
        registrationPage.open();
        registrationPage.verify();
        registrationPage.fillEmailAddress("invalidemail.com");
        registrationPageErrors.verify();
        Assert.assertEquals(registrationPageErrors.getCreateAccountErrorText(),RegistrationPageErrors.INVALID_EMAIL, "Invalid email error text is different.");
    }

    @Test (priority = 1)
    public void emailAlreadyInUseThrowsAnError(){
        registrationPage.open();
        registrationPage.verify();
        registrationPage.fillEmailAddress(Utilities.getPropertyFromAppProp("registeredEmail"));
        registrationPageErrors.verify();
        Assert.assertEquals(registrationPageErrors.getCreateAccountErrorText(),RegistrationPageErrors.EMAIL_IN_USE, "Email already in use error text is different.");
    }

    @Test
    public void validEmailOpensNewAccountPage(){
        registrationPage.open();
        registrationPage.verify();
        registrationPage.fillEmailAddress(Utilities.generateEmail());
        registrationPage.clickCreateAccount();
        newAccountPage.verify();
    }

    @Test
    public void emailAddressAutofillsOnNewAccountPage(){
        registrationPage.open();
        registrationPage.verify();
        registrationPage.fillEmailAddress(Utilities.generateEmail());
        newAccountPage.verify();
        Assert.assertTrue(newAccountPage.getEmailAutofillText().contains("mailinator.com"), "The email address was not auto-filled");
    }
}
