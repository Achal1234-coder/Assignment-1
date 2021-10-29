package org.assignment1.cases;



import org.assignment1.ui.pages.*;
import org.assignment1.ui.support.ReadPropertiesFileData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.util.concurrent.TimeUnit;

public class SuccessfullyCheckoutOrderPlacedTest {

    WebDriver driver;

    AutomationPracticeHomePage automationPracticeHomePage;
    SummaryOfProductPage summaryOfProductPage;
    SignInPage signInPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;

    ReadPropertiesFileData readPropertiesFileData = new ReadPropertiesFileData();
    Properties properties = readPropertiesFileData.fileData();
    String clothId1 = properties.getProperty("clothId1");
    String clothId3 = properties.getProperty("clothId3");
    String nameOfEmailHolder = properties.getProperty("nameOfEmailHolder");
    String alreadyRegisterEmailId = properties.getProperty("alreadyRegisterEmailId");
    String wrongEmailId = properties.getProperty("wrongEmailId");


    public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();

    @BeforeMethod
    public void setUpEnv(){
        try {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(readPropertiesFileData.fileData().getProperty("testWebsiteUrl"));
        }
        catch (Exception e){
            e.printStackTrace();
            driver.quit();
        }
        automationPracticeHomePage = new AutomationPracticeHomePage(driver);
        summaryOfProductPage = new SummaryOfProductPage(driver);
        signInPage = new SignInPage(driver);
        addressPage = new AddressPage(driver);
        shippingPage = new ShippingPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    @AfterMethod
    public void closeWebDriver(){
        driver.quit();
    }

    @DataProvider(name = "signInData")
    public Object[][] signInData() throws IOException {
        File file = new File(properties.getProperty("signInDataExcel"));
        FileInputStream fileInputStream= new FileInputStream(file);
        workbook = new XSSFWorkbook(fileInputStream);
        worksheet=workbook.getSheet("Sheet1");
        XSSFRow Row=worksheet.getRow(0);
        int RowNum = worksheet.getPhysicalNumberOfRows();
        int ColNum= Row.getLastCellNum();
        Object Data[][]= new Object[RowNum-1][ColNum];

        for(int i=0; i<RowNum-1; i++){
            XSSFRow row= worksheet.getRow(i+1);
            for (int j=0; j<ColNum; j++){
                if (row == null){
                    Data[i][j]= "";
                }
                else {
                    XSSFCell cell= row.getCell(j);
                    if(cell == null){
                        Data[i][j]= "";
                    }
                    else {
                        String value=formatter.formatCellValue(cell);
                        Data[i][j]=value;
                    }
                }
            }
        }
        return Data;
    }

    @Test(dataProvider = "signInData")
    public void verifySuccessfullyChecoutOrderPlacedTest(String firstName, String lastName, String password,
                                               String address, String city, String state, String zipCode,
                                               String country, String mobileNumber, String addressForFutureReference){

        automationPracticeHomePage.clickOnDressNavbar();
        automationPracticeHomePage.clickOnAddCartDressButton(clothId3);
        automationPracticeHomePage.clickOnContinuePurchasingButton();
        automationPracticeHomePage.clickOnTShirtNavbar();
        automationPracticeHomePage.clickOnAddCartTShirtButton(clothId1);
        automationPracticeHomePage.clickOnProceedToCheckoutButton();

        summaryOfProductPage.clickOnProceedToPaymentButton();

        signInPage.enterEmailInTextField(nameOfEmailHolder, 0);
        signInPage.clickOnCreateAnAccountButton();
        signInPage.enterFirstNameTextFieldInPersonal(firstName, 0);
        signInPage.enterLastNameTextFieldInPersonal(lastName);
        signInPage.enterPasswordTextField(password);
        signInPage.enterAddressTextFieldInAddress(address);
        signInPage.enterCityTextFieldInAddress(city);
        signInPage.selectStateSelectInAddress(state);
        signInPage.enterZipCodeTextFieldInAddress(zipCode);
        signInPage.selectCountrySelectInAddress(country);
        signInPage.enterMobilePhoneTextFieldInAddress(mobileNumber);
        signInPage.enterAssignAnAddressAliasForFutureReferenceTextFieldInAddress(addressForFutureReference);
        signInPage.clickOnRegisterButton();

        addressPage.clickOnProceedToCheckoutButton();
        shippingPage.clickOnCheckboxTermOfService();

        shippingPage.clickOnProceedToCheckoutButton();

        paymentPage.clickOnPayBankByWire();
        paymentPage.clickOnConfirmMyOrderButton();
        paymentPage.assertOrderConfirmation();
    }

    @Test
    public void verifyAlreadyRegisterAccountDoesNotCreateNewAccount(){
        automationPracticeHomePage.clickOnDressNavbar();
        automationPracticeHomePage.clickOnAddCartDressButton(clothId3);
        automationPracticeHomePage.clickOnContinuePurchasingButton();
        automationPracticeHomePage.clickOnTShirtNavbar();
        automationPracticeHomePage.clickOnAddCartTShirtButton(clothId1);
        automationPracticeHomePage.clickOnProceedToCheckoutButton();

        summaryOfProductPage.clickOnProceedToPaymentButton();

        signInPage.enterEmailInTextField(alreadyRegisterEmailId, 1);
        signInPage.clickOnCreateAnAccountButton();
        signInPage.enterFirstNameTextFieldInPersonal(nameOfEmailHolder, 1);
    }

    @Test
    public void verifyIsAccountCreatedWithInvalidEmailId(){
        automationPracticeHomePage.clickOnDressNavbar();
        automationPracticeHomePage.clickOnAddCartDressButton(clothId3);
        automationPracticeHomePage.clickOnContinuePurchasingButton();
        automationPracticeHomePage.clickOnTShirtNavbar();
        automationPracticeHomePage.clickOnAddCartTShirtButton(clothId1);
        automationPracticeHomePage.clickOnProceedToCheckoutButton();

        summaryOfProductPage.clickOnProceedToPaymentButton();

        signInPage.enterEmailInTextField(wrongEmailId, 1);
        signInPage.clickOnCreateAnAccountButton();
        signInPage.enterFirstNameTextFieldInPersonal(nameOfEmailHolder, 1);
    }

    @Test
    public void verifyAtLeastOneDressInAddCart(){
        automationPracticeHomePage.clickOnDressNavbar();
        automationPracticeHomePage.clickOnAddCartDressButton(clothId3);
        automationPracticeHomePage.clickOnContinuePurchasingButton();
        automationPracticeHomePage.clickOnTShirtNavbar();
        automationPracticeHomePage.clickOnAddCartTShirtButton(clothId1);
        automationPracticeHomePage.clickOnProceedToCheckoutButton();

        summaryOfProductPage.assertAtLeastOneDress();
    }
}
