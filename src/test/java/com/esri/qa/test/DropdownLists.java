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

public class DropdownLists {

	static WebDriver driver = null;
	String DropdownListsURL = "http://www.esri.com/apps/products/download/index.cfm";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(DropdownListsURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void dropdownListsTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Esri Downloads");	
		
		driver.findElement(By.xpath("//*[@id='contentWrapper']/p[1]/a[1]")).click();    //click on Esri Global Account
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "EsriGlobalAccount");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='contentWrapper']/p[1]/a[2]")).click();   // click on create one
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "Createone");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='softwareSelector']/div/select")).sendKeys("ArcExplorer");     //select ArcExplorer in bpx
		Thread.sleep(5000);
		TestUtil.takeScreenShot(driver, "ArcExplorer");
		driver.findElement(By.xpath("//*[@id='softwareSelector']/div/select")).sendKeys("ArcGIS_API_for_Silverlight");  // select ArcGIS API for Silverlight
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "APTSilverlight");
		driver.findElement(By.xpath("//*[@id='contentWrapper']/p[3]/a")).click(); // select back to top
		TestUtil.takeScreenShot(driver, "BackToTop");
		Thread.sleep(3000);

	}
	

		
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	}


	
