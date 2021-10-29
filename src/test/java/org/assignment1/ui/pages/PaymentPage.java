package org.assignment1.ui.pages;

import org.assignment1.ui.maps.PaymentMap;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class PaymentPage {

    PaymentMap paymentMap = new PaymentMap();
    public static WebDriver driver;

    /**
     * Constructor
     * @param driver
     */
    public PaymentPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * This method click on pay bank by Wire block in payment
     */
    public void clickOnPayBankByWire(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(paymentMap.payBankByWireButton()).click();
    }

    /**
     * This method click on Confirm My Order Button in payment
     */
    public void clickOnConfirmMyOrderButton(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(paymentMap.confirmMyOrderButton()).click();
    }

    /**
     * This method assert the order Confirmation
     */
    public void assertOrderConfirmation(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String orderConfirmation = driver.findElement(paymentMap.orderConfirmation()).getText();
        assertValue(orderConfirmation);
    }

    /**
     * This method assert the value
     * @param value
     */
    public void assertValue(String value){
        Assert.assertEquals(value,"Order confirmation");
    }
}
