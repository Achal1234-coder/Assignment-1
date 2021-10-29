package org.assignment1.ui.pages;

import org.assignment1.ui.maps.SignInMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SignInPage {

    SignInMap signInMap = new SignInMap();
    Random random = new Random();
    public static WebDriver driver;

    /**
     * Constructor
     * @param driver
     */
    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * This method email in the email field
     * @param email
     */
    public void enterEmailInTextField(String email, int flag){
        if (flag == 0) {
            email = email + String.valueOf(random.nextInt(2000)) + "@gmail.com";
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(signInMap.emailTextField()).click();
        driver.findElement(signInMap.emailTextField()).sendKeys(email);
    }

    /**
     * This method click on Create Account Button in Sign In
     */
    public void clickOnCreateAnAccountButton(){
        driver.findElement(signInMap.createAnAccountButton()).click();
    }

    /**
     * This method enter the first name in the first field
     * @param firstName
     */
    public void enterFirstNameTextFieldInPersonal(String firstName, int flag){
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(signInMap.firstNameTextFieldInPersonal()).click();
            driver.findElement(signInMap.firstNameTextFieldInPersonal()).sendKeys(firstName);
        }
        catch (Exception e){
            if(flag == 0) {
                Assert.fail("Some thing went wrong with email");
            }
            Assert.assertTrue(true,"Already Register Email Id Does not created Account");
        }
    }

    /**
     * This method enter the last name in the last field
     * @param lastName
     */
    public void enterLastNameTextFieldInPersonal(String lastName){
        driver.findElement(signInMap.lastNameTextFieldInPersonal()).click();
        driver.findElement(signInMap.lastNameTextFieldInPersonal()).sendKeys(lastName);
    }

    /**
     * This method enter the password in the password field
     * @param password
     */
    public void enterPasswordTextField(String password){
        driver.findElement(signInMap.passwordTextField()).click();
        driver.findElement(signInMap.passwordTextField()).sendKeys(password);
    }

    /**
     * This method enter the Address in the address field in the address block
     * @param address
     */
    public void enterAddressTextFieldInAddress(String address){
        driver.findElement(signInMap.addressTextFieldInAddress()).click();
        driver.findElement(signInMap.addressTextFieldInAddress()).sendKeys(address);
    }

    /**
     * This method enter the city in the city field
     * @param city
     */
    public void enterCityTextFieldInAddress(String city){
        driver.findElement(signInMap.cityTextFieldInAddress()).click();
        driver.findElement(signInMap.cityTextFieldInAddress()).sendKeys(city);
    }

    /**
     * This method select the State in the State field
     * @param state
     */
    public void selectStateSelectInAddress(String state){
        driver.findElement(signInMap.stateSelectInAddress()).click();
        Select states = new Select(driver.findElement(signInMap.stateSelectInAddress()));
        states.selectByVisibleText(state);
    }

    /**
     * This method enter the zip Code in the zip field
     * @param zipCode
     */
    public void enterZipCodeTextFieldInAddress(String zipCode){
        driver.findElement(signInMap.zipCodeTextFieldInAddress()).click();
        driver.findElement(signInMap.zipCodeTextFieldInAddress()).sendKeys(zipCode);
    }

    /**
     * This method select the country in the Country field
     * @param country
     */
    public void selectCountrySelectInAddress(String country){
        driver.findElement(signInMap.countrySelectInAddress()).click();
        Select countries = new Select(driver.findElement(signInMap.countrySelectInAddress()));
        countries.selectByVisibleText(country);
    }

    /**
     * This method enter the mobile in the mobile field
     * @param mobileNumber
     */
    public void enterMobilePhoneTextFieldInAddress(String mobileNumber){
        driver.findElement(signInMap.mobilePhoneTextFieldInAddress()).click();
        driver.findElement(signInMap.mobilePhoneTextFieldInAddress()).sendKeys(mobileNumber);
    }

    /**
     * This method enter the Address in the Address future field
     * @param addressForFutureReference
     */
    public void enterAssignAnAddressAliasForFutureReferenceTextFieldInAddress(String addressForFutureReference){
        driver.findElement(signInMap.assignAnAddressAliasForFutureReferenceTextFieldInAddress()).click();
        driver.findElement(signInMap.assignAnAddressAliasForFutureReferenceTextFieldInAddress())
                .sendKeys(addressForFutureReference);
    }

    /**
     * This method click on Register Button in Sign Form
     */
    public void clickOnRegisterButton(){
        try {
            driver.findElement(signInMap.registerButton()).click();
        }
        catch (Exception e){
            Assert.fail("Please fill all the mandetory fields");
        }
    }
}
