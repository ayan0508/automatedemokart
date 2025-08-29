package com.kart.automatedemokart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.util.AbstractMethod;

public class Login extends AbstractMethod {
	WebDriver driver;
	
	@FindBy(xpath = "//button[@data-testid='login-button']")
	WebElement loginButton;

	@FindBy(xpath = "//form[@data-testid='login-form']")
	WebElement loginForm;

	@FindBy(xpath = "//input[@data-testid='username-input']")
	WebElement usernameInput;

	@FindBy(xpath = "//input[@data-testid='password-input']")
	WebElement passwordInput;

	@FindBy(xpath = "//button[@data-testid='login-submit']")
	WebElement loginSubmitButton;
	
	public Login(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void landingPageafterlogin(String username, String password) {
		loginButton.click();
		waitforelement(loginForm);
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginSubmitButton.click();
		
	}
	public ProductlandingPage navigateToProductPage() {
		waitforurltobechange("https://automatedemokart.vercel.app/");
		Assert.assertEquals(driver.getCurrentUrl(), "https://automatedemokart.vercel.app/");
		return new ProductlandingPage(driver); 
	}
}
