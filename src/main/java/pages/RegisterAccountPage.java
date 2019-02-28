package pages;

import com.google.errorprone.annotations.FormatMethod;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static helpers.Utilities.getPropertyFromAppProp;
import static helpers.WebElementHelper.*;

public class RegisterAccountPage extends BasePage {

    @FindBy(id = "page")
    private WebElement pageForm;

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement pageHeadingRegistration;

    @FindBy(id = "submitAccount")
    private WebElement registerAccountButton;

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

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement registerAccountError;

    public RegisterAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(pageHeadingRegistration, pageForm, registerAccountButton);
    }

    @Override
    protected boolean isValid() {
        return areVisible(customerFirstNameField, customerLastNameField, emailField, passField);

//        firstNameField,
//                lastNameField, companyField, address1Field, address2Field, cityField, postalCodeField, additionalInfoField,
//                phoneField, mobilePhoneField, aliasField
    }

    public void register() {
        setFemaleGender();
        fillInCustomerFirstName(getPropertyFromAppProp("customerFirstName"));
        fillInCustomerLastName(getPropertyFromAppProp("customerLastName"));
        fillInPassword(getPropertyFromAppProp("passwordNew"));
        daySelect(getPropertyFromAppProp("day"));
        monthSelect(getPropertyFromAppProp("month"));
        yearSelect(getPropertyFromAppProp("year"));
        fillInFirstName(getPropertyFromAppProp("firstName"));
        fillInLastName(getPropertyFromAppProp("lastName"));
        fillInCompany(getPropertyFromAppProp("company"));
        fillInAddress1(getPropertyFromAppProp("address1"));
        fillInAddress2(getPropertyFromAppProp("address2"));
        fillInCity(getPropertyFromAppProp("city"));
        stateSelect(getPropertyFromAppProp("state"));
        fillInPostalCode(getPropertyFromAppProp("postalCode"));
        countrySelect(getPropertyFromAppProp("country"));
        fillInAdditionalInfo(getPropertyFromAppProp("additionalInfo"));
        fillInPhone(getPropertyFromAppProp("phone"));
        fillInMobilePhone(getPropertyFromAppProp("mobilePhone"));
        fillInAlias(getPropertyFromAppProp("alias"));
        clickRegisterButton();
    }


    public void registerEmptyData() {
        clickRegisterButton();
    }

    //Reload page method
//    public void reloadPage() {
//        driver.navigate().refresh();
//    }

    public void setFemaleGender() {
        genderFemaleSet.click();
    }

    public void setMaleGender() {
        genderMaleSet.click();
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

    private void daySelect(String index) {
        Select drop = new Select(daySet);
        drop.selectByValue(index);
    }

    private void monthSelect(String index) {
        Select drop = new Select(monthSet);
        drop.selectByValue(index);
    }

    private void yearSelect(String index) {
        Select drop = new Select(yearSet);
        drop.selectByValue(index);
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

    private void stateSelect(String index) {
        Select drop = new Select(stateSelect);
        drop.selectByVisibleText(index);
    }

    private void fillInPostalCode(String postalCode) {
        setFieldValue(postalCodeField, postalCode);
    }

    private void countrySelect(String index) {
        Select drop = new Select(countrySelect);
        drop.selectByVisibleText(index);
    }

    private void fillInAdditionalInfo(String additionalInfo) {
        setFieldValue(additionalInfoField, additionalInfo);
    }

    private void fillInPhone(String phone) {
        setFieldValue(phoneField, phone);
    }

    private void fillInMobilePhone(String mobilePhone) {
        setFieldValue(mobilePhoneField, mobilePhone);
    }

    private void fillInAlias(String alias) {
        setFieldValue(aliasField, alias);
    }

    public void clickRegisterButton() {
        registerAccountButton.click();
    }

    public WebElement getPageHeadingRegistration() {
        return pageHeadingRegistration;
    }

    public WebElement getRegisterAccountError() {
        return registerAccountError;
    }

    public String getRegisterAccountErrorMsg() {
        return registerAccountError.getText();
    }
}



