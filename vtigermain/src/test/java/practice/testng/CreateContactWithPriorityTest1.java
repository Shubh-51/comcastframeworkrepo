package practice.testng;

import org.testng.annotations.Test;

public class CreateContactWithPriorityTest1 {

	@Test(priority=1)
	public void createContactTest() {
		System.out.println("Execute create contact test-->HDFC");
	}
	
	@Test(priority=2)
	public void modifyContactTest() {
		System.out.println("Execute modify contact Test-->HDFC=>ICICI");
	}
	
	@Test(priority=3)
	public void deleteContact() {
		System.out.println("Execute delete contact Test-->ICICI");
	}
}
