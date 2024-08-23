package pactice.extentreport.screenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LogTheScreenshotInsideExtentReport1 {
public ExtentReports report=null;
	
	@BeforeSuite
	public void ConfigBS() {
		//spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/reportScreenshot1.html");
		spark.config().setDocumentTitle("CRM Suite Result");
		spark.config().setReportName("CRMReport");
		spark.config().setTheme(Theme.DARK);
		
		//add environment information
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Window-11");
		report.setSystemInfo("Browser","Browser-120");
		
	}
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
	@Test
	public void createContactTest() {
		ExtentTest test=report.createTest("createContactTest");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		//Take ScreenShot
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		
		test.log(Status.INFO,"logoin to the application");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("hdfc".equals("hdc")) {
			test.log(Status.PASS,"logoin to the application");	
		}else {
			test.addScreenCaptureFromBase64String(filepath,"ErrorFile");
		}
		driver.close();
		
		
	}
	
}
