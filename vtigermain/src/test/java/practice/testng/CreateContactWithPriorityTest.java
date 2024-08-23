package practice.testng;

import org.testng.annotations.Test;

public class CreateContactWithPriorityTest {
	
	//in real we give Priority like this
	
	@Test(priority=1)
	public void createContactTest() {
		System.out.println("Execute create contact test");
	}
	
	@Test(priority=2)
	public void modifyContactTest() {
		System.out.println("Execute modify contact Test");
	}
	
	@Test(priority=3)
	public void deleteContact() {
		System.out.println("Execute delete contact Test");
	}
}
