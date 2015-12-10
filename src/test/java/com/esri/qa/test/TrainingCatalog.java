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

public class TrainingCatalog {

	static WebDriver driver = null;
	String TrainingCatalogURL = "http://cmsqa.esri.com/training/main/training-catalog";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(TrainingCatalogURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void trainingCatalogTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Esri Training Catalog");	
		

		driver.findElement(By.xpath("//*[@id='terSubnav']/div/div[1]/a[2]")).click();    // click on "class schedule"      
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "classSchedule");
		driver.findElement(By.xpath("//*[@id='terSubnav']/div/div[1]/a[3]")).click();    // click on "Course Recommendations"   
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "CourseRecom");
		driver.findElement(By.xpath("//*[@id='terSubnav']/div/div[1]/a[4]")).click();   // click on "Training Locations"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "TrainingLocat");
		driver.findElement(By.xpath("//*[@id='terSubnav']/div/div[1]/a[5]")).click();     // click on "How to Purchase"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "HowtoPurchase");
		driver.findElement(By.xpath("//*[@id='terSubnav']/div/div[1]/a[1]")).click();      // click on "Overview"    
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Overview");
		driver.switchTo().frame(0);	 
		driver.findElement(By.id("searchterm")).sendKeys("Testing");    // write Testing on Search box
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "SearchBox");
		driver.findElement(By.id("submitSearch")).click();    // click on search
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "ResultSearch");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='Form1']/div[6]/div[3]/p[2]/a")).click();  // click on  "View entire catalog"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "viewEntirecat");
		driver.navigate().back();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}


	
