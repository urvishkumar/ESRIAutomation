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

public class MapsZiptapestry {

	static WebDriver driver = null;
	String MapsZiptapestryURL = "http://cmsqa.esri.com/data/esri_data/ziptapestry";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(MapsZiptapestryURL);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void mapsZiptapestryTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Esri ZIP Code Lookup | Demographics and Lifestyle by ZIP Code");	
		TestUtil.takeScreenShot(driver, "mapsZiptapestry");
		driver.findElement(By.id("zipCodeInput")).sendKeys("92373");                 // enter zip code
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Zip");
		driver.findElement(By.id("zipCodeSearchBtn")).click();                     // click on search
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='map-container_zoom_slider']/div[1]")).click();   // click on +
		driver.findElement(By.xpath("//*[@id='map-container_zoom_slider']/div[1]")).click();  // click on +
		Thread.sleep(5000);
	    TestUtil.takeScreenShot(driver, "zoom+");
	
		driver.findElement(By.xpath("//*[@id='map-container_zoom_slider']/div[2]")).click();   // click on -
		driver.findElement(By.xpath("//*[@id='map-container_zoom_slider']/div[2]")).click();   // click on -
		Thread.sleep(5000);
	    TestUtil.takeScreenShot(driver, "zoom-");
		driver.findElement(By.xpath("//*[@id='nav-container']/div[1]/ul/li[2]")).click();    // click on Income
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Income");
		driver.findElement(By.xpath("//*[@id='nav-container']/div[1]/ul/li[3]")).click();    // click on Age
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Age");
		driver.findElement(By.xpath("//*[@id='nav-container']/div[1]/ul/li[4]")).click();    //click on Population Density
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Population");
		driver.findElement(By.xpath("//*[@id='nav-container']/div[1]/ul/li[1]")).click();     // click on Tapestry  
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Tapestry");
		driver.findElement(By.xpath("//*[@id='nav-container']/div[4]/div[2]/div[1]")).click();   // click on "More about Tapestry"
		
//click on More about Tapestry then open new tab		
		  Set<String> handler =  driver.getWindowHandles();		  
		  Iterator<String> it = handler.iterator();		  
		  String main_window_id = it.next();
		  System.out.println("main window id----> "+main_window_id);		  
		  String popup_window_id = it.next();
		  System.out.println("pop up window is----> "+popup_window_id);		  
		  driver.switchTo().window(popup_window_id);
		  System.out.println("title of popup window--->"+ driver.getTitle());		  
          driver.close();		  
	      driver.switchTo().window(main_window_id);
	      System.out.println("title of main window ---->"+driver.getTitle());	      
	      driver.findElement(By.xpath("//*[@id='nav-container']/div[4]/div[2]/div[2]")).click();     // click on contact Us
	      Thread.sleep(3000);
		    TestUtil.takeScreenShot(driver, "Contactuss");
// Fillout the form	      
	      driver.findElement(By.id("txtfname")).sendKeys("Testing - Bob"); 
	      driver.findElement(By.id("txtlname")).sendKeys("Winter");
	      driver.findElement(By.id("email")).sendKeys("rwinter@esri.com");
	      driver.findElement(By.id("txtphone")).sendKeys("(909)793-2853");
	      driver.findElement(By.id("txtext")).sendKeys("3396");
	      driver.findElement(By.id("company")).sendKeys(" ESRI (Missoula, MT)");
	      driver.findElement(By.id("txtcity")).sendKeys("Redlands");
	      driver.findElement(By.id("ddlstate")).sendKeys("California");
	      driver.findElement(By.id("txtzip")).sendKeys("92373");
	      driver.findElement(By.id("ddlcountry")).sendKeys("United States");
	      driver.findElement(By.id("tapestry and demographic data")).click();
	      driver.findElement(By.id("main_0_content_1_txtcomments")).sendKeys("Testing");
	      Thread.sleep(3000);
		    TestUtil.takeScreenShot(driver, "zipFormfill");
	      driver.findElement(By.id("btnSubmit")).click();
	      Thread.sleep(5000);
		    TestUtil.takeScreenShot(driver, "ZopFormDone");
	      driver.findElement(By.id("confirmationClose")).click();
// Click on Social media icon      
	      driver.findElement(By.xpath("//*[@id='nav-container']/div[4]/div[3]/span[1]/span/span")).click();      //Facebook 
	      Thread.sleep(5000);
	      TestUtil.takeScreenShot(driver, "Facebook");
	      driver.findElement(By.xpath("//*[@id='nav-container']/div[4]/div[3]/span[2]/span/span")).click();      //Twitter
		  driver.findElement(By.xpath("//*[@id='nav-container']/div[4]/div[3]/span[3]/span/span")).click();      //Linkedin
		  driver.findElement(By.xpath("//*[@id='nav-container']/div[4]/div[3]/a/span")).click();                 //Email
		   Thread.sleep(5000);	      
	}		
	@AfterMethod
	public void tearDown() {

	driver.quit();
	}
	}


	
