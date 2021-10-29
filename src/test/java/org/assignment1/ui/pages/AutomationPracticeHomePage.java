package org.assignment1.ui.pages;


import org.assignment1.ui.maps.AutomationPracticeHomeMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AutomationPracticeHomePage {

    AutomationPracticeHomeMap automationPracticeHomeMap = new AutomationPracticeHomeMap();
    public static WebDriver driver;

    /**
     * Constructor
     * @param driver
     */
    public AutomationPracticeHomePage(WebDriver driver){
        this.driver = driver;

    }

    /**
     * This method click on Dress Navbar
     */
    public void clickOnDressNavbar(){
        driver.findElement(automationPracticeHomeMap.dressNavbarBlock()).click();
    }

    /**
     * This method click on Add cart of Dress Button
     */
    public void clickOnAddCartDressButton(String clothId){
        System.out.println(clothId);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(automationPracticeHomeMap.imageOfDress1())).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(automationPracticeHomeMap.addCartButton(clothId)).click();
    }

    /**
     * This method click on Continue Purchasing Button. This Button come in pop up when we click on Add cart
     */
    public void clickOnContinuePurchasingButton(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(automationPracticeHomeMap.continuePurchasingButton()).click();
    }

    /**
     * This method click on T-Shirt which come on Navbar
     */
    public void clickOnTShirtNavbar(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(automationPracticeHomeMap.tShirtNavbarBlock()).click();
    }

    /**
     * This method click on Proceed to checkout button that come in pop when we do Add cart
     */
    public void clickOnProceedToCheckoutButton(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(automationPracticeHomeMap.proceedToCheckOutButton()).click();
    }

    /**
     * This method click on Add
     */
    public void clickOnAddCartTShirtButton(String clothId){
        System.out.println(clothId);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(automationPracticeHomeMap.imageOftShirt1())).perform();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(automationPracticeHomeMap.addCartButton(clothId)).click();
    }
}
