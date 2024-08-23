package practice.testng;

import org.testng.annotations.Test;

public class SampleTest5 {
	@Test
	public void createContactTest() {
		System.out.println("Exceute that");
	}
	//access modifier will be changed
	//access modifier can be any 
	//but it is not advisable to changed it from public to any other
	@Test
	private int createContactWithPhoneNumber() {
		System.out.println("Exceute this also");
		return 0;
	}
}
