package practice.testng;

import org.testng.annotations.Test;

public class Contacttest11 {
	
	@Test()
	public void createContactTest() {
		System.out.println("Execute createcontact====>hdfc");
	}
	
	@Test(dependsOnMethods="createContactTest")
	public void modifyContactTest() {
		System.out.println("Execute modifycontact===>hdfc-->icici");
	}
	
	//if you try to execute only third it will execute all
	
	
	@Test(dependsOnMethods="modifyContactTest")
	public void deleteContact() {
		System.out.println("Execute deletecontact====icici");
	}
}
