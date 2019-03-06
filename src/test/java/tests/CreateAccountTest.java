package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CreateAccountTest extends BaseTest {

    private DashboardPage dashboardPage = null;
    private LoginPage loginPage = null;
    private CreateAccountPage createAccountPage = null;

    @BeforeMethod
    void beforeMethod(){
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
        Account account = Account.Builder
                .genderMale()
                .genderFemale()
                .customerFirstName()
                .customerLastName()
                .email()
                .password()
                .days()
                .months()
                .years()
                .newsletter()
                .optIn()
                .firstName()
                .lastName()
                .company()
                .firstAddress()
                .secondAddress()
                .city()
                .state()
                .postcode()
                .country()
                .otherInfo()
                .phone()
                .mobilePhone()
                .alias()
                .build();

        this.createAccountPage.selectGender(account.getGenderFemale());
        this.createAccountPage.inputCustomerFirstName(account.getCustomerFirstName());
//        this.createAccountPage.inputCustomerLastName();
//        this.createAccountPage.inputHomePhone();
//        this.createAccountPage.verify();
    }
}
