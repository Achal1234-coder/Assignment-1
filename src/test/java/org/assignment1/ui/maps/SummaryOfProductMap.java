package org.assignment1.ui.maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SummaryOfProductMap {

    /**
     * This method return the locator of summary of cart table in Summary page
     * @return
     */
    public By summaryOfCartTable(){
        return By.cssSelector("tbody .product-name > a");
    }

    /**
     * This method return the all the product in summary table as string
     * @param driver
     * @return
     */
    public List<String> listOfSummaryOfCartTable(WebDriver driver){
        List<String> listOfSummaryTable = new ArrayList<>();
        List<WebElement> webElements = driver.findElements(summaryOfCartTable());
        for(WebElement element: webElements){
            listOfSummaryTable.add(element.getText());
        }
        return listOfSummaryTable;
    }

    /**
     * This method return the locator of proceed to payment Button
     * @return
     */
    public By proceedToPaymentButton(){
        return By.cssSelector(".cart_navigation [title='Proceed to checkout']");
    }
}
