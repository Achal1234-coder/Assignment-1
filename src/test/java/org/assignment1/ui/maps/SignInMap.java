package org.assignment1.ui.maps;

import org.openqa.selenium.By;

public class SignInMap {

    /**
     * This method return the locator of email text field
     * @return
     */
    public By emailTextField(){
        return By.cssSelector("#email_create");
    }

    /**
     * This method return the locator of create Account Button
     * @return
     */
    public By createAnAccountButton(){
        return By.cssSelector("#SubmitCreate");
    }

    /**
     * This method return the locator of email error message
     * @return
     */
    public By emailErrorMessage(){
        return By.cssSelector("#create_account_error");
    }

    /**
     * This method return the locator of first name text field in personal block
     * @return
     */
    public By firstNameTextFieldInPersonal(){
        return By.cssSelector("#customer_firstname");
    }

    /**
     * This method return the locator of last name text field in personal block
     * @return
     */
    public By lastNameTextFieldInPersonal(){
        return By.cssSelector("#customer_lastname");
    }

    /**
     * This method return the locator of password text field in personal block
     * @return
     */
    public By passwordTextField(){
        return By.cssSelector("#passwd");
    }

    /**
     * This method return the locator of address field in address block
     * @return
     */
    public By addressTextFieldInAddress(){
        return By.cssSelector("#address1");
    }

    /**
     * This method return the locator of city test field in address block
     * @return
     */
    public By cityTextFieldInAddress(){
        return By.cssSelector("#city");
    }

    /**
     * This method return the locator of state select field in address block
     * @return
     */
    public By stateSelectInAddress(){
        return By.cssSelector("#id_state");
    }

    /**
     * This method return the locator of zip text field in address block
     * @return
     */
    public By zipCodeTextFieldInAddress(){
        return By.cssSelector("#postcode");
    }

    /**
     * This method return the locator of country text field in address block
     * @return
     */
    public By countrySelectInAddress(){
        return By.cssSelector("#id_country");
    }

    /**
     * This method return the locator mobile text field in address block
     * @return
     */
    public By mobilePhoneTextFieldInAddress(){
        return By.cssSelector("#phone_mobile");
    }

    /**
     * This method return the locator of address for future reference in address block
     */
    public By assignAnAddressAliasForFutureReferenceTextFieldInAddress(){
        return By.cssSelector("#alias");
    }

    /**
     * This method return the locator of register Button
     * @return
     */
    public By registerButton(){
        return By.cssSelector("#submitAccount");
    }
}
