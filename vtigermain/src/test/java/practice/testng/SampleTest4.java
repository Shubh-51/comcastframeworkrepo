package practice.testng;

import org.testng.annotations.Test;

public class SampleTest4 {
	
	@Test
	public void createContactTest() {
		System.out.println("Exceute that");
	}
	//this method will not be executed 
	//as per the rule of testng return type always be void
	@Test
	public int createContactWithPhoneNumber() {
		System.out.println("Exceute this also");
		return 0;
	}
}
