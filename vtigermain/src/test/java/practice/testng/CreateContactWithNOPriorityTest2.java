package practice.testng;

import org.testng.annotations.Test;

public class CreateContactWithNOPriorityTest2 {
	@Test()
	public void createContactTest() {
		System.out.println("Execute create contact test-->HDFC");
	}
	
	@Test()
	public void modifyContactTest() {
		System.out.println("Execute modify contact Test-->ICICI=>ICICI_1");
	}
	
	@Test()
	public void deleteContact() {
		System.out.println("Execute delete contact Test-->create UPI>> modify UPI_1>>>delete UPI_1");
	}
}
