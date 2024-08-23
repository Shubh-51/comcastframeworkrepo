package practice.testng;

import org.testng.annotations.Test;

public class SampleTest2 {
	@Test()
	public void createContactTest() {
		System.out.println("Exceute that");
	}
	// this method will assume as a java Method 
	//you call this method this not get executed
	public void createContactWithPhoneNumber() {
		System.out.println("Exceute this also");
	}
}
