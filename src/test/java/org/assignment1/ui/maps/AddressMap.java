package org.assignment1.ui.maps;

import org.openqa.selenium.By;

public class AddressMap {
    /**
     * this method Return the locator of proceed to checkout button
     * @return
     */
    public By proceedToCheckoutButton(){
        return By.cssSelector("[name='processAddress']");
    }
}
