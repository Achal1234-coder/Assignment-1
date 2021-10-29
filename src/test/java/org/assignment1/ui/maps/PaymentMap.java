package org.assignment1.ui.maps;

import org.openqa.selenium.By;

public class PaymentMap {

    /**
     * This method return the locator of Pay Bank By wire button
     * @return
     */
    public By payBankByWireButton(){
        return By.cssSelector(".bankwire");
    }

    /**
     * This method return the locator of confirm my Order Button
     * @return
     */
    public By confirmMyOrderButton(){
        return By.cssSelector(".cart_navigation > button");
    }

    /**
     * This method return the locator of order Confirmation tag
     * @return
     */
    public By orderConfirmation(){
        return By.cssSelector(".navigation_page");
    }
}
