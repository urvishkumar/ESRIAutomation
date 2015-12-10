package com.esri.qa.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormSignUpfortheArcGISTrial {

	static WebDriver driver = null;
	String ArcGisDeskTrialurl = "http://cmsqa.esri.com/software/arcgis/arcgis-for-desktop/free-trial";
	 
	@BeforeMethod
	public void setUp() {
	
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(ArcGisDeskTrialurl);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void arcGisDeskTrialTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "ArcGIS for Desktop | Free Trial");  
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "ArcGisForm");
		driver.switchTo().frame(0);	  		   
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Testing - Bob"); 		   
		driver.findElement(By.id("lastName")).sendKeys("Winter"); 
		driver.findElement(By.id("email")).sendKeys("rwinter@esri.com"); 
		driver.findElement(By.id("confirmEmail")).sendKeys("rwinter@esri.com"); 
		driver.findElement(By.id("industry")).sendKeys("Other"); 
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "ArcGisFill");
		driver.findElement(By.id("submitBtn")).click();
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "ArcGisDone");
		 Thread.sleep(3000);
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}


	
