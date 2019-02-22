package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static helpers.WebElementHelper.areVisible;

public class NewAccountPage extends BasePage{

    private ArrayList<WebElement> elementsList = new ArrayList<WebElement>();

    @FindBy(id = "email_create")
    private WebElement createEmailField;

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

    @FindBy (id = "firstname")
    private WebElement address_firstName;

    @FindBy (id = "lastname")
    private WebElement address_lastName;

    @FindBy (id = "company")
    private WebElement address_company;

    @FindBy (id = "address1")
    private WebElement address_address1;

    @FindBy (id = "city")
    private WebElement address_city;

    @FindBy (id = "id_state")
    private WebElement address_state;

    @FindBy (id = "postcode")
    private WebElement address_postcode;

    @FindBy (id = "id_country")
    private WebElement address_country;

    @FindBy (id = "phone")
    private WebElement address_phone;

    @FindBy (id = "alias")
    private WebElement address_alias;

    @FindBy (id = "submitAccount")
    private WebElement registerButton;

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {return areVisible(registerButton);
        }

    @Override
    protected boolean isValid() {
        return areVisible(createEmailField, gender_male, gender_female, personalInfo_firstName, personalInfo_lastName, personalInfo_emailField,  passwordField, birthDate_day, birthDate_month, registerButton);
    }
}
