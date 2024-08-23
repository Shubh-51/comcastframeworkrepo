package practice1.testng.configurationanntotaion;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTest {
	@BeforeMethod
	public void bm() {
		System.out.println("Execute Before Method");
	}
	@Test
	public void CreateContact() {
		System.out.println("Create contact is created");
	}
}
