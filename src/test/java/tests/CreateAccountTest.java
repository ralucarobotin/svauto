package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static helpers.Utilities.*;

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
    public void testCreateValidAccount() {
        this.loginPage.openLoginPage();
        this.loginPage.verify();
        this.loginPage.fillInAccountEmail(generatedEmail());
        this.loginPage.clickCreateAccountButton();
        this.createAccountPage.verify();
        Account account = new Account.Builder()
//                .gender(generateBoolean())
//                .customerFirstName(generateCharacters())
//                .customerLastName(generateCharacters())
//                .email(generatedEmail())
//                .password(generatePassword())
//                .days(generateDays())
//                .months(generateMonths())
//                .years(generateYears())
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
                .phone(generateNumbers())
                .mobilePhone(generateNumbers())
//                .alias()
                .build();

//        this.createAccountPage.inputGender(account.getGender());
//        this.createAccountPage.inputCustomerFirstName(account.getCustomerFirstName());
//        this.createAccountPage.inputCustomerLastName(account.getCustomerLastName());
//        this.createAccountPage.inputEmail(account.getEmail());
//        this.createAccountPage.inputPassword(account.getPassword());
//        this.createAccountPage.inputDays(account.getDays());
//        this.createAccountPage.inputMonths(account.getMonths());
//        this.createAccountPage.inputYears(account.getYears());
        this.createAccountPage.inputPhone(account.getPhone());
        this.createAccountPage.inputMobilePhone(account.getMobilePhone());
        this.createAccountPage.verify();
    }
}
