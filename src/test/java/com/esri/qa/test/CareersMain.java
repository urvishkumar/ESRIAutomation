package com.esri.qa.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CareersMain {

	static WebDriver driver = null;
	String CareersMainURL = "http://cmsqa.esri.com/careers/main";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(CareersMainURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void esriCareersMainTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Careers at Esri");	
		driver.findElement(By.linkText("COME JOIN US")).click();           // click on contact us
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "CareerCotactus");
	    driver.navigate().back();	    
	    driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();            // click on Log in
		Thread.sleep(5000);
	    TestUtil.takeScreenShot(driver, "Careerlogin");
	    driver.navigate().back();		
	    driver.findElement(By.xpath("//a[contains(text(),'Scroll to explore')]')]")).click();   // click on Scroll to Explore
	    Thread.sleep(3000);
	}
	

		
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	}


	
