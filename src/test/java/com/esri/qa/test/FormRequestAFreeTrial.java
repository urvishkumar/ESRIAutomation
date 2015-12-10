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

public class FormRequestAFreeTrial {

	static WebDriver driver = null;
	String FreeTrialurl = "http://www.esri.com/apps/products/offers/mapping/index.cfm?prd=avair";

	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(FreeTrialurl);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void freeTrialTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Esri | Request a Free Trial");  
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Freetrial");
		driver.findElement(By.id("prefix")).sendKeys("Mr.");
		driver.findElement(By.id("fname")).sendKeys("Testing - Bob"); 
		driver.findElement(By.id("lname")).sendKeys("Winter"); 
		driver.findElement(By.id("jobtitle")).sendKeys("Poobah of Ratiocination & Interdigitation"); 
		driver.findElement(By.id("company")).sendKeys("ESRI (Missoula, MT) "); 
		driver.findElement(By.id("department")).sendKeys("Testing_WebDev"); 		
		driver.findElement(By.id("add1")).sendKeys("123 Main Street"); 
		driver.findElement(By.id("city")).sendKeys("Redlands"); 
		driver.findElement(By.id("state")).sendKeys("California"); 
		driver.findElement(By.id("zip")).sendKeys("92373"); 
		driver.findElement(By.id("phone")).sendKeys("(909) 793-2853 x3396"); 
		driver.findElement(By.id("email")).sendKeys("rwinter@esri.com"); 
		driver.findElement(By.id("email2")).sendKeys("rwinter@esri.com"); 
		driver.findElement(By.id("industry")).sendKeys("Fisheries & Wildlife"); 
		driver.findElement(By.id("orgtype")).sendKeys("Commercial/Private Business"); 
		driver.findElement(By.id("relationship")).sendKeys("Esri Employee"); 
		driver.findElement(By.id("Org_Role")).sendKeys("Elected/Appointed Official"); 
		driver.findElement(By.id("ArcgisList4")).click(); 
		driver.findElement(By.id("licenseType1")).click(); 
		driver.findElement(By.id("gisexp")).sendKeys("4-7 years"); 
		driver.findElement(By.id("versionType1")).click(); 
		driver.findElement(By.id("accomp")).sendKeys("Testing"); 	
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "FreeTrialFill");
//    Cap Image....Can't automate in selenium
		driver.findElement(By.id("submit_btn")).click();  
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "FreeTrialDone");
	    Thread.sleep(3000);
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}


	
