package electronics;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
   //Test name text verified()
    public void textVerified(){
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //1.3 Verify the text “Cell phones”
        String actualMsg = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        verifyText("Cell phones", actualMsg, "Wrong text");
    }
        @Test
        public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()throws InterruptedException{
        //	2.1 Mouse Hover on “Electronics” Tab
            mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
            //2.2 Mouse Hover on “Cell phones” and click
            mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
            //2.3 Verify the text “Cell phones”
            String actualMsg = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
            verifyText("Cell phones", actualMsg, "Wrong text");
            Thread.sleep(3000);
            // 	2.4 Click on List View Tab
            mouseHover(By.xpath("//a[contains(text(),'List')]"));
            clickOnElement(By.xpath("//a[contains(text(),'List')]"));
           // 2.5 Click on product name “Nokia Lumia 1020” link
            clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
            //	2.6 Verify the text “Nokia Lumia 1020”
            String actualMsg1 = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
            verifyText("Nokia Lumia 1020",actualMsg1,"Wrong text");
            //	2.7 Verify the price “$349.00”
            String actualMsg2 = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
            verifyText("$349.00",actualMsg2,"Wrong calculation");
            //	2.8 Change quantity to 2
            sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
            //	2.9 Click on “ADD TO CART” tab
            clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
            Thread.sleep(3000);
            //	2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
            String actualMsg3 = getTextFromElement(By.xpath("//a[contains(text(),'shopping cart')]"));
            verifyText("The product has been added to your shopping cart",actualMsg3,"Wrong text");
            //After that close the bar clicking on the cross button.
            clickOnElement(By.xpath("//span[@title='Close']"));
            //	2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
            mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
            clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
            //	2.12 Verify the message "Shopping cart"
            String actualMsg4 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
            verifyText("Shopping cart",actualMsg4,"Wrong text");
            //	2.13 Verify the quantity is 2
            String actualMsg5 = getTextFromElement(By.xpath("//input[@id='itemquantity11224']"));
            verifyText("2",actualMsg5,"Wrong Quntity");
            Thread.sleep(3000);
            //2.14 Verify the Total $698.00
            String actualMsg6 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
            verifyText("$698.00",actualMsg6,"Error in total");
            //2.15 click on checkbox “I agree with the terms of service”
            clickOnElement(By.xpath("//input[@id='termsofservice']"));
            //2.16 Click on checkout
            clickOnElement(By.xpath("//button[@id='checkout']"));
            //“2.17 Verify the Text “Welcome, Please Sign In!”
            String actualMsg7 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
            verifyText("Welcome, Please Sign In!",actualMsg7,"Wrong message");
            // 	2.18 Click on “REGISTER” tab
            clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
            //	2.19 Verify the text “Register”
            String actualMsg8 = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
            verifyText("Register",actualMsg8,"Wrong text");
            //	2.20 Fill the mandatory fields
            sendTextToElement(By.xpath("//input[@id='FirstName']"),"Nathan");
            sendTextToElement(By.xpath("//input[@id='LastName']"),"Raja");
            sendTextToElement(By.xpath("//input[@id='Email']"),"nathan3r@gmail.com");
            sendTextToElement(By.xpath("//input[@id='Password']"),"xyz123");
            sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"xyz123");
           //	2.21 Click on “REGISTER” Button
            clickOnElement(By.xpath("//button[@id='register-button']"));
            //	2.22 Verify the message “Your registration completed”
            String actualMsg9 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
            verifyText("Your registration completed",actualMsg9,"Wrong text");
            //	2.23 Click on “CONTINUE” tab
            clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
            //	2.24 Verify the text “Shopping cart”
            String actualMst10 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
            verifyText("Shopping cart",actualMst10,"Wrong text");
            //	2.25 click on checkbox “I agree with the terms of service”
            clickOnElement(By.xpath("//input[@id='termsofservice']"));
            //	2.26 Click on “CHECKOUT”
            clickOnElement(By.xpath("//button[@id='checkout']"));
            //	2.27 Fill the Mandatory fields
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Nathan");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Raja");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"nathan3r@gmail.com");
            sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"Angola");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Manchester");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"98,Hill Garden");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"TR4 7JL");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"09656489632");
            //	2.28 Click on “CONTINUE”
            clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
            //	2.29 Click on Radio Button “2nd Day Air ($0.00)”
            setRadioElement(By.xpath("//input[@id='shippingoption_2']"));
            //2.30 Click on “CONTINUE”
            clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
            //2.31 Select Radio Button “Credit Card”
            setRadioElement(By.xpath("//input[@id='paymentmethod_1']"));
            //click on continue
            clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
            //2.32 Select “Visa” From Select credit card dropdown
            //2.33 Fill all the details
            selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Visa Card");
            sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Nathan");
           sendTextToElement(By.xpath("//input[@id='CardNumber']"),"2221 4569 7896 4569");
            selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"12");
            selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2036");
            selectByVisibleTextFromDropDown(By.xpath("//input[@id='CardCode']"),"789");
            //2.34 Click on “CONTINUE”CHECKOUT”
            clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
            //2.35 Verify “Payment Method” is “Credit Card”
            String actualMsg11 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
            //2.36 Verify “Shipping Method” is “2nd Day Air”
            String actualMsg12 = getTextFromElement(By.xpath("//span[contains(text(),'Shipping Method:')]"));
            verifyText("Shipping Method",actualMsg12,"Wrong message");
            //	2.37 Verify Total is “$698.00”
            String actualMsg13 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
            verifyText("$698.00",actualMsg13,"Wrong calculation");
            //	2.38 Click on “CONFIRM”
            clickOnElement(By.xpath("\t//button[contains(text(),'Confirm')]"));
            //	2.39 Verify the Text “Thank You”
            String actual14 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
            verifyText("Thank You",actual14,"Wrong text");
            //	2.40 Verify the message “Your order has been successfully processed!”
            String actualMsg15 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
            verifyText("Your order has been successfully processed!",actualMsg15,"Wrong text");
            //	2.41 Click on “CONTINUE”
            clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
            //2.42 Verify the text “Welcome to our store”
            String actualMsg16 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
            verifyText("Welcome to our store",actualMsg16,"Wrong text");
            //2.43 Click on “Logout” link
            clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
            //2.44 Verify the URL is “https://demo.nopcommerce.com/”
            verifyUrl("“https://demo.nopcommerce.com/”");

        }
    @After
    public void tearDown() {
        // closeBrowsers();
    }

}
