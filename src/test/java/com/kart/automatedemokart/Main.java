package com.kart.automatedemokart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {
	
	
	@Test
	public void setup() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://automatedemokart.vercel.app/");
	
	LandingPage lp = new LandingPage(driver);
	//String title = lp.getTitle();
	Assert.assertEquals(lp.addtocartwithoutlogin(), "You need to log in to add items to cart");  //tc001
	
	
	Login login = new Login(driver);
	login.landingPageafterlogin("testuser", "@Test123"); //tc002
	
	
	ProductlandingPage plp =login.navigateToProductPage(); //tc003
	Assert.assertEquals(plp.gettoasttext(), "Welcome back!"); //tc003
	Addtocart ad=plp.selectaddtocart(); //tc004
	Assert.assertEquals(ad.isurlchanged("https://automatedemokart.vercel.app/cart"),"https://automatedemokart.vercel.app/cart");
	//ad.addtocarttoast();
	
	
	ad.clickoncheckout(); //tc005
	Checkout ch=new Checkout(driver);
	ch.urltobechange("https://automatedemokart.vercel.app/checkout");
	ch.productcheckout();
	String orderconfirm_toast=ch.orderconformationtoast();
	Assert.assertEquals(orderconfirm_toast, "Order placed successfully!");
	}
}
