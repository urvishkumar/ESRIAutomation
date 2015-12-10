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

public class CareersJobDetail {

	static WebDriver driver = null;
	String CareersJobDetailURL = "http://cmsqa.esri.com/careers/main/job-detail";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(CareersJobDetailURL);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void careersJobDetailTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Esri Careers | Job Details");	
		driver.findElement(By.xpath("//*[@id='pg-content-area']/div[1]/ul/li[1]/a")).click(); // click on Appynow
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "Applynow");
		driver.findElement(By.xpath("//*[@id='pg-content-area']/div[1]/ul/li[2]/a")).click();  // click on search jobs
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "searchjob");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='pg-content-area']/div[1]/ul/li[3]/a")).click();   //click on Recruiting events
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "RecruitingEvents");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='pg-content-area']/div[1]/ul/li[5]/a")).click();   // click on Benefits
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "Benefits");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='pg-content-area']/div[1]/ul/li[6]/a")).click();    // click on Campus tour
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "campusTour");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='pg-content-area']/div[1]/ul/li[7]/a")).click();  // click on Student&Grads
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "Student&Grads");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='pg-content-area']/div[1]/ul/li[8]/a")).click();  //click on FAQ
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "FAQ");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='pg-content-area']/div[1]/ul/li[11]/ul/li/a")).click();  // click on share
		TestUtil.takeScreenShot(driver, "Share");	
		Thread.sleep(3000);
		

	}
	

		
	@AfterMethod
	public void tearDown() {

		driver.quit();       // close window
	}
	}


	
