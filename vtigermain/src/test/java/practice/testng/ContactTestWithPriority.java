package practice.testng;

import org.testng.annotations.Test;

public class ContactTestWithPriority {
	//in real selenium test we can not do that
	//we don't start priority with negative number
	@Test(priority=-4)
	public void createContactTest() {
		System.out.println("Execute create contact test");
	}
	
	@Test(priority=-3)
	public void modifyContactTest() {
		System.out.println("Execute modify contact Test");
	}
	
	@Test(priority=-2)
	public void deleteContact() {
		System.out.println("Execute delete contact Test");
	}
}
