package pages;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class NewAccountPage extends BasePage{

    private static final String URL = "automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
    private RegistrationPage registrationPage = null;
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

    @FindBy (id = "days")
    private WebElement birthDate_day;

    @FindBy (id = "months")
    private WebElement birthDate_month;

    @FindBy (id = "years")
    private WebElement birthDate_year;

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

    @FindBy (id = "postcode")
    private WebElement address_postcode;

    @FindBy (id = "uniform-id_country")
    private WebElement address_country;

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
    protected boolean isCurrent() {
        return areVisible(registerButton);
        }

    @Override
    protected boolean isValid() {
        return areVisible(gender_male, gender_female, personalInfo_firstName, personalInfo_lastName, personalInfo_emailField, passwordField, birthDate_day, birthDate_month, birthDate_year, address_firstName, address_lastName, address_company, address_streetAddress, address_city, address_state, address_postcode, address_country, address_mobilePhone, address_alias, registerButton);
    }
    public void open(){
        openUrl(URL);
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
        return !this.personalInfo_emailField.getText().equals(StringUtils.EMPTY);
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

    public void selectBirthDate_day() {

        waitForElementToAppear(birthDate_day);
        Select birthDay_dropdown = new Select(this.birthDate_day);
        this.birthDate_day.click();
       birthDay_dropdown.selectByIndex(new Random().nextInt(birthDay_dropdown.getOptions().size()));
    }

    public void selectBirthDate_month(){
        waitForElementToAppear(birthDate_month);
        Select birthMonth_dropdown = new Select(this.birthDate_month);
        this.birthDate_month.click();
        birthMonth_dropdown.selectByIndex(new Random().nextInt(birthMonth_dropdown.getOptions().size()));
    }

    public void selectBirthDate_year(){
        waitForElementToAppear(birthDate_year);
        Select birthYear_dropdown = new Select(this.birthDate_year);
        birthYear_dropdown.selectByIndex(new Random().nextInt(birthYear_dropdown.getOptions().size()));
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

    public void selectState_dropdown() {
        waitForElementToAppear(address_state);
        Select state_dropdown = new Select(address_state);
        state_dropdown.selectByIndex(new Random().nextInt(state_dropdown.getOptions().size()));
    }

    public void fillZipCode(){
        setFieldValue(address_postcode, RandomStringUtils.randomNumeric(5));
    }

    public void selectCountry_dropdown(String country) {
        waitForElementToAppear(address_country);
        Select country_dropdown = new Select(address_country);
        this.address_country.click();
        country_dropdown.selectByVisibleText(country);
    }

    public void fillPhoneNumber(){
        setFieldValue(this.address_mobilePhone, RandomStringUtils.randomNumeric(10));
    }

    public void fillAliasAddress(){
        setFieldValue(this.address_alias, RandomStringUtils.randomAlphabetic(10));
    }

    public void clickRegisterButton(){
        this.registerButton.click();
    }

    public WebElement getRegisterButton(){
        return this.registerButton;
    }

    public void fillCreateAccountForm(){
        selectFemaleGender();
        fillFirstName();
        fillLastName();
        fillPassword();
        selectBirthDate_day();
        selectBirthDate_month();
        selectBirthDate_year();
        fillCompanyAddress();
        fillAddress();
        fillCity();
        selectState_dropdown();
        fillZipCode();
        selectCountry_dropdown("United States");
        fillPhoneNumber();
        fillAliasAddress();
    }

}
