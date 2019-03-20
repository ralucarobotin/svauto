package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static helpers.Utilities.getPropertyFromAppProp;
import static testHelpers.Utilities.*;
import static testHelpers.Utilities.generateValidEmailAddress;

public class ShoppingCartTest extends BaseTest {

    private LoginPage loginPage = null;
    private ShoppingCartPage shoppingCartPage = null;
    private MyAccountPage myAccountPage = null;
    private HeaderPage headerPage = null;
    private ProductPage productPage = null;
    private ProductAddedLayoverPage productAddedLayoverPage = null;
    private  CreateAccountPage createAccountPage = null;

    @BeforeMethod
    void beforeMethod(){
        this.loginPage = new LoginPage(getDriver());
        this.shoppingCartPage = new ShoppingCartPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
        this.headerPage = new HeaderPage(getDriver());
        this.productPage = new ProductPage(getDriver());
        this.productAddedLayoverPage = new ProductAddedLayoverPage(getDriver());
        this.createAccountPage = new CreateAccountPage(getDriver());
    }

    @Test
    public void accessShoppingCartPage(){
        this.loginPage.open();
        this.loginPage.verify();
        this.loginPage.login(getPropertyFromAppProp("testEmail"), getPropertyFromAppProp("testPassword"));

        this.myAccountPage.verify();
        this.headerPage.verify();
        this.headerPage.clickShoppingCart();

        this.headerPage.verify();
        this.shoppingCartPage.verify();
    }

    @Test
    public void testEmptyShoppingCartMessageNotLoggedIn(){
        this.shoppingCartPage.open();
        this.shoppingCartPage.verify();

        Assert.assertEquals(this.shoppingCartPage.getShoppingCartEmptyWarning(), "Your shopping cart is empty.");
    }

    @Test
    public void testEmptyShoppingCartMessageLoggedIn(){
        this.loginPage.open();
        this.loginPage.login(getPropertyFromAppProp("testEmail"), getPropertyFromAppProp("testPassword"));
        this.myAccountPage.verify();

        this.shoppingCartPage.open();
        this.shoppingCartPage.verify();

        Assert.assertEquals(this.shoppingCartPage.getShoppingCartEmptyWarning(), "Your shopping cart is empty.");
    }

    @Test
    public void testOneProductAddedToShoppingCartNotLoggedIn(){
        this.productPage.open();
        this.productPage.verify();
        this.productPage.addProductToCart();
        this.productAddedLayoverPage.verify();
        this.productAddedLayoverPage.continueToCheckout();
        this.shoppingCartPage.verify();

        Assert.assertEquals(this.shoppingCartPage.getShoppingCartProductCounterText(), "Your shopping cart contains: 1 Product");
    }

    @Test
    public void testShoppingCartIntegrityAfterLogOutLogIn(){
        Account account = new Account.Builder()
                .gender(generateRandomGender())
                .firstName(generateRandomString(10))
                .lastName(generateRandomString(8))
                .password(generateRandomString(10))
                .homePhone(generateRandomPhoneNumber())
                .mobilePhone(generateRandomPhoneNumber())
                .address1(generateRandomString(50))
                .city(generateRandomString(6))
                .zip(generateRandomZipCode())
                .state(generateRandomState())
                .yearOfBirth(generateRandomYear())
                .monthOfBirth(generateRandomMonth())
                .dayOfBirth(generateRandomDay())
                .build();

        this.loginPage.open();
        this.loginPage.verify();

        String randomEmail = generateValidEmailAddress();

        this.loginPage.submitEmailAccountCreation(randomEmail);
        this.createAccountPage.verify();

        this.createAccountPage.fillGenderField(account.getGender());
        this.createAccountPage.fillFirstNameField(account.getFirstName());
        this.createAccountPage.fillLastNameField(account.getLastName());
        this.createAccountPage.fillPasswordField(account.getPassword());
        this.createAccountPage.fillHomePhoneField(account.getHomePhone());
        this.createAccountPage.fillMobilePhoneField(account.getMobilePhone());
        this.createAccountPage.fillAddress1Field(account.getAddress1Address());
        this.createAccountPage.fillCityField(account.getCityAddress());
        this.createAccountPage.fillZipCodeField(account.getZipAddress());
        this.createAccountPage.fillStateField(account.getStateOptionAddress());
        this.createAccountPage.fillDayOfBirthField(account.getDayOfBirth());
        this.createAccountPage.fillYearsOfBirthField(account.getYearOfBirth());
        this.createAccountPage.fillMonthsOfBirthField(account.getMonthOfBirth());
        this.createAccountPage.register();
        this.myAccountPage.verify();

        this.productPage.open();
        this.productPage.verify();
        this.productPage.addProductToCart();
        this.productAddedLayoverPage.verify();
        this.productAddedLayoverPage.continueToCheckout();
        Assert.assertEquals(this.shoppingCartPage.getShoppingCartProductCounterText(), "Your shopping cart contains: 1 Product");

        this.headerPage.clickLogoutButton();
        this.headerPage.clickShoppingCart();
        this.shoppingCartPage.verify();
        Assert.assertEquals(this.shoppingCartPage.getShoppingCartEmptyWarning(), "Your shopping cart is empty.");


        this.loginPage.open();
        this.loginPage.login(randomEmail, account.getPassword());
        this.myAccountPage.verify();
        this.headerPage.clickShoppingCart();
        this.shoppingCartPage.verify();
        Assert.assertEquals(this.shoppingCartPage.getShoppingCartProductCounterText(), "Your shopping cart contains: 1 Product");
    }

}
