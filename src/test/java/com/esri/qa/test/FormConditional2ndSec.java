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

public class FormConditional2ndSec {

	static WebDriver driver = null;
	String SmartCommunitiesurl = "http://cmsqa.esri.com/industries/government/smart-communities/get-started";


	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(SmartCommunitiesurl);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void conditionalFormTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Smart Communities | Get Started");			
	    driver.findElement(By.id("read-paper")).click();	               // click on smart communities white paper
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Whitepaperform");
	    driver.findElement(By.id("fname")).sendKeys("Testing - Bob"); 
		driver.findElement(By.id("lname")).sendKeys("Winter"); 
		driver.findElement(By.id("company")).sendKeys("ESRI"); 
		driver.findElement(By.id("email")).sendKeys("rwinter@esri.com"); 
		driver.findElement(By.id("JobTitle")).sendKeys("Poobah of Ratiocination & Interdigitation"); 
		driver.findElement(By.id("country")).sendKeys("United States"); 
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "WhitePaperFill");
		driver.findElement(By.id("btnSubmit")).click();	 
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "WhitePaperDone");
	    Thread.sleep(3000);		
	}		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}


	
