package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.*;

public class Browserfactory {
	public class BrowserFactory {

	    public static WebDriver getDriver(String browserName) {
	        WebDriver driver;

	        switch (browserName.toLowerCase()) {
	            case "chrome":
	            	ChromeOptions chromeOptions = new ChromeOptions();
	            	chromeOptions.addArguments("--headless");
	            	chromeOptions.addArguments("--disable-gpu"); // Often recommended with headless
	            	chromeOptions.addArguments("--window-size=1920,1080");
	                driver = new ChromeDriver(chromeOptions);
	                break;

	            case "firefox":
	                driver = new FirefoxDriver();
	                break;

	            case "edge":
	            	//System.setProperty("webdriver.edge.driver", "E:/Selenium/automatedemokart/driver/edgedriver_win32/msedgedriver.exe");
	            	WebDriverManager.edgedriver().browserVersion("139").setup();
	            	EdgeOptions options = new EdgeOptions();
	            	options.addArguments("--headless");
	            	options.addArguments("--disable-gpu"); // Often recommended with headless
	            	options.addArguments("--window-size=1920,1080");
	                driver = new EdgeDriver(options);
	                break;

	            default:
	                throw new IllegalArgumentException("Unsupported browser: " + browserName);
	        }

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        return driver;
	    }
	}
}
