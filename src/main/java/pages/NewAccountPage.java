package pages;

import helpers.Utilities;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class NewAccountPage extends BasePage{

    private LoginPage loginPage = null;
    private DashboardPage dashboardPage = null;

    //YOUR PERSONAL INFORMATION
    @FindBy (id = "id_gender1")
    private WebElement gender_male;

    @FindBy (id = "id_gender2")
    private WebElement gender_female;

    @FindBy (id = "customer_firstname")
    private WebElement personalInfo_firstName;

    @FindBy (id = "customer_lastname")
    private WebElement personalInfo_lastName;

    @FindBy (id = "email")
    private WebElement personalInfo_emailField;

    @FindBy (id = "passwd")
    private WebElement passwordField;

    @FindBy (css = "select#days")
    private WebElement birthDate_day;
    private Select birthDay_dropdown = new Select(birthDate_day);

    @FindBy (css = "select#months")
    private WebElement birthDate_month;
    private Select birthMonth_dropdown = new Select(birthDate_month);

    @FindBy (css = "select#years")
    private WebElement birthDate_year;
    private Select birthYear_dropdown = new Select(birthDate_year);

    //YOUR ADDRESS
    @FindBy (id = "firstname")
    private WebElement address_firstName;

    @FindBy (id = "lastname")
    private WebElement address_lastName;

    @FindBy (id = "company")
    private WebElement address_company;

    @FindBy (id = "address1")
    private WebElement address_streetAddress;

    @FindBy (id = "city")
    private WebElement address_city;

    @FindBy (id = "id_state")
    private WebElement address_state;
    private Select state_dropdown = new Select(address_state);

    @FindBy (id = "postcode")
    private WebElement address_postcode;

    @FindBy (id = "id_country")
    private WebElement address_country;
    private Select country_dropdown = new Select(address_country);

    @FindBy (id = "phone")
    private WebElement address_mobilePhone;

    @FindBy (id = "alias")
    private WebElement address_alias;

    @FindBy (id = "submitAccount")
    private WebElement registerButton;

    @FindBy (css = "#center_column > div.alert.alert-danger > ol > li")
    private WebElement accountFormError;

    @FindBy (css = ".inline-infos")
    private WebElement inlineInfo;

    public static final String INVALID_EMAIL_ERROR = "Invalid email address.";
    public static final String EMAIL_EXISTS_ERROR = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
    public static final String LAST_NAME_REQUIRED_ERROR = "lastname is required.";
    public static final String FIRST_NAME_REQUIRED_ERROR = "firstname is required.";
    public static final String PSWD_REQUIRED_ERROR = "passwd is required.";
    public static final String ADDRESS_REQUIRED_ERROR = "address1 is required.";
    public static final String CITY_REQUIRED_ERROR = "city is required.";
    public static final String ZIP_INVALID_ERROR = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
    public static final String STATE_REQUIRED_ERROR = "This country requires you to choose a State.";
    public static final String PHONE_REQUIRED_TIP = "You must register at least one phone number.";
    public static final String COUNTRY_REQUIRED_ERROR = "Country is invalid";
    public static final String INVALID_LAST_NAME_ERROR = "lastname is invalid.";
    public static final String INVALID_FIRST_NAME_ERROR = "firstname is invalid.";

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {return areVisible(registerButton);
        }

    @Override
    protected boolean isValid() {
        return areVisible(gender_male, gender_female, personalInfo_firstName, personalInfo_lastName, personalInfo_emailField, passwordField, birthDate_day, birthDate_month, birthDate_year, address_firstName, address_lastName, address_company, address_streetAddress, address_city, address_state, address_postcode, address_country, address_mobilePhone, address_alias, registerButton);
    }

    public void openNewAccountPage() {
        dashboardPage.verify();
        dashboardPage.clickLoginButton();
        loginPage.verify();
        loginPage.fillEmailAddress(Utilities.generateNewEmail("mailinator"));
        loginPage.clickCreateAccount();
        this.verify();
    }

    public String getAccountFormErrorText(){
        return accountFormError.getText();
    }

    public WebElement getErrorBannerElement(){
        return accountFormError;
    }

    public String getPhoneRequiredTooltipText() {
        return this.inlineInfo.getText();
    }

    public boolean verifyEmailAutofill(){
        if (!this.personalInfo_emailField.getText().equals(StringUtils.EMPTY)) {
            return true;
        } else return false;
    }

    public void selectFemaleGender(){
        gender_female.click();
    }

    public void selectMaleGender(){
        gender_male.click();
    }

    public void fillFirstName(){
        setFieldValue(personalInfo_firstName, RandomStringUtils.randomAlphabetic(5));
    }

    public void fillLastName(){
        setFieldValue(personalInfo_firstName, RandomStringUtils.randomAlphabetic(5));
    }

    public void fillPassword(){
        setFieldValue(passwordField, RandomStringUtils.randomAlphanumeric(10));
    }

    public void setBirthDay_dropdown(String value) {
        this.birthDay_dropdown.selectByValue(value);
    }

    public void setBirthDate_month(String value){
        this.birthMonth_dropdown.selectByValue(value);
    }

    public void setBirthDate_year(String value){
        this.birthYear_dropdown.selectByValue(value);
    }

    public boolean verifyFirstNameAutofill(){
       return this.address_firstName.getText().equals(this.personalInfo_firstName.getText());
    }

    public boolean verifyLastNameAutofill(){
        return this.address_lastName.getText().equals(this.personalInfo_lastName.getText());
    }

    public void fillCompanyAddress() {
        setFieldValue(address_company, RandomStringUtils.randomAlphabetic(5));
    }

    public void fillAddress() {
        setFieldValue(address_streetAddress, RandomStringUtils.randomAlphabetic(10));
    }

    public void fillCity() {
        setFieldValue(address_city, RandomStringUtils.randomAlphabetic(10));
    }

    public void setState_dropdown(String stateName) {
        this.state_dropdown.selectByVisibleText(stateName);
    }

    public void fillZipCode(){
        setFieldValue(address_postcode, RandomStringUtils.randomNumeric(5,5));
    }

    public void setCountry_dropdown(String countryName) {
        this.country_dropdown.selectByVisibleText(countryName);
    }

    public void fillPhoneNumber(String phoneNumber){
        setFieldValue(this.address_mobilePhone, phoneNumber);
    }

    public void fillAliasAddress(String aliasAddress){
        setFieldValue(this.address_alias, aliasAddress);
    }

    public void clickRegisterButton(){
        this.registerButton.click();
    }



}
