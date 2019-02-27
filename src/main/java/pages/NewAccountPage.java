package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class NewAccountPage extends BasePage{

    @FindBy(id = "email_create")
    private WebElement createEmailField;

    @FindBy(css="button #SubmitCreate")
    private WebElement createAccountButton;

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

    @FindBy (css = "select#days.form-control")
    private WebElement birthDate_day;

    @FindBy (id = "select#months.form-control")
    private WebElement birthDate_month;

    @FindBy (id = "select#years.form-control")
    private WebElement birthDate_year;

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

    @FindBy (id = "postcode")
    private WebElement address_postcode;

    @FindBy (id = "id_country")
    private WebElement address_country;

    @FindBy (id = "phone")
    private WebElement address_mobilePhone;

    @FindBy (id = "alias")
    private WebElement address_alias;

    @FindBy (id = "submitAccount")
    private WebElement registerButton;

    @FindBy (id = "create_account_error")
    private WebElement createAccountError;

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
        return areVisible(createEmailField, gender_male, gender_female, personalInfo_firstName, personalInfo_lastName, personalInfo_emailField,  passwordField, birthDate_day, birthDate_month, birthDate_year, address_firstName, address_lastName, address_company, address_streetAddress, address_city, address_state, address_postcode, address_country, address_mobilePhone, address_alias, registerButton);
    }

    public void clickCreateAccount(){
        this.createAccountButton.click();
    }

    public String getCreateAccountErrorText(){
        return this.createAccountError.getText();
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
        if(this.personalInfo_emailField.getText().equals(this.createEmailField.getText())) {
            return true;
        } else return false;
    }

    public void selectFemaleGender(){
        gender_female.click();
    }

    public void selectMaleGender(){
        gender_male.click();
    }

    public void fillEmailAddress(String email){
        setFieldValue(createEmailField,email);
    }

    public void fillFirstName(String firstName){
        setFieldValue(personalInfo_firstName, firstName);
    }

    public void fillLastName(String lastName){
        setFieldValue(personalInfo_firstName, lastName);
    }

    public void fillPassword(String password){
        setFieldValue(passwordField, password);
    }


    private Select birthDay_dropdown = new Select(this.birthDate_day);

    public void setBirthDay_dropdown(String value) {
        this.birthDay_dropdown.selectByValue(value);
    }

    private Select birthMonth_dropdown = new Select(this.birthDate_month);

    public void setBirthDate_month(String value){
        this.birthMonth_dropdown.selectByValue(value);
    }

    private Select birthYear_dropdown = new Select(this.birthDate_year);

    public void setBirthDate_year(String value){
        this.birthYear_dropdown.selectByValue(value);
    }


    public boolean verifyFirstNameAutofill(){
        if(this.address_firstName.getText().equals(this.personalInfo_firstName.getText())) {
            return true;
        } else return false;
    }

    public boolean verifyLastNameAutofill(){
        return this.address_lastName.getText().equals(this.personalInfo_lastName.getText());
    }

    public void fillCompanyAddress(String company) {
        setFieldValue(address_company, company);
    }

    public void fillAddress(String address) {
        setFieldValue(address_streetAddress, address);
    }

    public void fillCity(String cityName) {
        setFieldValue(address_city, cityName);
    }


    private Select country_dropdown = new Select(this.address_country);

    public void setCountry_dropdown(String countryName) {
        this.country_dropdown.deselectByVisibleText(countryName);
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
