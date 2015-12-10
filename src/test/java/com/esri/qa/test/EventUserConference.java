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

public class EventUserConference {

	static WebDriver driver = null;
	String UserConferenceURL = "http://cmsqa.esri.com/events/user-conference";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(UserConferenceURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void eventUserConferenceTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "2015 Esri User Conference (UC) July 20-24 in San Diego");	
		//driver.findElement(By.linkText("#Road To UC")).click();
		driver.findElement(By.xpath("//*[@id='navigation']/div[1]/ul/li[2]/a")).click();      // click on Road to UC
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "RoadtoUC");
		driver.findElement(By.xpath("//*[@id='navigation']/div[1]/ul/li[3]/a")).click();         // click on Agenda
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Agenda");
		driver.findElement(By.xpath("//*[@id='navigation']/div[1]/ul/li[4]/a")).click();        //click on sessions
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Sessions");
		driver.findElement(By.xpath("//*[@id='navigation']/div[1]/ul/li[5]/a")).click();       //click on Exhibits
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Exhibits");
		driver.findElement(By.xpath("//*[@id='navigation']/div[1]/ul/li[6]/a")).click();       // click on Activities
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Activities");
		driver.findElement(By.xpath("//*[@id='navigation']/div[1]/ul/li[7]/a")).click();        // click on Hotels
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Hotels");
		driver.findElement(By.xpath("//*[@id='navigation']/div[1]/ul/li[8]/a")).click();        // click on My UC 
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "MyUC");
		driver.navigate().to(UserConferenceURL);

		driver.findElement(By.xpath("//*[@id='relive-the-magic']/div[1]/div/div/div/a[2]/div")).click();  // click on video
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Videolink");
		driver.findElement(By.xpath("//*[@id='vision']/div[3]/a/div/div")).click();       // Again click on video
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "VisionVideo");
		driver.findElement(By.xpath("//*[@id='subpage']/div[3]/div/div/a")).click();         // close video   
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "CloseVideo");
	    Thread.sleep(3000);
	
	}
	

		
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	}


	
