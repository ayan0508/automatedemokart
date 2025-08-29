package com.kart.automatedemokart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.AbstractMethod;

public class ProductlandingPage extends AbstractMethod {
	WebDriver driver;
	public ProductlandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/product/1'][1]")
	WebElement clicktoproduct;
	
	
	public String gettoasttext() {
		WebElement toast=waitforelement(driver.findElement(By.xpath("//ol[@tabindex='-1']/li")));
		WebElement nestedDiv = toast.findElement(By.xpath("./div/div[2]"));
	    return nestedDiv.getText();
	}
	
	public Addtocart selectaddtocart() {
		clicktoproduct.click();
		boolean urlchanged=waitforurltobechange("https://automatedemokart.vercel.app/product/1");
		System.out.println("URL changed: " + urlchanged);
		By buyButtonLocator = By.xpath("//button[@data-testid='buy-now-button']");
		WebElement buy_button = waitforelementchatgpt(buyButtonLocator);
		buy_button.click();

		return new Addtocart(driver);
	}
	
}
