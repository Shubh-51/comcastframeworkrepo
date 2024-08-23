package practice1.testng.configurationanntotaion;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTest1 {
	
	@Test
	public void CreateContact() {
		System.out.println("Create contact is created");
	}
	
	//changing the order of @BeforeMethod
	// but @before got executed first than @Test
	//configuration annotations not going to execute if there is no @Test method Annotation
	
	@BeforeMethod
	public void bm() {
		System.out.println("Execute Before Method");
	}
	@AfterMethod
	public void am() {
		System.out.println("Execute After Method");
	}
	
}
