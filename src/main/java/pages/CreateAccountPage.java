package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement pageHeader;

    @FindBy(xpath = "//h3[contains(text(),'Your personal information')]")
    private WebElement formHeader;

    @FindBy(id = "uniform-id_gender1")
    private WebElement genderMaleOption;

    @FindBy(id = "uniform-id_gender2")
    private WebElement genderFemaleOption;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailFiled;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "uniform-days")
    private WebElement daysField;

    @FindBy(id = "uniform-months")
    private WebElement monthsField;

    @FindBy(id = "uniform-years")
    private WebElement yearsField;

    @FindBy(id = "uniform-newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "uniform-optin")
    private WebElement offersCheckbox;

    @FindBy(id = "firstname")
    private WebElement firstNameAddressField;

    @FindBy(id = "lastname")
    private WebElement lastNameAddressField;

    @FindBy(id = "company")
    private WebElement companyAddressField;

    @FindBy(id = "address1")
    private WebElement address1AddressField;

    @FindBy(id = "address2")
    private WebElement address2AddressField;

    @FindBy(id = "city")
    private WebElement cityAddressField;

    @FindBy(id = "uniform-id_state")
    private WebElement stateAddressField;

    @FindBy(id = "postcode")
    private WebElement postcodeAddressField;

    @FindBy(id = "uniform-id_country")
    private WebElement countryAddressField;

    @FindBy(id = "other")
    private WebElement otherField;

    @FindBy(id = "phone")
    private WebElement homePhoneField;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;

    @FindBy(id = "alias")
    private WebElement aliasField;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    protected boolean isCurrent() {
        return areVisible(pageHeader);


    }

    protected boolean isValid() {
        waitForElementToAppear(firstNameField);
        waitForElementToAppear(postcodeAddressField);
        return areVisible(pageHeader, registerButton, mobilePhoneField, homePhoneField, otherField,countryAddressField, postcodeAddressField, stateAddressField, cityAddressField, address1AddressField,
                address2AddressField, companyAddressField, lastNameAddressField, firstNameAddressField, offersCheckbox,
                newsletterCheckbox, yearsField, monthsField, daysField, passwordField, emailFiled, lastNameField,
                firstNameField, genderFemaleOption, genderMaleOption, formHeader,aliasField );
    }
}
