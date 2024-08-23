package com.comcast.crm.generic.orgtest;


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


public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String browser=flib.getDataFromPropertiesFiles("browser");
		String url=flib.getDataFromPropertiesFiles("url");
		String username=flib.getDataFromPropertiesFiles("username");
		String password=flib.getDataFromPropertiesFiles("password");
		
		
		int ranup=jlib.getRandomNumber();
		
		
		String orgname=elib.getDataFromExcelFile("org", 1, 2)+ranup;
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
		wlib.windowMaximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify header msg expected result
		String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains("orgname")) {
			System.out.println(orgname+" is created====PASS");
		}else {
			System.out.println(orgname+" is not created====FAIL");
		}
		
		//verify org name info
		String actualorgname=driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actualorgname.equals(orgname)) {
			System.out.println(orgname+" is created=======PASS");
		}else {
			System.out.println(orgname+" is not created====FAIL");
		}
		/*WebElement admin=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		Actions act=new Actions(driver);
		act.moveToElement(admin).perform();
		driver.findElement(By.partialLinkText("Out")).click();
		*/
		Thread.sleep(3000);
		driver.quit();
	}

}
