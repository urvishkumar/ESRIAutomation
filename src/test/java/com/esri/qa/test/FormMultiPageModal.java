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

public class FormMultiPageModal {

	static WebDriver driver = null;
	String MultiPageModalURL = "http://cmsqa.esri.com/nonprofit";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(MultiPageModalURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void multiPageModalTest() throws InterruptedException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Take your mission to the next level with Esri's program for nonprofit organizations");	
		driver.findElement(By.xpath("//*[@id='npo']/div[7]/a")).click();
		//Thread.sleep(5000);
		//driver.switchTo().frame(1);
		//82202_20146pi_82202_20146
		//driver.findElement(By.xpath("//input[@id='82202_20146pi_82202_20146']")).sendKeys("test");
		System.out.println(driver.findElements(By.xpath("//input[contains(@id,'82202_')]")).size());
		//driver.findElement(By.xpath("//*[@id='82202_20146pi_82202_20146']")).click();
		//driver.findElement(By.name("82202_20146pi_82202_20146")).sendKeys("FirstName_Test");  
//    	driver.findElement(By.id("82202_20148pi_82202_20148")).sendKeys("LastName_Test"); 
//    	driver.findElement(By.id("82202_20150pi_82202_20150")).sendKeys("test@esri.com");     	
//		driver.findElement(By.id("82202_20152pi_82202_20152")).sendKeys("ESRI_Test"); 
	//	driver.findElement(By.id("82202_20172pi_82202_20172")).sendKeys("1234567890"); 		
//		driver.findElement(By.id("82202_20154pi_82202_20154")).sendKeys("United States"); 
//		driver.findElement(By.id("82202_20156pi_82202_20156")).sendKeys("California"); 
//		driver.findElement(By.id("82202_20178pi_82202_20178")).sendKeys("Test_Que"); 
		//driver.findElement(By.xpath("//*[@id='pardot-form']/p[3]/input")).click();
	
		
	
	}
	

		
	@AfterMethod
	public void tearDown() {

		//driver.quit();
	}
	}


	
