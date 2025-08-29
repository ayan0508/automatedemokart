package com.kart.automatedemokart;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.AbstractMethod;

public class Checkout extends AbstractMethod {
	WebDriver driver;

	
	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "pincode")
	WebElement pincode;

	@FindBy(id = "locality")
	WebElement locality;

	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(xpath = "//button[@data-testid='place-order-button']")
	WebElement placeOrderButton;
	
	public Checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String urltobechange(String URL) {
		waitforurltobechange(URL);
		return driver.getCurrentUrl();
	}
	public void productcheckout()
	{
		phone.sendKeys("9779543323");
		pincode.sendKeys("713202");
		locality.sendKeys("Test Locality");
		address.sendKeys("123, Test Street, Test City, Test State, 123456");
		city.sendKeys("Test city");
		state.sendKeys("Test state");
		placeOrderButton.sendKeys("Test country");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		waitforalert();
		alert.accept();
	}
	
	public String orderconformationtoast() {
		By toastLocator = By.xpath("//ol[@tabindex='-1']/li/div/div[1]");
		WebElement toastorder = waitforelementchatgpt(toastLocator);
		return toastorder.getText();
	}
	
}
