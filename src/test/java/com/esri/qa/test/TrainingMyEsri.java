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

public class TrainingMyEsri {

	static WebDriver driver = null;
	String EsriMyTrainingURL = "http://cmsqa.esri.com/training/main/my-training";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(EsriMyTrainingURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void esriMyTrainingTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "My Esri Training");	
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "TrainingMy");
		
		driver.findElement(By.xpath("//*[@id='Form1']/div[6]/a[1]/div/div")).click();          // click on "My instructor-Led Training"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "MyInstr-Led");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='Form1']/div[6]/a[2]/div/div")).click();      // click on "Campus Training"
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "CampusTraining");
		driver.navigate().back();	
		Thread.sleep(3000);

	}
	

		
	@AfterMethod
	public void tearDown() {

	driver.quit();
	}
	}


	
