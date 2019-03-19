package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static helpers.WebElementHelper.*;

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

    @FindBy(css = "#center_column div ol")
    private WebElement errorMessageCreateAccount;

    public CreateAccountPage(WebDriver driver) {
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

    public void inputGender(boolean text) {
        if (!text) {
            genderMale.click();
        } else {
            genderFemale.click();
        }
    }

    public void inputCustomerFirstName(String text) {
        setFieldValue(customerFirstName, text);
    }

    public void inputCustomerLastName(String text) {
        setFieldValue(customerLastName, text);
    }

    public void inputEmail(String text) {
        if (driver.getPageSource().contains(email.getText())) {
            System.out.println("Email already set!");
        } else {
            setFieldValue(email, text);
        }
    }

    public void inputPassword(String text) {
        setFieldValue(password, text);
    }

    public void inputDays() {
        Select days = new Select(driver.findElement(By.id("days")));
        days.selectByIndex(new Random().nextInt(days.getOptions().size() - 1) + 1);
    }

    public void inputMonths() {
        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByIndex(new Random().nextInt(month.getOptions().size() - 1) + 1);
    }

    public void inputYears() {
        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByIndex(new Random().nextInt(year.getOptions().size() - 1) + 1);
    }

    public void validateDate(){
        Select days = new Select(driver.findElement(By.id("days")));
        Select month = new Select(driver.findElement(By.id("months")));
//        Select year = new Select(driver.findElement(By.id("years")));
        if(month.getOptions().get(2).isSelected() && days.getOptions().get(31).isSelected() || days.getOptions().get(30).isSelected() || days.getOptions().get(29).isSelected()){
            days.selectByIndex(new Random().nextInt(days.getOptions().size() - 1) + 1);
        } else if (month.getOptions().get(4).isSelected() && days.getOptions().get(31).isSelected()) {
            days.selectByIndex(new Random().nextInt(days.getOptions().size() - 1) + 1);
        } else if (month.getOptions().get(6).isSelected() && days.getOptions().get(31).isSelected()){
            days.selectByIndex(new Random().nextInt(days.getOptions().size() - 1) + 1);
        } else if (month.getOptions().get(9).isSelected() && days.getOptions().get(31).isSelected()){
            days.selectByIndex(new Random().nextInt(days.getOptions().size() - 1) + 1);
        } else if (month.getOptions().get(11).isSelected() && days.getOptions().get(31).isSelected()) {
            days.selectByIndex(new Random().nextInt(days.getOptions().size() - 1) + 1);
        }
    }

    public void inputNewsLetter() {
        newsletter.click();
    }

    public void inputOptIn() {
        optIn.click();
    }

    public void inputFirstName(String text) {
        if (driver.getPageSource().matches(customerFirstName.getText())) {
            System.out.println("FirstName already set!");
        } else {
            setFieldValue(firstName, text);
        }
    }

    public void inputLastName(String text) {
        if (driver.getPageSource().matches(customerLastName.getText())) {
            System.out.println("LastName already set!");
        } else {
            setFieldValue(lastName, text);
        }
    }

    public void inputCompany(String text) {
        setFieldValue(company, text);
    }

    public void inputFirstAddress(String text) {
        setFieldValue(firstAddress, text);
    }

    public void inputSecondAddress(String text) {
        setFieldValue(secondAddress, text);
    }

    public void inputCity(String text) {
        setFieldValue(city, text);
    }

    public void inputState() {
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByIndex(new Random().nextInt(state.getOptions().size() - 1) + 1);
    }

    public void inputPostCode(String text) {
        setFieldValue(postcode, text);
    }

    public void inputCountry() {
        Select country = new Select(driver.findElement(By.id("id_country")));
        country.selectByIndex(new Random().nextInt(country.getOptions().size() - 1) + 1);
    }

    public void inputOtherInfo(String text) {
        setFieldValue(otherInfo, text);
    }

    public void inputPhone(String text) {
        setFieldValue(phone, text);
    }

    public void inputMobilePhone(String text) {
        setFieldValue(mobilePhone, text);
    }

    public void inputAlias(String text) {
        setFieldValue(alias, text);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public boolean getCreateAccountErrorMessage() {
        return errorMessageCreateAccount.isDisplayed();
    }

    public String getStringsCreateAccountErrorMessage() {
        return errorMessageCreateAccount.getText();
    }

    public void clearCountry() {
        Select country = new Select(driver.findElement(By.id("id_country")));
        country.selectByIndex(0);
    }

    public void clearEmail() {
        email.clear();
    }
}