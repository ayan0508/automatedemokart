package com.kart.automatedemokart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class DemoKartTestSuite {
    WebDriver driver;
    LandingPage landingPage;
    Login loginPage;
    ProductlandingPage productPage;
    Addtocart cartPage;
    Checkout checkoutPage;
    SoftAssert softAssert;
    @BeforeClass
    public void setUp() {
        // 1) Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automatedemokart.vercel.app/");
        
        landingPage    = new LandingPage(driver);
        loginPage      = new Login(driver);
        productPage    = new ProductlandingPage(driver);
        cartPage       = new Addtocart(driver);
        checkoutPage   = new Checkout(driver);
    }
    @BeforeMethod
    public void initializeSoftAssert() {
        softAssert = new SoftAssert(); // This creates a fresh object for every test
    }
    
    @Test(priority = 1)
    public void tc001_addToCartWithoutLogin() {
        String toast = landingPage.addtocartwithoutlogin();
        softAssert.assertEquals(toast, "You need to log in to add items to cart");
        softAssert.assertAll();
    }

    @Test(priority = 2, dependsOnMethods = "tc001_addToCartWithoutLogin")
    public void tc002_loginWithValidCredentials() {
        loginPage.landingPageafterlogin("testuser", "@Test123");
       
    }

    @Test(priority = 3, dependsOnMethods = "tc002_loginWithValidCredentials")
    public void tc003_welcomeBackToastOnProductPage() {
        productPage = loginPage.navigateToProductPage();
        String welcomeToast = productPage.gettoasttext();
        softAssert.assertEquals(welcomeToast, "Welcome back!");
        softAssert.assertAll();
    }

    @Test(priority = 4, dependsOnMethods = "tc003_welcomeBackToastOnProductPage")
    public void tc004_addToCartAndValidateUrl() {
        cartPage = productPage.selectaddtocart();
        String currentUrl = cartPage.isurlchanged("https://automatedemokart.vercel.app/cart");
        softAssert.assertEquals(currentUrl, "https://automatedemokart.vercel.app/cart");
        cartPage.addtocarttoast();
        softAssert.assertEquals(cartPage.addtocarttoast(), "Phone 15 Pro Max has been added to your cart");
        cartPage.clickoncheckout();
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void tc005_checkoutAndOrderConfirmation() {
    	

        checkoutPage.urltobechange("https://automatedemokart.vercel.app/checkout");
        checkoutPage.productcheckout();
        String confirmToast = checkoutPage.orderconformationtoast();
        softAssert.assertEquals(confirmToast, "Order placed successfully!");
        softAssert.assertAll();
    }
    public WebDriver getDriver() {
        return driver;
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    
}