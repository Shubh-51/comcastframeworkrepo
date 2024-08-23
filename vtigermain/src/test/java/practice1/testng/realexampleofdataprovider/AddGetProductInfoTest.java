package practice1.testng.realexampleofdataprovider;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.excelutility.ExcelUtility;

public class AddGetProductInfoTest {
	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandname,String productname) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		//Search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		
		//capture Product info
		String x="//span[text()='"+productname+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span[1]/span[2]/span[2]";
		
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
		
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		ExcelUtility elib=new ExcelUtility();
		int rowcount=elib.getRowCount("product");
		
		//[] 1st denote number of row
		//[] 2nd denote number of column
		
		Object[][] arr=new Object[rowcount][2];
		
		//here we not start i from 1 because in this case arr start with 1 and in
		// zero index no data will be filled
		
		for(int i=0;i<rowcount;i++) {
			arr[i][0]=elib.getDataFromExcelFile("product",i+1, 0);
			arr[i][1]=elib.getDataFromExcelFile("product", i+1, 1);
		}
		
		
	return arr;
	}
	
}
