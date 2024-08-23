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
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationPage;

public class DeleteOrgTest {
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
		
		
		String orgname=elib.getDataFromExcelFile("org", 10, 2)+ranup;
		//String indusrty=elib.getDataFromExcelFile("org",1, 3).toString();
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
		//Step1:login to application
		wlib.windowMaximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(username, password);
		//Step2:navigate to Organization page
		HomePage hp=new HomePage(driver);
		
		hp.getOrglink().click();
		//if you want naviagte to campaign module call business method
		//because it required more than one action
		//hp.NavigateToCampaignPage();
		
		//Step3:click on "CreateOrganization" Button
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateneworgbutton().click();
		
		//Step4:enter all the details and Create new Organization
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgname);
		
		//cnop.createOrg(orgname, indusrty);
		
		
		//Step5:verify the org name
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String headerinfo=oip.getHeaderinfo().getText();
		if(headerinfo.contains(orgname)) {
			System.out.println(orgname+" is verifed====PASS");
		}else {
			System.out.println(orgname+" is not verifed====FAIL");
		}
		
		//Step6: Go back To Organization Page
		
			hp.getOrglink().click();
			
		//Search for Organiztion
			
			op.getSearchedit().sendKeys(orgname);
			wlib.select(op.getSearchdd(), "Organization Name");
			op.getSearchbtn().click();
		
		//in dynamic Webtable select and Delete org test
		//This is called dynamic xpath
			
	driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
			wlib.switchToAlertAndAccept(driver);
			
	//	hp.logout();
		Thread.sleep(3000);
	driver.quit();	
	}
}
