package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.*;
import static helpers.WebElementHelper.setFieldValue;
import static helpers.WebElementHelper.setFieldNumeric;

public class RegisterAccountPage extends BasePage {

    @FindBy(className = "page-heading")
    private WebElement createAccountText;

    //YOUR PERSONAL INFORMATION
    @FindBy(id = "id_gender1")
    private WebElement genderMaleSet;

    @FindBy(id = "id_gender2")
    private WebElement genderFemaleSet;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passField;

    //Date of Birth
    @FindBy(id = "days")
    private WebElement daySet;

    @FindBy(id = "months")
    private WebElement monthSet;

    @FindBy(id = "years")
    private WebElement yearSet;

    //YOUR ADDRESS
    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "address1")
    private WebElement address1Field;

    @FindBy(id = "address2")
    private WebElement address2Field;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "id_state")
    private WebElement stateSelect;

    @FindBy(id = "postcode")
    private WebElement postalCodeField;

    @FindBy(id = "id_country")
    private WebElement countrySelect;

    @FindBy(id = "other")
    private WebElement additionalInfoField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;

    @FindBy(id = "alias")
    private WebElement aliasField;

    @FindBy(id = "submitAccount")
    private WebElement registerAccountButton;

    public RegisterAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(createAccountText);
    }

//    customerFirstNameField, customerLastNameField, emailField, passField,
//    firstNameField, lastNameField, companyField, address1Field, address2Field,
//    cityField, postalCodeField, additionalInfoField, phoneField, mobilePhoneField, aliasField,
//    registerAccountButton

    @Override
    protected boolean isValid() {
        return areVisible(createAccountText);
    }

    public void register(String customerfirstName, String customerLastName, String password, Integer day, Integer month,
                         Integer year, String firstName, String lastName, String company, String address1, String address2,
                         String city, String state, Integer postalCode, String country, String additionalInfo, Integer phone,
                         Integer mobilePhone, String alias) {

        //genderMaleSet.click();
        //genderFemaleSet.click();
        fillInCustomerFirstName(customerfirstName);
        fillInCustomerLastName(customerLastName);
        fillInPassword(password);
        setDay(day);
        setMonth(month);
        setYear(year);
        fillInFirstName(firstName);
        fillInLastName(lastName);
        fillInCompany(company);
        fillInAddress1(address1);
        fillInAddress2(address2);
        fillInCity(city);
        selectState(state);
        fillInPostalCode(postalCode);
        selectCountry(country);
        fillInAdditionalInfo(additionalInfo);
        fillInPhone(phone);
        fillInMobilePhone(mobilePhone);
        fillInAlias(alias);
        registerAccountButton.click();
    }

    private void fillInCustomerFirstName(String customerFirstName) {
        setFieldValue(customerFirstNameField, customerFirstName);
    }

    private void fillInCustomerLastName(String customerLastName) {
        setFieldValue(customerLastNameField, customerLastName);
    }

    private void fillInPassword(String password) {
        setFieldValue(passField, password);
    }

    private void setDay(Integer day) {
        setFieldNumeric(daySet, day);
    }

    private void setMonth(Integer month) {
        setFieldNumeric(monthSet, month);
    }

    private void setYear(Integer year) {
        setFieldNumeric(yearSet, year);
    }

    private void fillInFirstName(String firstName) {
        setFieldValue(firstNameField, firstName);
    }

    private void fillInLastName(String lastName) {
        setFieldValue(lastNameField, lastName);
    }

    private void fillInCompany(String company) {
        setFieldValue(companyField, company);
    }

    private void fillInAddress1(String address1) {
        setFieldValue(address1Field, address1);
    }

    private void fillInAddress2(String address2) {
        setFieldValue(address2Field, address2);
    }

    private void fillInCity(String city) {
        setFieldValue(cityField, city);
    }

    private void selectState(String state) {
        setFieldValue(stateSelect, state);
    }

    private void fillInPostalCode(Integer postalCode) {
        setFieldNumeric(postalCodeField, postalCode);
    }

    private void selectCountry(String country) {
        setFieldValue(countrySelect, country);
    }

    private void fillInAdditionalInfo(String additionalInfo) {
        setFieldValue(additionalInfoField, additionalInfo);
    }

    private void fillInPhone(Integer phone) {
        setFieldNumeric(phoneField, phone);
    }

    private void fillInMobilePhone(Integer mobilePhone) {
        setFieldNumeric(mobilePhoneField, mobilePhone);
    }

    private void fillInAlias(String alias) {
        setFieldValue(aliasField, alias);
    }
}



