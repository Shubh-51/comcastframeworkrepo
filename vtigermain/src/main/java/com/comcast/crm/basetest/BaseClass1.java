package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;

public class BaseClass1 {

	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	//making object creation as public b/e we want to access in different package
	
	public FileUtility flib=new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public ExcelUtility elib=new ExcelUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public DatabaseUtility dblib=new DatabaseUtility();
	
	
	@BeforeSuite(groups={"smoketest","regressiontest"})
	public void bs() throws SQLException {
		System.out.println("=========connection Db,Reportcofig");
		dblib.getDbConnection();
	}
	
	
	@BeforeClass(groups={"smoketest","regressiontest"})
	public void bc() throws IOException {
		System.out.println("======Lauch The browser======");
		String browser=flib.getDataFromPropertiesFiles("browser");
		
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
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod(groups={"smoketest","regressiontest"})
	public void bm() throws IOException {
		System.out.println("=========login=========");
		String url=flib.getDataFromPropertiesFiles("url");
		String username=flib.getDataFromPropertiesFiles("username");
		String password=flib.getDataFromPropertiesFiles("password");
	 LoginPage lp=new LoginPage(driver);
		lp.loginToApp(url, username, password);
	}
	@AfterMethod(groups={"smoketest","regressiontest"})
	public void am() {
		System.out.println("===============logout============");
		 HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups={"smoketest","regressiontest"})
	public void Ac() {
		System.out.println("======Close the Browser=======");
		driver.quit();
	}
	
	@AfterSuite(groups={"smoketest","regressiontest"})
	public void As() throws SQLException {
		System.out.println("====Close DB,Report Backup=====");
		
		dblib.CloseDbConnection();
		
	}
}
