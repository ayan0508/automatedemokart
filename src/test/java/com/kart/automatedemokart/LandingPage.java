package com.kart.automatedemokart;

import com.util.AbstractMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractMethod {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[@data-testid='add-to-cart-1'][1]")
	WebElement addToCartButton;

	@FindBy(xpath = "//ol[@tabindex='-1']/li")
	WebElement toastContainer;
	
	public String getTitle() {
		return driver.getTitle();
	}
	public String addtocartwithoutlogin() {
		addToCartButton.click();
		WebElement error_toast= waitforelement(toastContainer);
		WebElement nestedDiv = error_toast.findElement(By.xpath("./div/div[2]"));
	    return nestedDiv.getText();
	}
	
}
