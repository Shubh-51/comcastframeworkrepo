package practice.testng;

import org.testng.annotations.Test;

public class CreateContactWithNOPriorityTest3 {
	@Test()
	public void createContactTest() {
		System.out.println("Execute create contact test-->HDFC");
	}
	
	@Test()
	public void modifyContactTest() {
		//this will not going to take time it will be best approach
		//insert the data into db
		System.out.println("insert the contact directly into DataBase==ICICI");
		System.out.println("Execute modify contact Test-->ICICI=>ICICI_1");
	}
	
	@Test()
	public void deleteContact() {
		//
		System.out.println("insert the contact directly into DataBase===>UPI");
		System.out.println("Execute delete contact Test-->create UPI>> modify UPI_1>>>delete UPI_1");
	}
}
