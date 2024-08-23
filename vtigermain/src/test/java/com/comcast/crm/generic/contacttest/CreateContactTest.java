package com.comcast.crm.generic.contacttest;


import java.io.IOException;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		String browser=flib.getDataFromPropertiesFiles("browser");
		String url=flib.getDataFromPropertiesFiles("url");
		String username=flib.getDataFromPropertiesFiles("username");
		String password=flib.getDataFromPropertiesFiles("password");
		
		
		int ranno=jlib.getRandomNumber();
		
		
		String conname=elib.getDataFromExcelFile("contact", 1, 2)+ranno;
		
		
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(browser.equals("edge")) {
			driver=new FirefoxDriver();
		}else  {
			driver=new ChromeDriver();
		}
		wlib.windowMaximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(conname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(conname)) {
			System.out.println(conname+" is created======PASS");
		}else {
			System.out.println(conname+"is not created=======FAIL");
		}
		String actconname=driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actconname.equals(conname)) {
			System.out.println(conname+" is verifed====PASS");
		}else {
			System.out.println(conname+" is not verifed====FAIL");
		}
		
	}

}
