package uiPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.*;

public class CheckoutPage extends BasePage {

    @FindBy(css = "#billing_first_name")
    protected WebElement firstNameCheckoutField;

    @FindBy(css = "#billing_last_name")
    protected WebElement lastNameCheckoutField;

    @FindBy(css = "#billing_address_1")
    protected WebElement billingAddressCheckoutField;

    @FindBy(css = "#billing_city")
    protected WebElement cityCheckoutField;

    @FindBy(css = "#select2-billing_state-container")
    protected WebElement countyCheckoutField;

    @FindBy(css = "#billing_postcode")
    protected WebElement postcodeCheckoutField;

    @FindBy(css = "#billing_phone")
    protected WebElement phoneCheckoutField;

    @FindBy(css = "#terms")
    protected WebElement termsCheckoutCheckBox;

    @FindBy(css = "#place_order")
    protected WebElement placeOrder;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        super.isCurrent();
        return areVisible(firstNameCheckoutField, lastNameCheckoutField, billingAddressCheckoutField,
                cityCheckoutField, countyCheckoutField, postcodeCheckoutField, phoneCheckoutField,
                termsCheckoutCheckBox);
    }

    @Override
    protected boolean isValid() {
        super.isValid();
        return areVisible(firstNameCheckoutField, lastNameCheckoutField, billingAddressCheckoutField,
                cityCheckoutField, countyCheckoutField, postcodeCheckoutField, phoneCheckoutField,
                termsCheckoutCheckBox);
    }

    public void fillInFirstName(String firstName){
        setFieldValue(firstNameCheckoutField, firstName);
    }

    public void fillInLastName(String lastName){
        setFieldValue(lastNameCheckoutField, lastName);
    }

    public void fillInBillingAddress(String billingAddress){
        setFieldValue(billingAddressCheckoutField, billingAddress);
    }

    public void fillInCity(String city){
        setFieldValue(cityCheckoutField, city);
    }

//    public void fillInCounty(String county){
//        countyCheckoutField.getAttribute(county);
//    }

    public void fillInPostcode(String postcode){
        setFieldValue(postcodeCheckoutField, postcode);
    }
    public void fillInPhone(String phone){
        setFieldValue(phoneCheckoutField, phone);
    }

    public void checkInTerms(){
        termsCheckoutCheckBox.click();
    }

    public void placeOrder() {
        placeOrder.click();
    }






}
