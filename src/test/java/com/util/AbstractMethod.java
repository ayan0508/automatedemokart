package com.util;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractMethod {
	WebDriver driver;
	WebDriverWait wait;
	
	public AbstractMethod(WebDriver driver) {
		this.driver=driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public WebElement waitforelement(WebElement ele) {
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public Alert waitforalert() {
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	public boolean waitforurltobechange(String  URL) {
		return wait.until(ExpectedConditions.urlToBe(URL));
	}
	
	//chatgpt
	public WebElement waitforelementchatgpt(By locator) {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
