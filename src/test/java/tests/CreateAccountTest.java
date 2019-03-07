package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import static helpers.WebElementHelper.inputLetters;
import static helpers.WebElementHelper.inputNumbers;


public class CreateAccountTest extends BaseTest {

    private DashboardPage dashboardPage = null;
    private LoginPage loginPage = null;
    private CreateAccountPage createAccountPage = null;

    @BeforeMethod
    void beforeMethod() {
        this.dashboardPage = new DashboardPage(getDriver());
        this.loginPage = new LoginPage(getDriver());
        this.createAccountPage = new CreateAccountPage(getDriver());
    }

    @Test
    public void testInput() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail();
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
//                .genderMale(selectGender())
//                .genderFemale(selectGender())
                .customerFirstName(inputLetters())
                .customerLastName(inputLetters())
//                .email()
//                .password()
//                .days()
//                .months()
//                .years()
//                .newsletter()
//                .optIn()
//                .firstName()
//                .lastName()
//                .company()
//                .firstAddress()
//                .secondAddress()
//                .city()
//                .state()
//                .postcode()
//                .country()
//                .otherInfo()
                .phone(inputNumbers())
//                .mobilePhone()
//                .alias()
                .build();

//        this.createAccountPage.inputGender();
        this.createAccountPage.inputCustomerFirstName(account.getCustomerFirstName());
        this.createAccountPage.inputCustomerLastName(account.getCustomerLastName());
        this.createAccountPage.inputHomePhone(account.getPhone());
//        this.createAccountPage.verify();
    }
}
