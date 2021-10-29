package org.assignment1.ui.maps;

import org.openqa.selenium.By;


public class AutomationPracticeHomeMap {

    /**
     * This method return the locator of dress Navbar
     * @return
     */
    public By dressNavbarBlock(){
        return By.cssSelector("#block_top_menu>ul>li:nth-child(2)>a");
    }

    /**
     * This method return the locator of the Dress
     * @return
     */
    public By imageOfDress1(){
        return By.cssSelector(".first-in-line.first-item-of-tablet-line img");
    }

    /**
     * This method return the locator of continue purchasing Button
     * @return
     */
    public By continuePurchasingButton(){
        return By.cssSelector("[title='Continue shopping']");
    }

    /**
     * This method return the locator of image of t shirt button
     * @return
     */
    public By imageOftShirt1(){
        return By.cssSelector(".product_img_link [title='Faded Short Sleeve T-shirts']");
    }

    /**
     * This method return the locator of t shirt Navbar block
     * @return
     */
    public By tShirtNavbarBlock(){
        return By.cssSelector("#block_top_menu>ul>li:nth-child(3)>a");
    }

    /**
     * This method return the locator of Add cart button according to the cloth ID
     * @param clothId
     * @return
     */
    public By addCartButton(String clothId){
        String locator = String.format(".button-container [data-id-product='%s']",clothId);
        return By.cssSelector(locator);
    }

    /**
     * This method click on the proceed to checkout Button
     * @return
     */
    public By proceedToCheckOutButton(){
        return By.cssSelector("[title='Proceed to checkout']");
    }
}
