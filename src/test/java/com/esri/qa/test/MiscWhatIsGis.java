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

public class MiscWhatIsGis {

	static WebDriver driver = null;
	String MiscWhatIsGisURL = "http://cmsqa.esri.com/what-is-gis";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(MiscWhatIsGisURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void miscWhatIsGisTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "What is GIS");	
		
		driver.findElement(By.xpath("//*[@id='topSubnav']/a[2]")).click();   //click on "How GIS Works"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "GisWork");
		driver.findElement(By.xpath("//*[@id='topSubnav']/a[3]")).click();    //click on "Showcase"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Showcase");
		driver.findElement(By.xpath("//*[@id='topSubnav']/a[4]")).click();	  //click on "Jobs"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "jobs");
		driver.findElement(By.xpath("//*[@id='topSubnav']/a[5]")).click();	  //click on "Training/Education"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "trainEduc");
		driver.findElement(By.xpath("//*[@id='topSubnav']/a[1]")).click();	 //click on "Main"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Main");
		driver.findElement(By.xpath("//*[@id='ctl3']/div[3]/div[1]/div/div[2]/p[2]/a")).click();	//click on Read more in "Cost saving"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "costsave");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='ctl3']/div[3]/div[2]/div/div[2]/p[2]/a")).click();	//click on Read more in "Better Decision"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "BetterDecision");
		driver.navigate().back();
		
		
		driver.findElement(By.xpath("//*[@id='ctl3']/div[3]/div[4]/div/div[2]/p/a")).click();	 // click on Improved communication
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Improvecommu");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='ctl3']/div[3]/div[5]/div/div[2]/p/aa")).click();	  // click on "Better Record Keeping"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "RecdKeep");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='ctl3']/div[3]/div[8]/div/div[2]/p/a")).click();	  //click on "Managing Geographically"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "ManagGeo");
		driver.navigate().back();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() {
     driver.quit();
	}
	}


	
