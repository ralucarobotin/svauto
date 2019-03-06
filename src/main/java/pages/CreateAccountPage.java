package pages;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;
import static helpers.WebElementHelper.inputLetters;
import static helpers.WebElementHelper.inputNumbers;

public class CreateAccountPage extends BasePage {

    //YOUR PERSONAL INFORMATION
    @FindBy(id = "id_gender1")
    private WebElement genderMale;

    @FindBy(id = "id_gender2")
    private WebElement genderFemale;

    @FindBy(css = "#customer_firstname")
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
    private WebElement optIn;

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

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public CreateAccountPage(WebDriver driver){
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(customerFirstName, customerLastName, email, registerButton);
    }

    @Override
    protected boolean isValid() {
        return areVisible(customerFirstName, customerLastName, email, registerButton);
    }

    public WebElement selectGender(){
        boolean addGender = RandomUtils.nextBoolean();
        return addGender ? genderMale : genderFemale;
    }

    public void inputCustomerFirstName(){
        inputLetters(customerFirstName);
    }

    public void inputCustomerLastName(){
        inputLetters(customerLastName);
    }

    public void inputHomePhone(){
        inputNumbers(phone);
    }

}
