package org.assignment1.ui.maps;

import org.openqa.selenium.By;

public class ShippingMap {

    /**
     * This method return the locator of check Box of Term Of service
     * @return
     */
    public By checkboxTermOfService(){
        return By.cssSelector("#cgv");
    }

    /**
     * This method return the locator of Proceed to checkout Button
     * @return
     */
    public By proceedToCheckoutButton(){
        return By.cssSelector("[name='processCarrier']");
    }
}
