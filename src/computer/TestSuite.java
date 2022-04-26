package computer;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import utilities.Utility;

import java.awt.*;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void testName() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
//        1.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));
//        1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
//        1.4 Verify the Product will arrange in Descending order.
        String actualMsg = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        verifyText("Name: Z to A", actualMsg, "Descending order");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
//Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
        // 2.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        Thread.sleep(2000);
        //	2.3 Select Sort By position "Name: A to Z"
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        mouseHover(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']"));
        Thread.sleep(2000);
        //	2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));
        //(//button[@type='button'][normalize-space()='Add to cart'])[1]
        // 2.5 Verify the Text "Build your own computer"
        String actulMsg = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        verifyText("Build your own computer", actulMsg, "Wrong syntax");
        //	2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        Thread.sleep(2000);
        // 2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        //	2.8 Select HDD radio "400 GB [+$100.00]"
        setRadioElement(By.xpath("//input[@id='product_attribute_3_7']"));
        //	2.9 Select OS radio "Vista Premium [+$60.00]"
        setRadioElement(By.xpath("//input[@id='product_attribute_4_9']"));
//         2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        setCheckBoxElement(By.xpath("//label[contains(text(),'Microsoft Office [+$50.00]"));
        setCheckBoxElement(By.xpath("//label[contains(text(),'Total Commander [+$5.00]"));
        //	2.11 Verify the price "$1,475.00"
        String actualMsg = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        verifyText("$1,370.00", actualMsg, "Display Amount");
        Thread.sleep(2000);
        //	2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //	2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actulMsg1 = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        //	2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        mouseHoverClick(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.15 Verify the message "Shopping cart"
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        verifyText("Shopping cart", actualMessage, "Wrong Message");
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.xpath("//input[@id='itemquantity11220']"));
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        //	2.17 Verify the Total"$2,950.00"
        String actualMesg2 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$1,470.00')]"));
        verifyText("$1,470.00", actualMesg2, "Wrong calculation");
        //	2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service')]"));
//	2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //	2.20 Verify the Text “Welcome, Please Sign In!”
        String actualMsg3 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        verifyText("Welcome, Please Sign In!", actualMsg3, "Wrong text");
        //	2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        Thread.sleep(2000);
        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Matis");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Bigin");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "abc@yahoo.com");
        sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "Algeria");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Southhall");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "78,Toyshop");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "TR56JH");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "012365478912");
        Thread.sleep(2000);
        //	2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='save']"));
        //	2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 Select Radio Button “Credit Card”
        setRadioElement(By.xpath("//input[@id='paymentmethod_1']"));
        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='paymentmethod_1']"),"Master card");
        //cilck contine
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        Thread.sleep(2000);
        //2.28 Fill all the details
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Mastercard");
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='CardholderName']"),"Matis");
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='CardNumber']"),"5523654789654123");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"12");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2036");
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='CardCode']"),"456");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        String actualMsg4 = getTextFromElement(By.xpath("//span[contains(text(),'Payment Method:')]"));
        verifyText("Payment Method",actualMsg4,"Wrong payment");
       // 2.32 Verify “Shipping Method” is “Next Day Air”
        String actualMsg5 = getTextFromElement(By.xpath("//span[contains(text(),'Shipping Method:')]"));
        verifyText("Shipping Method",actualMsg5,"Wrong message");
        //	2.33 Verify Total is “$2,950.00”
        String actualM = getTextFromElement(By.xpath("span[class='value-summary'] strong"));
        verifyText("$2,950.00",actualM,"Wrong total");
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath(".button-1.confirm-order-next-step-button"));
        //	2.35 Verify the Text “Thank You”
        String actual = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        verifyText("Thank You",actual,"Error in message");
        //2.36 Verify the message “Your order has been successfully processed!”
        String actualM1 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        verifyText("Your order has been successfully processed!",actualM1,"Error in message");
        //	2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        String actualM2 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        verifyText("Welcome to our store",actualM2, "Wrong message");
    }
    @After
    public void tearDown() {
        // closeBrowsers();
    }
}



