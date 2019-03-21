package pages;

import helpers.Utilities;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import static helpers.Utilities.*;
import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.setFieldValue;

public class NewAccountPage extends BasePage{

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

    @FindBy (id = "id_country")
    private WebElement address_country;

    @FindBy (id = "phone")
    private WebElement address_mobilePhone;

    @FindBy (id = "alias")
    private WebElement address_alias;

    @FindBy (id = "submitAccount")
    private WebElement registerButton;

    @FindBy (css = ".inline-infos")
    private WebElement inlineInfo;

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(registerButton);
        }

    @Override
    protected boolean isValid() {
        return areVisible(personalInfo_emailField, passwordField, registerButton);
    }

    public String getEmailAutofillText(){
        return this.personalInfo_emailField.getText();
    }

    public void selectGender(){
        if (generateRandomBoolean()) {
            gender_male.click();
        } else gender_female.click();
    }

    public void fillFirstName(){
        setFieldValue(personalInfo_firstName, Utilities.generateRandomAlphabetic());
    }

    public void fillLastName(){
        setFieldValue(personalInfo_lastName, Utilities.generateRandomAlphabetic());
    }

    public void fillPassword(){
        setFieldValue(passwordField, Utilities.generateRandomPassword());
    }

    public void selectBirthDate_day() {
        Select birthDay_dropdown = new Select(this.birthDate_day);
       birthDay_dropdown.selectByIndex(new Random().nextInt(birthDay_dropdown.getOptions().size()));
    }

    public void selectBirthDate_month(){
        Select birthMonth_dropdown = new Select(this.birthDate_month);
        birthMonth_dropdown.selectByIndex(new Random().nextInt(birthMonth_dropdown.getOptions().size()));
    }

    public void selectBirthDate_year(){
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
        setFieldValue(address_company, Utilities.generateRandomAlphabetic());
    }

    public void fillAddress() {
        setFieldValue(address_streetAddress, Utilities.generateRandomAlphabetic());
    }

    public void fillCity() {
        setFieldValue(address_city, Utilities.generateRandomAlphabetic());
    }

    public void selectState_dropdown() {
        Select state_dropdown = new Select(address_state);
        state_dropdown.selectByIndex(generateRandomDropdownSelection(state_dropdown.getOptions().size()));
    }

    public void fillZipCode(){
        setFieldValue(address_postcode, RandomStringUtils.randomNumeric(5));
    }

    public void selectCountry_dropdown() {
        Select country_dropdown = new Select(address_country);
        country_dropdown.selectByIndex(generateRandomDropdownSelection(country_dropdown.getOptions().size()));
    }

    public void fillPhoneNumber(){
        setFieldValue(this.address_mobilePhone, Utilities.generateRandomNumbers());
    }

    public void fillAliasAddress(){
        setFieldValue(this.address_alias, Utilities.generateRandomAlphabetic());
    }

    public void clickRegisterButton(){
        this.registerButton.click();
    }

    public void fillCreateAccountForm(){
        selectGender();
        fillFirstName();
        fillLastName();
        fillPassword();
        selectBirthDate_day();
        selectBirthDate_month();
        selectBirthDate_year();
        fillAddress();
        fillCity();
        selectState_dropdown();
        fillZipCode();
        selectCountry_dropdown();
        fillPhoneNumber();
        fillAliasAddress();
    }

}
