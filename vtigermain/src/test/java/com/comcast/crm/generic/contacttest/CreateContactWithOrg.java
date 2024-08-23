package com.comcast.crm.generic.contacttest;


import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrg {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		//create oBject of  All genericUtility
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		//read the data From Properties File
		String browser=flib.getDataFromPropertiesFiles("browser");
		String url=flib.getDataFromPropertiesFiles("url");
		String username=flib.getDataFromPropertiesFiles("username");
		String password=flib.getDataFromPropertiesFiles("password");
		
		//generating random Number
		int ranup=jlib.getRandomNumber();
		
		//read the data from Excel Sheet
		String orgname=elib.getDataFromExcelFile("contact", 7, 2)+ranup;
		String conname=elib.getDataFromExcelFile("contact", 7, 3)+ranup;
		
		//launching the Browser
		WebDriver driver=null;
		
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else{
			driver=new ChromeDriver();
		}
		//creating the org
		wlib.windowMaximize(driver);
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//verify the org name
		Thread.sleep(2000);
		String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		System.out.println(headerinfo);
		if(headerinfo.contains(orgname)) {
			System.out.println(orgname+" is created====PASS");
		}else {
			System.out.println(orgname+" is not created====FAIL");
		}
		//navigate to the contact Module
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(conname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		//Switch to the Child window
		
		wlib.switchToTabOnURL(driver,"module=Accounts&action" );
		
		//dynamic xpath to search orgname in lookup icon
		
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		//Switch to parent window
		wlib.switchToTabOnTitle(driver,"Contacts" );
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String headerinfo1=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo1.contains(conname)) {
			System.out.println(conname+" is created======PASS");
		}else {
			System.out.println(conname+"is not created=======FAIL");
		}
		String actorgname1=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		
		if(actorgname1.trim().equals(orgname)) {
			System.out.println(orgname+" is verifed====PASS");
		}else {
			System.out.println(orgname+" is not verifed====FAIL");
		}
		Thread.sleep(3000);
		driver.quit();
		
	}

}
