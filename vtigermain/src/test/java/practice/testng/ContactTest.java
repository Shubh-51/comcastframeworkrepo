package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	
	//All will be Execute in alphabetically order
	
	@Test
	public void createContactTest() {
		System.out.println("Execute create contact test");
	}
	
	@Test
	public void modifyContactTest() {
		System.out.println("Execute modify contact Test");
	}
	
	@Test
	public void deleteContact() {
		System.out.println("Execute delete contact Test");
	}
}
