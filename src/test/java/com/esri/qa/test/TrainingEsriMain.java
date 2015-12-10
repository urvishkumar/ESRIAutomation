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

public class TrainingEsriMain {

	static WebDriver driver = null;
	String EsriTrainingMainURL = "http://www.esri.com/training/main";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(EsriTrainingMainURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void esriTrainingMainTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Esri Training");	
		
		driver.findElement(By.xpath("//*[@id='topSubnav']/a[2]")).click();        // click on "Training catalog"  
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "TrainCat");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='topSubnav']/a[3]")).click();       // click on "My Training"     
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "MyTrain");
		driver.findElement(By.xpath("//*[@id='topSubnav']/a[4]")).click();        // click on "News"    
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "News");
		driver.findElement(By.xpath("//*[@id='topSubnav']/a[5]")).click();       // click on "Certification"     
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Certificate");
		driver.findElement(By.xpath("//*[@id='topSubnav']/a[6]")).click();        //click on "common Que"   
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "CommonQue");
		driver.findElement(By.xpath("//*[@id='topSubnav']/a[1]")).click();         //click on "Main"   
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "MainLink");
		
		driver.findElement(By.xpath("//*[@id='terSubnav']/div/div[1]/a[2]")).click();    // click on "Getting Started"      
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "GettingStarted");
		driver.findElement(By.xpath("//*[@id='terSubnav']/div/div[1]/a[3]")).click();     // click on "Intro -Led Courses"      
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "IntroLedCourse");
		driver.findElement(By.xpath("//*[@id='terSubnav']/div/div[1]/a[4]")).click();     // click on "E-Learning courses"     
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "E-learning");
		driver.findElement(By.xpath("//*[@id='terSubnav']/div/div[1]/a[5]")).click();     // click on "Training for prganization"     
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "TrainOrg");
		driver.findElement(By.xpath("//*[@id='terSubnav']/div/div[1]/a[1]")).click();     // click on "Overview"     
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "OverviewTrain");		
		driver.findElement(By.xpath("//*[@id='main-content']/a/div/div/div[1]/div/p")).click();      // click on "Esri Training Pass"    
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "TrainingPass");
		driver.navigate().back();
		
		driver.findElement(By.id("searchterm")).sendKeys("Test");     // Write Test in search box   
		driver.findElement(By.id("submitSearch")).click();
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Searchbox");
	    Thread.sleep(3000);
		
	}
	

		
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	}


	
