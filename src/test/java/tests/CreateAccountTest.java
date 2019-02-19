package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.reporters.jq.INavigatorPanel;
import pages.*;

import static helpers.Utilities.getPropertyFromAppProp;

public class CreateAccountTest extends BaseTest {

    private DashboardPage dashboardPage = null;
    private CreateAccountPage createAccountPage = null;
    private RegisterAccountPage registerAccountPage = null;
    private MyAccountPage myAccountPage = null;

    private String customerFirstName;
    private String customerLastName;
    private String emailNew;
    private String passwordNew;
    private Integer day;
    private Integer month;
    private Integer year;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Integer postalCode;
    private String country;
    private String additionalInfo;
    private Integer phone;
    private Integer mobilePhone;
    private String alias;

    public CreateAccountTest() {
        this.customerFirstName = getPropertyFromAppProp("customerFirstName");
        this.customerLastName = getPropertyFromAppProp("customerLastName");
        this.emailNew = getPropertyFromAppProp("emailNew");
        this.passwordNew = getPropertyFromAppProp("passwordNew");
        this.day = Integer.parseInt(getPropertyFromAppProp("day"));
        this.month = Integer.parseInt(getPropertyFromAppProp("month"));
        this.year = Integer.parseInt(getPropertyFromAppProp("year"));
        this.firstName = getPropertyFromAppProp("firstName");
        this.lastName = getPropertyFromAppProp("lastName");
        this.company = getPropertyFromAppProp("company");
        this.address1 = getPropertyFromAppProp("address1");
        this.address2 = getPropertyFromAppProp("address2");
        this.city = getPropertyFromAppProp("city");
        this.state = getPropertyFromAppProp("state");
        this.postalCode = Integer.parseInt(getPropertyFromAppProp("postalCode"));
        this.country = getPropertyFromAppProp("country");
        this.additionalInfo = getPropertyFromAppProp("additionalInfo");
        this.phone = Integer.parseInt(getPropertyFromAppProp("phone"));
        this.mobilePhone = Integer.parseInt(getPropertyFromAppProp("mobilePhone"));
        this.alias = getPropertyFromAppProp("alias");
    }

    @BeforeMethod
    void beforeMethod() {
        this.dashboardPage = new DashboardPage(getDriver());
        this.createAccountPage = new CreateAccountPage(getDriver());
        this.registerAccountPage = new RegisterAccountPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    @Test
    public void testCreateAccount() {
        this.dashboardPage.open();
        this.dashboardPage.verify();
        this.dashboardPage.clickLoginButton();

        this.createAccountPage.verify();
        this.createAccountPage.create(emailNew);

        this.registerAccountPage.verify();
        this.registerAccountPage.register(customerFirstName, customerLastName, passwordNew, day, month, year, firstName,
                lastName, company, address1, address2, city, state, postalCode, country, additionalInfo, phone, mobilePhone,
                alias);

        this.myAccountPage.verify();
    }
}
