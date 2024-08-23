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

public class CreateContactWithSupportDate {

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
		
		
		String conname=elib.getDataFromExcelFile("contact",1, 2)+ranno;
		
		
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
		
		//enter all the details and create new contact with support date.
		
		String startdate=jlib.getSystemDateDDMMYYYY();
		String enddate=jlib.getRequriedDateYYYYMMDD(30);
		System.out.println(startdate);
		System.out.println(enddate);
		
		
		driver.findElement(By.name("lastname")).sendKeys(conname);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(enddate);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(conname)) {
			System.out.println(conname+" is created======PASS");
		}else {
			System.out.println(conname+"is not created=======FAIL");
		}
		String actstartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		String actenddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actstartdate.equals(startdate) && actenddate.equals(enddate)) {
			System.out.println(startdate+" is verified =====PASS");
			System.out.println(enddate+" is verified =====PASS");
		}else {
			System.out.println(startdate+" is not verified =====FAIL");
			System.out.println(enddate+" is not verified =====FAIL");
		}
		Thread.sleep(3000);
		driver.quit();


	}

}
