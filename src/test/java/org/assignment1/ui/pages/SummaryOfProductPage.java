package org.assignment1.ui.pages;

import org.assignment1.ui.maps.SummaryOfProductMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SummaryOfProductPage {

    SummaryOfProductMap summaryOfProductMap = new SummaryOfProductMap();
    public static WebDriver driver;

    /**
     * Constructor
     * @param driver
     */
    public SummaryOfProductPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * This method assert that at least one dress is present
     */
    public void assertAtLeastOneDress(){
        int flag = 0;
        for(String dress: summaryOfProductMap.listOfSummaryOfCartTable(driver)){
            if (dress.contains("Dress")){
                flag = 1;
            }
            System.out.println(dress);
            System.out.println(dress.contains("Dress"));
        }
        if(flag == 1){
            assertValues(true);
        }
        else{
            assertValues(false);
        }
    }

    /**
     * This method assert value
     * @param value
     */
    public void assertValues(Boolean value){
        Assert.assertTrue(value);
    }

    /**
     * This method click on Proceed to Payment Button in Summary
     */
    public void clickOnProceedToPaymentButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(summaryOfProductMap.proceedToPaymentButton()).click();
    }
}
