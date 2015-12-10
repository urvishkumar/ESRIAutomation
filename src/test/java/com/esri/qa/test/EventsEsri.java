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

public class EventsEsri {

	static WebDriver driver = null;
	String EventsEsriURL = "http://cmsqa.esri.com/events";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(EventsEsriURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void eventsEsriTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Esri Events | GIS User Conferences - Seminars - User Groups");			
		
	    driver.findElement(By.xpath("//*[@id='topSubnav']/a[2]")).click();  //click on Recent Proceedings
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "RecentProceed");
	    driver.navigate().to(EventsEsriURL);                                   
	    driver.findElement(By.xpath("//*[@id='topSubnav']/a[3]")).click();      // click on User Groups
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "UserGroup");
		driver.findElement(By.xpath("//*[@id='topSubnav']/a[1]")).click();      // click on Main
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Main");
		driver.findElement(By.xpath("//*[@id='conferenceItems']/div[1]/a/div")).click();  //click on Esri User Conference
		Thread.sleep(3000);	    
	    TestUtil.takeScreenShot(driver, "UserConference");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='conferenceItems']/div[2]/a/div")).click();  // click on Esri Health & Human Services
		Thread.sleep(3000);	  
	    TestUtil.takeScreenShot(driver, "Health&Human");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='conferenceItems']/div[3]/a/div")).click();  // click on Electric & gas
		Thread.sleep(3000);
	    
	    TestUtil.takeScreenShot(driver, "Electric&Gas");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='conferenceItems']/div[4]/a/div")).click();  // click on Esri Developer summit Europe
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "DevelopSummit");
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[@id='conferenceItems']/div[7]/p/a[1]")).click();   // click on Search All Events
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "SearchallEvent");
		driver.navigate().back();		
		driver.findElement(By.xpath("//*[@id='conferenceItems']/div[7]/p/a[2]")).click();  // click on contact event staff
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "ContactEvent");
		driver.navigate().back();
		Thread.sleep(3000);
		
		
		
		
		
		
	}
	

		
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	}


	
