package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccount {

    @FindBy(id = "id_gender1")
    private WebElement genderMale;

    @FindBy(id = "id_gender2")
    private WebElement genderFemale;

    @FindBy(id = "customer_firstname")
    private WebElement userFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement userLastName;

    @FindBy(id = "email")
    private WebElement userEmail;

    @FindBy(id = "passwd")
    private WebElement userPassword;

    @FindBy(id = "days")
    private WebElement userDayOfBirth;

}
