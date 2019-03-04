package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class CreateAnAccount extends BasePage {

    //YOUR PERSONAL INFORMATION
    @FindBy(id = "id_gender1")
    private WebElement genderMale;

    @FindBy(id = "id_gender2")
    private WebElement genderFemale;

    @FindBy(id = "customer_firstname")
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
    private WebElement optin;

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

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public CreateAnAccount(WebDriver driver){
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(genderMale);
    }

    @Override
    protected boolean isValid() {
        return areVisible(genderMale);
    }

}
