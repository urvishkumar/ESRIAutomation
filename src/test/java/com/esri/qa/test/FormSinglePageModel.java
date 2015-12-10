package com.esri.qa.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormSinglePageModel {

	static WebDriver driver = null;
	String GoogleEsriurl = "http://cmsqa.esri.com/landing-pages/products/google-lp";
	 
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();  // open firefox
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(GoogleEsriurl);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void singlePageModalTest() throws InterruptedException, IOException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google & Esri");		
	    driver.findElement(By.xpath("//*[@id='ctl3']/div[7]/div/p/span")).click();
	    Thread.sleep(3000);
	    TestUtil.takeScreenShot(driver, "GoogleEsriForm");
		driver.findElement(By.id("txtfname")).sendKeys("Testing-Bob");  
    	driver.findElement(By.id("txtlname")).sendKeys("Winter"); 
    	driver.findElement(By.id("email")).sendKeys("rwinter@esri.com");     	
		driver.findElement(By.id("company")).sendKeys("ESRI"); 
		Thread.sleep(3000);
		List<WebElement> menuList =driver.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all demandbase-company-autocomplete')]//li"));
		System.out.println(menuList.size());
		//menuList.get(3).click();
		for(int i=0;i<menuList.size();i++){
			System.out.println(menuList.get(i).findElement(By.tagName("a")).getText());
			String menuText = menuList.get(i).findElement(By.tagName("a")).getText();
			if(menuText.equals("ESRI (Missoula, MT)")){
				Thread.sleep(3000);
				menuList.get(i).click();
				break;
			}
		}
		driver.findElement(By.id("txtphone")).sendKeys("(909)793-2853x3396"); 		
		driver.findElement(By.id("ddlcountry")).sendKeys("Antarctica"); 
		driver.findElement(By.id("main_0_content_1_txtcomments")).sendKeys("Help! I'm being held against my will by penguins!"); 
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "GoogleEsriFill");
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(3000);
		TestUtil.takeScreenShot(driver, "GoogleEsriDone");
		Thread.sleep(3000);
		    
	}		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}


	
