package com.kart.automatedemokart;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.util.AbstractMethod;

public class Addtocart extends AbstractMethod {
	WebDriver driver;
	
	@FindBy(xpath="//button[@data-testid='proceed-to-checkout']")
	WebElement checkoutButton;
	
	@FindBy(xpath="//ol[@tabindex='-1']/li")
	WebElement buyNowError;
	
	public Addtocart(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String isurlchanged(String URL) {
		waitforurltobechange(URL);
		return driver.getCurrentUrl();
	}
	public String addtocarttoast() {
		return buyNowError.findElement(By.xpath("./div/div[2]")).getText();	
	}
	public void clickoncheckout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", checkoutButton);
		
	}
}
