package com.esri.qa.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
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

public class FormConditional1stsec {

	static WebDriver driver = null;
	String SmartCommunitiesurl = "http://cmsqa.esri.com/industries/government/smart-communities/get-started";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(SmartCommunitiesurl);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void conditionalFormTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Smart Communities | Get Started");	
		driver.findElement(By.xpath("//*[@id='world-class']/div[2]/ul/li/a")).click();				// click on "Get a free trial of ArcGIS"
//click on form page then open new tab		
		  Set<String> handler =  driver.getWindowHandles();		  
		  Iterator<String> it = handler.iterator();		  
		  String main_window_id = it.next();
		  System.out.println("main window id----> "+main_window_id);		  
		  String popup_window_id = it.next();
		  System.out.println("pop up window is----> "+popup_window_id);		  
		  driver.switchTo().window(popup_window_id);
		  System.out.println("title of popup window--->"+ driver.getTitle());
		  
		    Thread.sleep(3000);
		    TestUtil.takeScreenShot(driver, "FormLook1sec");
 //filling form on new window:		                      
		    driver.findElement(By.id("firstName")).sendKeys("Testing - Bob"); 
			driver.findElement(By.id("lastName")).sendKeys("Winter"); 
			driver.findElement(By.id("email")).sendKeys("rwinter@esri.com"); 
			driver.findElement(By.id("confirmEmail")).sendKeys("bwinter@esri.com"); 
			driver.findElement(By.id("industry")).sendKeys("Fisheries & Wildlife"); 
			driver.findElement(By.id("submitBtn")).click();		 
			driver.findElement(By.id("confirmEmail")).clear();
			driver.findElement(By.id("confirmEmail")).sendKeys("rwinter@esri.com");
		    Thread.sleep(3000);
		    TestUtil.takeScreenShot(driver, "1secfill");
			driver.findElement(By.id("submitBtn")).click(); 	
		    Thread.sleep(3000);
		    TestUtil.takeScreenShot(driver, "1secDone");
		    Thread.sleep(3000);
//		  driver.close();		  
//		  driver.switchTo().window(main_window_id);
//		  System.out.println("title of main window ---->"+driver.getTitle());
					
	}		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}


	
