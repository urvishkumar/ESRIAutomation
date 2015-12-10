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

public class MapsDisasterWildlifeNews {

	static WebDriver driver = null;
	String MapsDisasterWildlifeNewsURL = "http://cmsqa.esri.com/services/disaster-response/wildlandfire/latest-news-map";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(MapsDisasterWildlifeNewsURL);
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void mapsDisasterWildlifeTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Wildfire Map & Satellite Images | Wildfire Disaster Interactive Map");			
// click on open full map	
	    driver.findElement(By.linkText("Open the full map")).click(); 
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "FullMap");	    
	    
	      Set<String> handler =  driver.getWindowHandles();		  
	      Iterator<String> it = handler.iterator();		  
		  String main_window_id = it.next();
		  System.out.println("main window id----> "+main_window_id);		  
		  String popup_window_id = it.next();
		  driver.switchTo().window(popup_window_id);
	      System.out.println("title of popup window--->"+ driver.getTitle());		  
          driver.close();
          driver.switchTo().window(main_window_id);
		
// 	click on search	
		driver.switchTo().frame(0);	
		driver.findElement(By.id("geocoderSearch_input")).sendKeys("92373");       
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "ZipCode");
		driver.findElement(By.xpath("//*[@id='geocoderSearch']/div/div[2]/span[1]")).click();
		Thread.sleep(5000);
//zoom in , out, home		
		driver.findElement(By.xpath("//*[@id='mapDiv_zoom_slider']/div[1]")).click();
		Thread.sleep(5000);
	    TestUtil.takeScreenShot(driver, "zoomin");
		driver.findElement(By.xpath("//*[@id='mapDiv_zoom_slider']/div[2]")).click();
		Thread.sleep(5000);
	    TestUtil.takeScreenShot(driver, "zoomout");
		driver.findElement(By.xpath("//*[@id='HomeButton']/div/div")).click();
		Thread.sleep(5000);
	    TestUtil.takeScreenShot(driver, "Home");
// About,Layers	
		driver.findElement(By.xpath("//*[@id='drawer_menus']/div[1]/div[2]/div/div[1]")).click();   
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "About");		
	    driver.findElement(By.xpath("//*[@id='drawer_menus']/div[1]/div[3]/div")).click();     
		Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "Layers");
	    Thread.sleep(3000);
	}		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}


	
