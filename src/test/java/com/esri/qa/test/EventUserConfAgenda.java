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

public class EventUserConfAgenda {

	static WebDriver driver = null;
	String EventUserConfAgendaURL = "http://cmsqa.esri.com/events/user-conference/agenda";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(EventUserConfAgendaURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void eventUserConfAgendaTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Agenda | 2015 Esri User Conference");	
		
		driver.findElement(By.xpath("//*[@id='subpage-content']/div/p[2]/a[1]")).click();       //click on build your event
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "BuildEvent");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='subpage-content']/div/p[2]/a[2]")).click();      //click on FAQ
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "FAQ");		
		driver.findElement(By.xpath("//*[@id='subpage-content']/div/p[2]/a[3]")).click();       //click on Download 
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Download");
		driver.switchTo().frame(0);	 
		driver.findElement(By.id("menuButton")).click();          // click on  menu button
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "MenuButton");
		driver.findElement(By.id("eventSessions-MenuOption")).click();    // click on sessions  
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Sessions");
		driver.findElement(By.id("menuButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("eventActivities-MenuOption")).click();		//click on Activities
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Activities");
		driver.findElement(By.id("filterButton")).click();                 //click on search		
		driver.findElement(By.id("keywordInput")).sendKeys("Testing");      // write Testing in keyword filter
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "KeywordInput");
		driver.findElement(By.id("viewResultsButton")).click();                 // click on view results
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "searchResult");
	    Thread.sleep(3000);

	}
	

		
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	}


	
