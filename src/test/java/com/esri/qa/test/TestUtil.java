package com.esri.qa.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {

	
	public static void takeScreenShot(WebDriver driver, String fileName) throws IOException{
	
	String path = "C:\\Users\\cont_urvi\\workspace\\ESRITest\\Screenshots\\"+fileName;	
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrFile, new File(path));
	}

}
