package org.assignment1.ui.pages;

import org.assignment1.ui.maps.ShippingMap;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ShippingPage {

    ShippingMap shippingMap = new ShippingMap();
    public static WebDriver driver;

    /**
     * Constructor
     * @param driver
     */
    public ShippingPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * This method click on Check Box of Term Of Services in Shipping
     */
    public void clickOnCheckboxTermOfService(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(shippingMap.checkboxTermOfService()).click();
    }

    /**
     * This method click on Proceed To checkout Button in Shipping
     */
    public void clickOnProceedToCheckoutButton(){
        driver.findElement(shippingMap.proceedToCheckoutButton()).click();
    }
}
