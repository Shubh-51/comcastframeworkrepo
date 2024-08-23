package practice1.testng.configurationanntotaion;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest4 {
	
	@BeforeSuite
	public void bs() {
		System.out.println("Execute Before Suite");
	}
	
	@BeforeClass
	public void bc() {
		System.out.println("Execute Before Class");
	}
	
	@BeforeMethod
	public void bm() {
		System.out.println("Execute Before Method");
	}
	
	@Test
	public void CreateContact() {
		System.out.println("Create contact is created");
	}
	
	@Test
	public void modifyCreateContact() {
		System.out.println("create contact is modifed");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("Execute After Method");
	}
	
	@AfterClass
	public void Ac() {
		System.out.println("Execute After class");
	}
	
	@AfterSuite
	public void As() {
		System.out.println("Execute After Suite");
	}
}
