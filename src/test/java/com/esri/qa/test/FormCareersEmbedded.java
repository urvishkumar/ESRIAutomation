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

public class FormCareersEmbedded {

	static WebDriver driver = null;
	String CareerEmbedurl = "http://cmsqa.esri.com/careers/main/contact-careers";


	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(CareerEmbedurl);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void careersEmbeddedTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Contact Us");		
		driver.findElement(By.id("230220_3")).click();
		driver.findElement(By.xpath("//*[@id='page1phColumn1']/div[2]/textarea")).sendKeys("If tin whistles are made of tin, what do they make fog horns out of?");  
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "StartCareer");
		driver.findElement(By.id("fname")).sendKeys("Testing - Bob"); 
		driver.findElement(By.id("lname")).sendKeys("Winter"); 
		driver.findElement(By.id("email")).sendKeys("rwinter@esri.com"); 
		driver.findElement(By.id("phone")).sendKeys("(909)793-2853 x3396"); 
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "careerEmb");
		driver.findElement(By.id("btnSubmit")).click();
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "careerEmbDone");
	    Thread.sleep(3000);
	}
	

		
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	}


	
