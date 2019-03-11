package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Utilities.selectIntValue;
import static helpers.WebElementHelper.*;

public class CreateAccountPage extends BasePage {

    //YOUR PERSONAL INFORMATION
    @FindBy(id = "id_gender1")
    private WebElement genderMale;

    @FindBy(id = "id_gender2")
    private WebElement genderFemale;

    @FindBy(css = "#customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement days;

    @FindBy(id = "months")
    private WebElement months;

    @FindBy(id = "years")
    private WebElement years;

    @FindBy(id = "newsletter")
    private WebElement newsletter;

    @FindBy(id = "optin")
    private WebElement optIn;

    //YOUR ADDRESS
    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement firstAddress;

    @FindBy(id = "address2")
    private WebElement secondAddress;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "other")
    private WebElement otherInfo;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    //Extra
    @FindBy(id = "uniform-days")
    private WebElement uniformDays;

    @FindBy(id = "uniform-months")
    private WebElement uniformMonths;

    @FindBy(id = "uniform-years")
    private WebElement uniformYears;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(customerFirstName, customerLastName, email, registerButton);
    }

    @Override
    protected boolean isValid() {
        return areVisible(customerFirstName, customerLastName, email, registerButton);
    }

    public void inputGender(boolean text) {
        if (!text) {
            genderMale.click();
        } else {
            genderFemale.click();
        }
    }

    public void inputCustomerFirstName(String text) {
        setFieldValue(customerFirstName, text);
    }

    public void inputCustomerLastName(String text) {
        setFieldValue(customerLastName, text);
    }

    public void inputEmail(String text) {
        if (driver.getPageSource().contains(email.getText())) {
            System.out.println("Email already set!");
        } else {
            setFieldValue(email, text);
        }
    }

    public void inputPassword(String text) {
        setFieldValue(password, text);
    }

    public void inputDays(int text) {
        uniformDays.click();
        if (driver.getPageSource().contains(days.getAttribute("id"))) {
            selectIntValue(days, text);
            days.click();
        } else {
            System.out.println("Day already set!");
        }
    }

//    public void inputMonths(int text) {
//        uniformMonths.click();
//        if (driver.getPageSource().contains(months.getAttribute("id"))) {
//            selectIntValue(months, text);
//            months.getCssValue("value");
//            months.click();
//        } else {
//            System.out.println("Month already set!");
//        }
//    }
//
//    public void inputYears(int text){
//        uniformYears.click();
//        if (driver.getPageSource().contains(years.getAttribute("id"))) {
//            selectIntValue(years, text);
//            years.getCssValue("value");
//            years.click();
//        } else {
//            System.out.println("Year already set!");
//        }
//    }

    public void inputPhone(String text) {
        setFieldValue(phone, text);
    }

    public void inputMobilePhone(String text) {
        setFieldValue(mobilePhone, text);
    }
}
