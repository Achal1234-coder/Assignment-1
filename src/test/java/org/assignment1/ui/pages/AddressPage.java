package org.assignment1.ui.pages;

import org.assignment1.ui.maps.AddressMap;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AddressPage {

    AddressMap addressMap = new AddressMap();
    public static WebDriver driver;

    /**
     * Constructor
     * @param driver
     */
    public AddressPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * This method click on Proceed to checkout Button in address
     */
    public void clickOnProceedToCheckoutButton(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(addressMap.proceedToCheckoutButton()).click();
    }
}
