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

public class MiscPageSoftLicense {

	static WebDriver driver = null;
	String SoftwareLicenceURL = "http://cmsqa.esri.com/legal/software-license";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(SoftwareLicenceURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void softwareLicenceTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Legal Information | Licensing Terms");			
		driver.findElement(By.xpath("//*[@id='bodyColumns']/div[2]/h2[2]/a")).click();	 // click on "Current License Agreement"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "LicAgremnt");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='bodyColumns']/div[2]/h2[3]/a")).click();	  // click on " Terms & conditions"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "TermCond");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='bodyColumns']/div[2]/h2[4]/a")).click();	// click on "Scope of Use"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "ScopUse");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='bodyColumns']/div[2]/div[1]")).click();   // Click on "Show /Hide all lic agreements"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Showall");
		driver.findElement(By.xpath("//*[@id='bodyColumns']/div[2]/p[2]/a")).click();   // click on "Restriction/Terms"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "RestTerm");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='bodyColumns']/div[2]/ul/li[1]/a")).click();    // click on "Version 10.0 vs. Version 10.1"
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='bodyColumns']/div[2]/ul/li[2]/a")).click();   // click on "Version 10.1 vs. Version 10.2"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Version");
	    Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}


	
