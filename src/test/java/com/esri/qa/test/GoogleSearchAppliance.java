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

public class GoogleSearchAppliance {

	static WebDriver driver = null;
	String GoogleSearchURL = "http://cmsqa.esri.com/search";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(GoogleSearchURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void googleSearchTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Search");	
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Test Job");     //write Test Job in search box
		 Thread.sleep(3000);
		    TestUtil.takeScreenShot(driver, "Gsa1");
		//driver.findElement(By.xpath("//*[@id='contentWrapper']/div[1]/div/div/input")).sendKeys("Test Job"); 
		//driver.findElement(By.xpath("//*[@id='contentWrapper']/div[1]/div/div/div")).click();
		driver.findElement(By.xpath("//div[@class='search-btn btn transparent']")).click();            // Enter
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Gsa2");
	    Thread.sleep(3000);	

	}		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}


	
