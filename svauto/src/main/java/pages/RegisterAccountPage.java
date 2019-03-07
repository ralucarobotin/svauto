package pages;

import helpers.WebElementHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static helpers.Utilities.getPropertyFromAppProp;
import static helpers.WebElementHelper.*;

public class RegisterAccountPage extends BasePage {

    @FindBy(id = "page")
    private WebElement pageForm;

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement pageHeadingRegistration;

    @FindBy(id = "submitAccount")
    private WebElement registerAccountButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement registerAccountError;

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

    @FindBy(id = "uniform-newsletter")
    private WebElement newsletterCheckBox;

    @FindBy(id = "uniform-optin")
    private WebElement specialOfersCheckBox;

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

    public RegisterAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(pageHeadingRegistration, pageForm, registerAccountButton);
    }

    @Override
    protected boolean isValid() {
        return areVisible(customerFirstNameField, customerLastNameField, emailField, passField, firstNameField,
                lastNameField, companyField, address1Field, cityField, additionalInfoField,
                phoneField, mobilePhoneField, aliasField);
//              address2Field - site bug - not visible when error is received
//              postalCodeField
    }

    private void addPersonalInfo() {
        genderSelect();
        fillInCustomerFirstName();
        fillInCustomerLastName();
        fillInPassword();
        daySelect();
        monthSelect();
        yearSelect();
        optionsSelect();
    }

    private void addAddressInfo() {
        fillInFirstName();
        fillInLastName();
        fillInCompany();
        fillInAddress1();
        fillInAddress2();
        fillInCity();
        stateSelect();
        fillInPostalCode();
        countrySelect();
    }

    private void addOtherInfo() {
        fillInAdditionalInfo();
        fillInPhone();
        fillInMobilePhone();
        fillInAlias();
    }

    public void registerRandomData() {
        addPersonalInfo();
        addAddressInfo();
        addOtherInfo();
        clickRegisterButton();
    }

    public void registerEmptyData() {
        clickRegisterButton();
    }

    private void genderSelect() {
        List <WebElement> genderValue = driver.findElements(By.className("radio-inline"));
        Random gender = new Random();
        int randomValue = gender.nextInt(genderValue.size());
        genderValue.get(randomValue).click();
        System.out.println(genderValue);
    }

    private void fillInCustomerFirstName() {
        setFieldValue(customerFirstNameField, generateRandomString());
    }

    private void fillInCustomerLastName() {
        setFieldValue(customerLastNameField, generateRandomString());
    }

    private void fillInPassword() {
        setFieldValue(passField, generateRandomPassword());
    }

    // - https://seleniumsubbu.blogspot.com/2016/09/how-to-select-random-dropdown-value.html
    private void daySelect() {
        List<WebElement> dayValue = new Select(daySet).getOptions();
        ArrayList<String> options = new ArrayList<String>();

        for (WebElement webElement : dayValue) {
            String optionValue = webElement.getText();
            if(!optionValue.equals("-")){options.add(optionValue);}
        }
        Random randomValue = new Random();
        int randomNumber = randomValue.nextInt(options.size());
        String randomDay = options.get(randomNumber);

        daySet.sendKeys(randomDay);
    }

    private void monthSelect() {
        List<WebElement> monthValue = new Select(monthSet).getOptions();
        ArrayList<String> options = new ArrayList<String>();

        for (WebElement webElement : monthValue) {
            String optionValue = webElement.getText();
            if(!optionValue.equals("-")){options.add(optionValue);}
        }
        Random randomValue = new Random();
        int randomNumber = randomValue.nextInt(options.size());
        String randomMonth = options.get(randomNumber);

        monthSet.sendKeys(randomMonth);
    }

    private void yearSelect() {
        List<WebElement> yearValue = new Select(yearSet).getOptions();
        ArrayList<String> options = new ArrayList<String>();

        for (WebElement webElement : yearValue) {
            String optionValue = webElement.getText();
            if(!optionValue.equals("-")){options.add(optionValue);}
        }
        Random randomValue = new Random();
        int randomNumber = randomValue.nextInt(options.size());
        String randomYear = options.get(randomNumber);

        yearSet.sendKeys(randomYear);
    }

    private void optionsSelect() {
        List <WebElement> optionValue = driver.findElements(By.className("checker"));
        Random option = new Random();
        int randomValue = option.nextInt(optionValue.size());
        optionValue.get(randomValue).click();
    }

    private void fillInFirstName() {
        setFieldValue(firstNameField, generateRandomString());
    }

    private void fillInLastName() {
        setFieldValue(lastNameField, generateRandomString());
    }

    private void fillInCompany() {
        setFieldValue(companyField, generateRandomString());
    }

    private void fillInAddress1() {
        setFieldValue(address1Field, generateRandomString());
    }

    private void fillInAddress2() {
        setFieldValue(address2Field, generateRandomString());
    }

    private void fillInCity() {
        setFieldValue(cityField, generateRandomString());
    }

    private void stateSelect() {
        List<WebElement> stateValue = new Select(stateSelect).getOptions();
        ArrayList<String> options = new ArrayList<String>();

        for (WebElement webElement : stateValue) {
            String optionValue = webElement.getText();
            if(!optionValue.equals("-")){options.add(optionValue);}
        }
        Random randomValue = new Random();
        int randomNumber = randomValue.nextInt(options.size());
        String randomState = options.get(randomNumber);

        stateSelect.sendKeys(randomState);
    }

    private void fillInPostalCode() {
        setFieldValue(postalCodeField, generateRandomPostalCode());
    }

//    private void countrySelect(String value) {
//        Select drop = new Select(countrySelect);
//        drop.selectByVisibleText(value);
//    }

    private void countrySelect() {
        List<WebElement> countryValue = new Select(countrySelect).getOptions();
        ArrayList<String> options = new ArrayList<String>();

        for (WebElement webElement : countryValue) {
            String optionValue = webElement.getText();
            if(!optionValue.equals("-")){options.add(optionValue);}
        }
        Random randomValue = new Random();
        int randomNumber = randomValue.nextInt(options.size());
        String randomCountry = options.get(randomNumber);

        stateSelect.sendKeys(randomCountry);
    }

    private void fillInAdditionalInfo() {
        setFieldValue(additionalInfoField, generateRandomString());
    }

    private void fillInPhone() {
        setFieldValue(phoneField, generateRandomNumber());
    }

    private void fillInMobilePhone() {
        setFieldValue(mobilePhoneField, generateRandomNumber());
    }

    private void fillInAlias() {
        setFieldValue(aliasField, generateRandomString());
    }

    private void clickRegisterButton() {
        registerAccountButton.click();
    }

    public boolean getPageHeadingRegistration() {
        return areVisible(pageHeadingRegistration);
    }

    public boolean getRegisterAccountError() {
        waitForElementToAppear(registerAccountError);
        return areVisible(registerAccountError);
    }

    public String getRegisterAccountErrorMsg() {
        return registerAccountError.getText();
    }
}



