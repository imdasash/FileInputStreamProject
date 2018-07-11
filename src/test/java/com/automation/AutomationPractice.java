package com.automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPractice {

	WebDriver driver;
	

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();

	}

	
	
	@Test
	public void LogIn() {
		
		String url = File.getMyValue("URL");
		
		
		driver.get(url);
		
		driver.findElement(By.className("header_user_info")).click();
		
		driver.findElement(By.id("email")).sendKeys(File.getMyValue("User"));
		driver.findElement(By.id("passwd")).sendKeys(File.getMyValue("Password"));
		driver.findElement(By.id("SubmitLogin")).click();
		
		String expText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		
		Assert.assertEquals("Authentication failed.", expText);
	}

}
