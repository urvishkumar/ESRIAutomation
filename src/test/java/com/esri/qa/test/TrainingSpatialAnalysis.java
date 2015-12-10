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

public class TrainingSpatialAnalysis {

	static WebDriver driver = null;
	String EsriMyTrainingURL = "http://cmsqa.esri.com/landing-pages/training/spatial-analysis";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(EsriMyTrainingURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void esriMyTrainingTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Learn What Spatial Analysis Can Do for You");	
		
		driver.findElement(By.xpath("//*[@id='ctl3']/div[9]/div/div/a")).click();      // click on "count Me in" 
		driver.findElement(By.id("txtfname")).sendKeys("Testing Bob");                 // write First name  "Testing bob"		
		driver.findElement(By.id("txtlname")).sendKeys("Winter");         // Write last name
		driver.findElement(By.id("email")).sendKeys("rwinter@esri.com");      //Write Email
		driver.findElement(By.id("ddlcountry")).sendKeys("United States");      //select country		     		
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "SAForm");
	    driver.findElement(By.id("btnSubmit")).click();             // click on Singup
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "SAFormDone");    
		driver.findElement(By.id("confirmationClose")).click();              // click on close	  	
		driver.findElement(By.xpath("//*[@id='ctl3']/div[3]/div[2]/a/img")).click();   // click on video
		Thread.sleep(5000);
	    TestUtil.takeScreenShot(driver, "SAVideo");
		driver.findElement(By.xpath("//*[@id='ctl3']/div[13]/span")).click();         // click on close
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "SAClose");
	    Thread.sleep(3000);
	}		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}


	
